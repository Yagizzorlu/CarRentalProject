package schoolproject.RentACarProject.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import schoolproject.RentACarProject.business.abstracts.ModelService;
import schoolproject.RentACarProject.core.utilities.results.DataResult;
import schoolproject.RentACarProject.core.utilities.results.ErrorDataResult;
import schoolproject.RentACarProject.entities.concretes.Model;
import schoolproject.RentACarProject.entities.dtos.ModelWithBrandDto;

@RestController
@RequestMapping("api/models")
public class ModelsController {
	
	private ModelService modelService;

	@Autowired
	public ModelsController(ModelService modelService) {
		super();
		this.modelService = modelService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Model>> getAll() {
		return this.modelService.getAll();
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@Valid @RequestBody Model model) {
		return ResponseEntity.ok(this.modelService.add(model));
	}
	
	@GetMapping("/getByNameContains")
	public DataResult<List<Model>> getByNameContains(@RequestParam String name){
		return this.modelService.getByNameContains(name);
	}
	
	@GetMapping("/getByName")
	public DataResult<Model> getByName(@RequestParam String name){
		return this.modelService.getByName(name);
	}
	
	@GetMapping("/getByNameOrId")
	public DataResult<List<Model>> getByNameOrId(@RequestParam String name,@RequestParam int id ){	
		return this.modelService.getByNameOrId(name, id);
	}
	
	@GetMapping("/getByIdAndBrand")
	public DataResult<List<Model>> 
	getByIdAndBrand(@RequestParam("id") int id,@RequestParam("brandId") int brandId){
		System.out.println(id);
		System.out.println(brandId);
		return this.modelService.getByIdAndBrand
				(id, brandId);
	}
	
	@GetMapping("/getByNameAndBrand")
	public DataResult<List<Model>> 
	getByIdAndBrand(@RequestParam("name") String name,@RequestParam("brandId") int brandId){
		System.out.println(name);
		System.out.println(brandId);
		return this.modelService.getByNameAndBrand
				(name, brandId);
	}
	
	@GetMapping("/getAllDesc")
	public DataResult<List<Model>> getAllSortedDESC() {
		return this.modelService.getAllSortedDESC();
	}
	
	@GetMapping("/getAllAsc")
	public DataResult<List<Model>> getAllSortedASC() {
		return this.modelService.getAllSortedASC();
	}
	
	@GetMapping("/getAllByBrandDesc")
	public DataResult<List<Model>> getAllSortedByBrandDESC() {
		return this.modelService.getAllSortedByBrandDESC();
	}
	
	@GetMapping("/getAllByBrandAsc")
	public DataResult<List<Model>> getAllSortedByBrandASC() {
		return this.modelService.getAllSortedByBrandDESC();
	}
	
	@GetMapping("/getAllSortedByName")
	public DataResult<List<Model>> getAllSortedByName() {
		return this.modelService.getAllSortedByName();
	}
	
	@GetMapping("/getModelWithBrandDetails")         
	public DataResult<List<ModelWithBrandDto>> getModelWithBrandDetails() {
		return this.modelService.getModelWithBrandDetails();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
		return errors;
	}
}
