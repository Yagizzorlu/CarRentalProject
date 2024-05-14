package schoolproject.RentACarProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import schoolproject.RentACarProject.business.abstracts.BrandService;
import schoolproject.RentACarProject.core.utilities.results.DataResult;
import schoolproject.RentACarProject.core.utilities.results.Result;
import schoolproject.RentACarProject.core.utilities.results.SuccessDataResult;
import schoolproject.RentACarProject.core.utilities.results.SuccessResult;
import schoolproject.RentACarProject.dataAccess.abstracts.BrandDao;
import schoolproject.RentACarProject.entities.concretes.Brand;

@Service
public class BrandManager implements BrandService {

	private BrandDao brandDao;
	
	@Autowired
	public BrandManager(BrandDao brandDao) {
		super();
		this.brandDao = brandDao;
	}


	@Override
	public DataResult<List<Brand>> getAll() {
		return new SuccessDataResult<List<Brand>>
		(this.brandDao.findAll(),("Data Listelendi."));
	}
	
	public Result add(Brand brand) {
		this.brandDao.save(brand);
		return new SuccessResult("Marka Eklendi.");
	}


	@Override
	public DataResult<Brand> getByName(String name) {
		return new SuccessDataResult<Brand>
		(brandDao.getByName(name), "Data Listelendi.");
	}


	@Override
	public DataResult<Brand> getById(int id) {
		return new SuccessDataResult<Brand>
		(brandDao.getById(id), "Data Listelendi.");
	}


	@Override
	public DataResult<Brand> getByNameAndId(String name, int id) {
		return new SuccessDataResult<Brand>
		(brandDao.getByNameAndId(name , id), "Data Listelendi.");
	}


	@Override
	public DataResult<List<Brand>> getByNameOrId(String name, int id) {
		return new SuccessDataResult<List<Brand>>
		(brandDao.getByNameOrId(name , id), "Data Listelendi.");
	}


	@Override
	public DataResult<List<Brand>> getByNameContains(String name) {
		return new SuccessDataResult<List<Brand>>
		(this.brandDao.getByNameContains(name),"Data listelendi");
	}

	@Override
	public DataResult<List<Brand>> getByNameStartsWith(String name) {
		return new SuccessDataResult<List<Brand>>
		(this.brandDao.getByNameStartsWith(name),"Data listelendi");
	}


	@Override
	public DataResult<List<Brand>> getAllSortedDESC() {
		Sort sort = Sort.by(Sort.Direction.DESC,"id");
		return new SuccessDataResult<List<Brand>>
		(this.brandDao.findAll(sort),"Başarılı Sıralandı.");
	}


	@Override
	public DataResult<List<Brand>> getAllSortedASC() {
		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		return new SuccessDataResult<List<Brand>>
		(this.brandDao.findAll(sort),"Başarılı Sıralandı.");
	}


	@Override
	public DataResult<List<Brand>> getAllSortedByName() {
		Sort sort = Sort.by(Sort.Direction.ASC,"name");
		return new SuccessDataResult<List<Brand>>
		(this.brandDao.findAll(sort),"Başarılı Sıralandı.");
	}

}
