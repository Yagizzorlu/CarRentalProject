package schoolproject.RentACarProject.business.abstracts;

import java.util.List;

import schoolproject.RentACarProject.core.utilities.results.DataResult;
import schoolproject.RentACarProject.core.utilities.results.Result;
import schoolproject.RentACarProject.entities.concretes.Color;

public interface ColorService {
	DataResult<List<Color>> getAll();
	DataResult<List<Color>> getAllSortedDESC();
	DataResult<List<Color>> getAllSortedASC();
	DataResult<List<Color>> getAllSortedByName();
    Result add(Color color);
    DataResult<Color> getByName(String name);
	DataResult<Color> getById(int id);
	DataResult<Color> getByNameAndId(String name, int id );
	DataResult<List<Color>> getByNameOrId(String name, int id );
	DataResult<List<Color>> getByNameContains(String name);
	DataResult<List<Color>> getByNameStartsWith(String name);
}
