package schoolproject.RentACarProject.business.abstracts;

import java.util.List;

import schoolproject.RentACarProject.core.utilities.results.DataResult;
import schoolproject.RentACarProject.core.utilities.results.Result;
import schoolproject.RentACarProject.entities.concretes.Brand;

public interface BrandService {
	DataResult<List<Brand>> getAll();
	DataResult<List<Brand>> getAllSortedDESC();
	DataResult<List<Brand>> getAllSortedASC();
	DataResult<List<Brand>> getAllSortedByName();
	Result add(Brand brand);
	DataResult<Brand> getByName(String name);
	DataResult<Brand> getById(int id);
	DataResult<Brand> getByNameAndId(String name, int id );
	DataResult<List<Brand>> getByNameOrId(String name, int id );
	DataResult<List<Brand>> getByNameContains(String name);
	DataResult<List<Brand>> getByNameStartsWith(String name);
}
