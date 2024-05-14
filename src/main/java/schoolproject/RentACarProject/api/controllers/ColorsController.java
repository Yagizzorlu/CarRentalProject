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
import schoolproject.RentACarProject.business.abstracts.ColorService;
import schoolproject.RentACarProject.core.utilities.results.DataResult;
import schoolproject.RentACarProject.core.utilities.results.ErrorDataResult;
import schoolproject.RentACarProject.entities.concretes.Color;

@RestController
@RequestMapping("api/colors")
public class ColorsController {
	
	private ColorService colorService;

	@Autowired
	public ColorsController(ColorService colorService) {
		super();
		this.colorService = colorService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Color>> getAll() {
		return this.colorService.getAll();
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@Valid @RequestBody Color color) {
		return ResponseEntity.ok(this.colorService.add(color));
	}
	
	@GetMapping("/getByNameContains")
	public DataResult<List<Color>> getByNameContains(@RequestParam String name){
		return this.colorService.getByNameContains(name);
	}
	
	@GetMapping("/getByName")
	public DataResult<Color> getByName(@RequestParam String name){
		return this.colorService.getByName(name);
	}
	
	@GetMapping("/getByNameAndId")
	public DataResult<Color> getByNameAndId(@RequestParam String name,@RequestParam int id ){	
		return this.colorService.getByNameAndId(name, id);
	}
	
	@GetMapping("/getAllSortedDesc")
	public DataResult<List<Color>> getAllSortedDESC() {
		return this.colorService.getAllSortedDESC();
	}
	
	@GetMapping("/getAllSortedAsc")
	public DataResult<List<Color>> getAllSortedASC() {
		return this.colorService.getAllSortedASC();
	}
	
	@GetMapping("/getAllSortedByName")
	public DataResult<List<Color>> getAllSortedByName() {
		return this.colorService.getAllSortedByName();
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
