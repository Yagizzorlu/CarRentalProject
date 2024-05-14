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
import schoolproject.RentACarProject.business.abstracts.CarService;
import schoolproject.RentACarProject.core.utilities.results.DataResult;
import schoolproject.RentACarProject.core.utilities.results.ErrorDataResult;
import schoolproject.RentACarProject.entities.concretes.Car;
import schoolproject.RentACarProject.entities.dtos.CarWithBrandDto;
import schoolproject.RentACarProject.entities.dtos.CarWithColorDto;
import schoolproject.RentACarProject.entities.dtos.CarWithModelDto;

@RestController   //Java olmayan da tanıyor.
@RequestMapping("api/cars")
@CrossOrigin
public class CarsController {
	
	private CarService carService;
	
	@Autowired   
	public CarsController(CarService carService) {
		super();
		this.carService = carService;
	}

	@GetMapping("/getall")             //   api/cars/getall
	public DataResult<List<Car>> getAll() {
		return this.carService.getAll();
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@Valid @RequestBody Car car) {
		return ResponseEntity.ok(this.carService.add(car));
	}
	
	@GetMapping("/getByDescriptionContains")
	public DataResult<List<Car>> getByDescriptionContains(@RequestParam String description){
		return this.carService.getByDescriptionContains(description);
	}
	
	@GetMapping("/getByIdAndModel")
	public DataResult<List<Car>> 
	getByIdAndModel(@RequestParam("id") int id,@RequestParam("modelId") int modelId){
		System.out.println(id);
		System.out.println(modelId);
		return this.carService.getByIdAndModel
				(id, modelId);
	}
	
	@GetMapping("/getByDescription")
	public DataResult<Car> getByDescription(@RequestParam String description){
		return this.carService.getByDescription(description);
	}
	
	@GetMapping("/getByIdAndColor")
	public DataResult<List<Car>> 
	getByIdAndColor(@RequestParam("id") int id,@RequestParam("colorId") int colorId){
		System.out.println(id);
		System.out.println(colorId);
		
		return this.carService.getByIdAndColor
				(id, colorId);
	}
	
	@GetMapping("/getByIdAndBrand")
	public DataResult<List<Car>> 
	getByIdAndBrand(@RequestParam("id") int id,@RequestParam("brandId") int brandId){
		System.out.println(id);
		System.out.println(brandId);
		
		return this.carService.getByIdAndBrand
				(id, brandId);
	}
	@GetMapping("/getAllByPage")
	public DataResult<List<Car>> getAll(int pageNo , int pageSize) {
		return this.carService.getAll(pageNo-1 , pageSize);
	}
	
	@GetMapping("/getAllDesc")
	public DataResult<List<Car>> getAllSortedDESC() {
		return this.carService.getAllSortedDESC();
	}
	
	@GetMapping("/getAllAsc")
	public DataResult<List<Car>> getAllSortedASC() {
		return this.carService.getAllSortedASC();
	}
	
	@GetMapping("/getAllModelYear")
	public DataResult<List<Car>> getAllSortedModelYear() {
		return this.carService.getAllSortedModelYear();
	}
	
	@GetMapping("/getAllDailyPrice")
	public DataResult<List<Car>> getAllSortedDailyPrice() {
		return this.carService.getAllSortedDailyPrice();
	}
	
	@GetMapping("/getCarWithBrandDetails")         
	public DataResult<List<CarWithBrandDto>> getCarWithBrandDetails() {
		return this.carService.getCarWithBrandDetails();
	}
	
	@GetMapping("/getCarWithColorDetails")         
	public DataResult<List<CarWithColorDto>> getCarWithColorDetails() {
		return this.carService.getCarWithColorDetails();
	}
	
	@GetMapping("/getCarWithModelDetails")         
	public DataResult<List<CarWithModelDto>> getCarWithModelDetails() {
		return this.carService.getCarWithModelDetails();
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
