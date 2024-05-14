package schoolproject.RentACarProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import schoolproject.RentACarProject.entities.concretes.Color;

public interface ColorDao extends JpaRepository< Color , Integer> {
	
	Color getByName(String name);
	
	Color getById(int id);
	
	Color getByNameAndId(String name, int id );
	
	List<Color> getByNameOrId(String name, int id );
	
    List<Color> getByNameContains(String name);
	
	List<Color> getByNameStartsWith(String name);
	
}
