package schoolproject.RentACarProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import schoolproject.RentACarProject.entities.concretes.Model;
import schoolproject.RentACarProject.entities.dtos.ModelWithBrandDto;

public interface ModelDao extends JpaRepository< Model , Integer > {
	 Model getByName(String name);
	 
	 Model getById(int id);
	 
	 @Query("SELECT m FROM Model m WHERE m.name = :name AND m.brand.id = :brandId")
	 List<Model> getByNameAndBrand(@Param("name") String name , @Param("brandId") int brandId);
	 
	 @Query("SELECT m FROM Model m WHERE m.id = :id AND m.brand.id = :brandId")
	 List<Model> getByIdAndBrand(@Param("id") int id , @Param("brandId") int brandId);
	 
	 List<Model> getByBrandIn(List<Integer> brands);
	  
	 List<Model> getByNameContains(String name);
	  
	 List<Model> getByNameStartsWith(String name);
	 
	 List<Model> getByNameOrId(String name, int id );
	 
	 @Query("SELECT new schoolproject.RentACarProject.entities.dtos.ModelWithBrandDto(m.id, b.id, m.name, b.name) FROM Brand b INNER JOIN b.models m")
	  List<ModelWithBrandDto> getModelWithBrandDetails();
}
