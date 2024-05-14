package schoolproject.RentACarProject.business.abstracts;

import java.util.List;

import schoolproject.RentACarProject.core.utilities.results.DataResult;
import schoolproject.RentACarProject.core.utilities.results.Result;
import schoolproject.RentACarProject.entities.concretes.Car;
import schoolproject.RentACarProject.entities.dtos.CarWithBrandDto;
import schoolproject.RentACarProject.entities.dtos.CarWithColorDto;
import schoolproject.RentACarProject.entities.dtos.CarWithModelDto;

public interface CarService {
	DataResult<List<Car>> getAll();
	
	DataResult<List<Car>> getAllSortedDESC();  //Datayı istediğim şartla sıralasın
	
	DataResult<List<Car>> getAllSortedASC();
	
	DataResult<List<Car>> getAllSortedModelYear();
	
	DataResult<List<Car>> getAllSortedDailyPrice();
	
	DataResult<List<Car>> getAll(int pageNo, int pageSize);
	
	Result add(Car car);
	
	DataResult<List<Car>> getByIdAndBrand(int id, int brandId);
	
	DataResult<Car> getByDescription(String description);
	
	DataResult<Car> getById(int id);

	DataResult<Car> getByModelYear(int modelYear);
	
	DataResult<Car> getByDailyPrice(double dailyPrice);
	
	DataResult<List<Car>> getByModelIn(List<Integer> models);
	
	DataResult<List<Car>> getByColorIn(List<Integer> colors);
	
	DataResult<List<Car>> getByBrandIn(List<Integer> brands);
	
	DataResult<List<Car>> getByIdAndModel(int id, int modelId);
	
	DataResult<List<Car>> getByIdAndColor(int id, int colorId);
	
	DataResult<List<Car>> getByDescriptionContains(String description);
	
    DataResult<List<Car>> getByDescriptionStartsWith(String description);
    
    DataResult<List<CarWithBrandDto>> getCarWithBrandDetails();
    
    DataResult<List<CarWithColorDto>> getCarWithColorDetails();
    
    DataResult<List<CarWithModelDto>> getCarWithModelDetails();
    
}
