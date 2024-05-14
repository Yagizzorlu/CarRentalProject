package schoolproject.RentACarProject.business.abstracts;

import java.util.List;
import schoolproject.RentACarProject.core.utilities.results.DataResult;
import schoolproject.RentACarProject.core.utilities.results.Result;
import schoolproject.RentACarProject.entities.concretes.Model;
import schoolproject.RentACarProject.entities.dtos.ModelWithBrandDto;

public interface ModelService {
	DataResult<List<Model>> getAll();
	
	DataResult<List<Model>> getAllSortedDESC();
	
	DataResult<List<Model>> getAllSortedASC();
	
	DataResult<List<Model>> getAllSortedByBrandDESC();
	
	DataResult<List<Model>> getAllSortedByBrandASC();
	
	DataResult<List<Model>> getAllSortedByName();
	
	Result add(Model model);
	
	DataResult<Model> getByName(String name);
	
	DataResult<Model> getById(int id);
	
    DataResult<List<Model>> getByNameAndBrand(String name, int brandId);
    
	DataResult<List<Model>> getByIdAndBrand(int id, int brandId);
	
	DataResult<List<Model>> getByBrandIn(List<Integer> brands);
	
	DataResult<List<Model>> getByNameContains(String name);
	
	DataResult<List<Model>> getByNameStartsWith(String name);
	
	DataResult<List<Model>> getByNameOrId(String name, int id );
	
	DataResult<List<ModelWithBrandDto>> getModelWithBrandDetails();
	
}
