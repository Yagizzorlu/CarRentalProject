package schoolproject.RentACarProject.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import schoolproject.RentACarProject.business.abstracts.BrandService;
import schoolproject.RentACarProject.core.utilities.results.DataResult;
import schoolproject.RentACarProject.core.utilities.results.ErrorDataResult;
import schoolproject.RentACarProject.entities.concretes.Brand;

@RestController
@RequestMapping("api/brands")
@CrossOrigin
public class BrandsController {
	
	private BrandService brandService;

	@Autowired
	public BrandsController(BrandService brandService) {
		super();
		this.brandService = brandService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Brand>> getAll() {
		return this.brandService.getAll();
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@Valid @RequestBody Brand brand) {
		return ResponseEntity.ok(this.brandService.add(brand));
	}
	
	@GetMapping("/getByNameContains")
	public DataResult<List<Brand>> getByNameContains(@RequestParam String name){
		return this.brandService.getByNameContains(name);
	}
	
	@GetMapping("/getByName")
	public DataResult<Brand> getByName(@RequestParam String name){
		return this.brandService.getByName(name);
	}
	
	@GetMapping("/getByNameAndId")
	public DataResult<Brand> getByNameAndId(@RequestParam String name,@RequestParam int id ){	
		return this.brandService.getByNameAndId(name, id);
	}
	
	@GetMapping("/getAllSortedDesc")
	public DataResult<List<Brand>> getAllSortedDESC() {
		return this.brandService.getAllSortedDESC();
	}
	
	@GetMapping("/getAllSortedAsc")
	public DataResult<List<Brand>> getAllSortedASC() {
		return this.brandService.getAllSortedASC();
	}
	
	@GetMapping("/getAllSortedByName")
	public DataResult<List<Brand>> getAllSortedByName() {
		return this.brandService.getAllSortedByName();
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
