package schoolproject.RentACarProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import schoolproject.RentACarProject.entities.concretes.Brand;

public interface BrandDao extends JpaRepository< Brand , Integer> {
	Brand getByName(String name);
	
	Brand getById(int id);
	
	Brand getByNameAndId(String name, int id );
	
	List<Brand> getByNameOrId(String name, int id );
	
    List<Brand> getByNameContains(String name);
	
	List<Brand> getByNameStartsWith(String name);
}
