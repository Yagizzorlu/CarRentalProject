package schoolproject.RentACarProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import schoolproject.RentACarProject.business.abstracts.ColorService;
import schoolproject.RentACarProject.core.utilities.results.DataResult;
import schoolproject.RentACarProject.core.utilities.results.Result;
import schoolproject.RentACarProject.core.utilities.results.SuccessDataResult;
import schoolproject.RentACarProject.core.utilities.results.SuccessResult;
import schoolproject.RentACarProject.dataAccess.abstracts.ColorDao;
import schoolproject.RentACarProject.entities.concretes.Color;

@Service
public class ColorManager implements ColorService {

	private ColorDao colorDao;
	
	@Autowired
	public ColorManager(ColorDao colorDao) {
		super();
		this.colorDao = colorDao;
	}

	@Override
	public DataResult<List<Color>> getAll() {		
		return new SuccessDataResult<List<Color>>    
		(this.colorDao.findAll(),"Data listelendi.");
	}

	@Override
	public Result add(Color color) {
		this.colorDao.save(color);   //save ile ekleme ve güncelleme yapılabiliyor.
		return new SuccessResult("Renk eklendi.");
	}

	@Override
	public DataResult<Color> getByName(String name) {
		return new SuccessDataResult<Color>
		(colorDao.getByName(name), "Data Listelendi.");
	}

	@Override
	public DataResult<Color> getById(int id) {
		return new SuccessDataResult<Color>
		(colorDao.getById(id), "Data Listelendi.");
	}

	@Override
	public DataResult<Color> getByNameAndId(String name, int id) {
		return new SuccessDataResult<Color>
		(colorDao.getByNameAndId(name , id), "Data Listelendi.");
	}

	@Override
	public DataResult<List<Color>> getByNameOrId(String name, int id) {
		return new SuccessDataResult<List<Color>>
		(colorDao.getByNameOrId(name , id), "Data Listelendi.");
	}

	@Override
	public DataResult<List<Color>> getByNameContains(String name) {
		return new SuccessDataResult<List<Color>>
		(this.colorDao.getByNameContains(name),"Data listelendi");
	}

	@Override
	public DataResult<List<Color>> getByNameStartsWith(String name) {
		return new SuccessDataResult<List<Color>>
		(this.colorDao.getByNameStartsWith(name),"Data listelendi");
	}

	@Override
	public DataResult<List<Color>> getAllSortedDESC() {
		Sort sort = Sort.by(Sort.Direction.DESC,"id");
		return new SuccessDataResult<List<Color>>
		(this.colorDao.findAll(sort),"Başarılı Sıralandı.");
	}


	@Override
	public DataResult<List<Color>> getAllSortedASC() {
		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		return new SuccessDataResult<List<Color>>
		(this.colorDao.findAll(sort),"Başarılı Sıralandı.");
	}


	@Override
	public DataResult<List<Color>> getAllSortedByName() {
		Sort sort = Sort.by(Sort.Direction.ASC,"name");
		return new SuccessDataResult<List<Color>>
		(this.colorDao.findAll(sort),"Başarılı Sıralandı.");
	}

}
