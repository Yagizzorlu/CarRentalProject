package schoolproject.RentACarProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import schoolproject.RentACarProject.business.abstracts.CarService;
import schoolproject.RentACarProject.core.utilities.results.DataResult;
import schoolproject.RentACarProject.core.utilities.results.Result;
import schoolproject.RentACarProject.core.utilities.results.SuccessDataResult;
import schoolproject.RentACarProject.core.utilities.results.SuccessResult;
import schoolproject.RentACarProject.dataAccess.abstracts.CarDao;
import schoolproject.RentACarProject.entities.concretes.Car;
import schoolproject.RentACarProject.entities.dtos.CarWithBrandDto;
import schoolproject.RentACarProject.entities.dtos.CarWithColorDto;
import schoolproject.RentACarProject.entities.dtos.CarWithModelDto;

@Service
public class CarManager implements CarService {

	private CarDao carDao;
	
	@Autowired
	public CarManager(CarDao carDao) {
		super();
		this.carDao = carDao;
	}

	@Override
	public DataResult<List<Car>> getAll() {
		return new SuccessDataResult<List<Car>>
		(this.carDao.findAll(),("Data Listelendi."));
	}
	
	public Result add(Car car) {
		this.carDao.save(car);
		return new SuccessResult("Araba Eklendi.");
	}
	
	public DataResult<List<Car>> getByIdAndBrand(int id, int brandId) {
        return new SuccessDataResult<List<Car>>
        (carDao.getByIdAndBrand(id, brandId),"Data Listelendi");
    }

	@Override
	public DataResult<Car> getByDescription(String description) {
		return new SuccessDataResult<Car>
		(carDao.getByDescription(description), "Data Listelendi.");
	}

	@Override
	public DataResult<List<Car>> getByModelIn(List<Integer> models) {
		return new SuccessDataResult<List<Car>>
		(this.carDao.getByModelIn(models),"Data listelendi");
	}
	
	@Override
	public DataResult<List<Car>> getByColorIn(List<Integer> colors) {
		return new SuccessDataResult<List<Car>>
		(this.carDao.getByColorIn(colors),"Data listelendi");
	}
	
	@Override
	public DataResult<List<Car>> getByBrandIn(List<Integer> brands) {
		return new SuccessDataResult<List<Car>>
		(this.carDao.getByBrandIn(brands),"Data listelendi");
	}

	@Override
	public DataResult<List<Car>> getByIdAndModel(int id, int modelId) {
		return new SuccessDataResult<List<Car>>
        (carDao.getByIdAndModel(id, modelId),"Data Listelendi");
	}

	@Override
	public DataResult<List<Car>> getByIdAndColor(int id, int colorId) {
		return new SuccessDataResult<List<Car>>
        (carDao.getByIdAndColor(id, colorId),"Data Listelendi");
	}

	@Override
	public DataResult<List<Car>> getByDescriptionContains(String description) {
		return new SuccessDataResult<List<Car>>
		(this.carDao.getByDescriptionContains(description),"Data listelendi");
	}

	@Override
	public DataResult<List<Car>> getByDescriptionStartsWith(String description) {
		return new SuccessDataResult<List<Car>>
		(this.carDao.getByDescriptionStartsWith(description),"Data listelendi");
	}

	@Override
	public DataResult<Car> getById(int id) {
		return new SuccessDataResult<Car>
		(carDao.getById(id), "Data Listelendi.");
	}

	@Override
	public DataResult<Car> getByModelYear(int modelYear) {
		return new SuccessDataResult<Car>
		(carDao.getByModelYear(modelYear), "Data Listelendi.");
	}

	@Override
	public DataResult<Car> getByDailyPrice(double dailyPrice) {
		return new SuccessDataResult<Car>
		(carDao.getByDailyPrice(dailyPrice), "Data Listelendi.");
	}

	@Override
	public DataResult<List<Car>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return new SuccessDataResult<List<Car>> 
		(carDao.findAll(pageable).getContent());
	}

	@Override
	public DataResult<List<Car>> getAllSortedDESC() {
		Sort sort = Sort.by(Sort.Direction.DESC,"id");
		return new SuccessDataResult<List<Car>>
		(this.carDao.findAll(sort),"Başarılı Sıralandı.");
	}
	
	@Override
	public DataResult<List<Car>> getAllSortedASC() {
		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		return new SuccessDataResult<List<Car>>
		(this.carDao.findAll(sort),"Başarılı Sıralandı.");
	}

	@Override
	public DataResult<List<Car>> getAllSortedModelYear() {
		Sort sort = Sort.by(Sort.Direction.DESC,"modelYear");
		return new SuccessDataResult<List<Car>>
		(this.carDao.findAll(sort),"Başarılı Sıralandı.");
	}

	@Override
	public DataResult<List<Car>> getAllSortedDailyPrice() {
		Sort sort = Sort.by(Sort.Direction.DESC,"DailyPrice");
		return new SuccessDataResult<List<Car>>
		(this.carDao.findAll(sort),"Başarılı Sıralandı.");
	}

	@Override
	public DataResult<List<CarWithBrandDto>> getCarWithBrandDetails() {
		return new SuccessDataResult<List<CarWithBrandDto>>
		(this.carDao.getCarWithBrandDetails(),"Data Listelendi.");
	}

	@Override
	public DataResult<List<CarWithColorDto>> getCarWithColorDetails() {
		return new SuccessDataResult<List<CarWithColorDto>>
		(this.carDao.getCarWithColorDetails(),"Data Listelendi.");
	}

	@Override
	public DataResult<List<CarWithModelDto>> getCarWithModelDetails() {
		return new SuccessDataResult<List<CarWithModelDto>>
		(this.carDao.getCarWithModelDetails(),"Data Listelendi.");
	}

}
