package schoolproject.RentACarProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import schoolproject.RentACarProject.business.abstracts.ModelService;
import schoolproject.RentACarProject.core.utilities.results.DataResult;
import schoolproject.RentACarProject.core.utilities.results.Result;
import schoolproject.RentACarProject.core.utilities.results.SuccessDataResult;
import schoolproject.RentACarProject.core.utilities.results.SuccessResult;
import schoolproject.RentACarProject.dataAccess.abstracts.ModelDao;
import schoolproject.RentACarProject.entities.concretes.Model;
import schoolproject.RentACarProject.entities.dtos.ModelWithBrandDto;

@Service
public class ModelManager implements ModelService {

	private ModelDao modelDao;
	
	@Autowired
	public ModelManager(ModelDao modelDao) {
		super();
		this.modelDao = modelDao;
	}

	@Override
	public DataResult<List<Model>> getAll() {
		return new SuccessDataResult<List<Model>>
		(this.modelDao.findAll(),("Data Listelendi."));
	}
	
	public Result add (Model model) {
		this.modelDao.save(model);
		return new SuccessResult("Model eklendi.");
	}

	@Override
	public DataResult<Model> getByName(String name) {
		return new SuccessDataResult<Model>
		(modelDao.getByName(name), "Data Listelendi.");
	}

	@Override
	public DataResult<Model> getById(int id) {
		return new SuccessDataResult<Model>
		(modelDao.getById(id), "Data Listelendi.");
	}

	@Override
	public DataResult<List<Model>> getByNameAndBrand(String name, int brandId) {
		return new SuccessDataResult<List<Model>>
        (modelDao.getByNameAndBrand(name, brandId),"Data Listelendi");
	}

	@Override
	public DataResult<List<Model>> getByIdAndBrand(int id, int brandId) {
		return new SuccessDataResult<List<Model>>
        (modelDao.getByIdAndBrand(id , brandId),"Data Listelendi");
	}

	@Override
	public DataResult<List<Model>> getByBrandIn(List<Integer> brands) {
		return new SuccessDataResult<List<Model>>
		(this.modelDao.getByBrandIn(brands),"Data listelendi");
	}

	@Override
	public DataResult<List<Model>> getByNameContains(String name) {
		return new SuccessDataResult<List<Model>>
		(this.modelDao.getByNameContains(name),"Data listelendi");
	}

	@Override
	public DataResult<List<Model>> getByNameStartsWith(String name) {
		return new SuccessDataResult<List<Model>>
		(this.modelDao.getByNameContains(name),"Data listelendi");
	}

	@Override
	public DataResult<List<Model>> getByNameOrId(String name, int id) {
		return new SuccessDataResult<List<Model>>
		(modelDao.getByNameOrId(name , id), "Data Listelendi.");
	}

	@Override
	public DataResult<List<Model>> getAllSortedDESC() {
		Sort sort = Sort.by(Sort.Direction.DESC,"id");
		return new SuccessDataResult<List<Model>>
		(this.modelDao.findAll(sort),"Başarılı Sıralandı.");
	}

	@Override
	public DataResult<List<Model>> getAllSortedASC() {
		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		return new SuccessDataResult<List<Model>>
		(this.modelDao.findAll(sort),"Başarılı Sıralandı.");
	}

	@Override
	public DataResult<List<Model>> getAllSortedByBrandDESC() {
		Sort sort = Sort.by(Sort.Direction.DESC,"brandId");
		return new SuccessDataResult<List<Model>>
		(this.modelDao.findAll(sort),"Başarılı Sıralandı.");
	}

	@Override
	public DataResult<List<Model>> getAllSortedByBrandASC() {
		Sort sort = Sort.by(Sort.Direction.ASC,"brandId");
		return new SuccessDataResult<List<Model>>
		(this.modelDao.findAll(sort),"Başarılı Sıralandı.");
	}

	@Override
	public DataResult<List<Model>> getAllSortedByName() {
		Sort sort = Sort.by(Sort.Direction.ASC,"name");
		return new SuccessDataResult<List<Model>>
		(this.modelDao.findAll(sort),"Başarılı Sıralandı.");
	}

	@Override
	public DataResult<List<ModelWithBrandDto>> getModelWithBrandDetails() {
		return new SuccessDataResult<List<ModelWithBrandDto>>
		(this.modelDao.getModelWithBrandDetails(),"Data Listelendi.");
	}

}
