package schoolproject.RentACarProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import schoolproject.RentACarProject.entities.concretes.Car;
import schoolproject.RentACarProject.entities.dtos.CarWithBrandDto;
import schoolproject.RentACarProject.entities.dtos.CarWithColorDto;
import schoolproject.RentACarProject.entities.dtos.CarWithModelDto;

public interface CarDao extends JpaRepository< Car , Integer> {
	  Car getByDescription(String description);
	  Car getById(int id);
	  Car getByModelYear(int modelYear);
	  Car getByDailyPrice(double dailyPrice);
	  @Query("SELECT c FROM Car c WHERE c.id = :id AND c.brand.id = :brandId")
	  List<Car> getByIdAndBrand(@Param("id") int id, @Param("brandId") int brandId);
	  @Query("SELECT c FROM Car c WHERE c.id = :id AND c.model.id = :modelId")
	  List<Car> getByIdAndModel(@Param("id") int id, @Param("modelId") int modelId);
	  @Query("SELECT c FROM Car c WHERE c.id = :id AND c.color.id = :colorId")
	  List<Car> getByIdAndColor(@Param("id") int id, @Param("colorId") int colorId);
	  List<Car> getByModelIn(List<Integer> models);
	  List<Car> getByColorIn(List<Integer> colors);
	  List<Car> getByBrandIn(List<Integer> brands);
	  List<Car> getByDescriptionContains(String description);
	  List<Car> getByDescriptionStartsWith(String description);
	  @Query("SELECT new schoolproject.RentACarProject.entities.dtos.CarWithBrandDto(c.id, b.id, c.description, b.name, c.dailyPrice) FROM Brand b INNER JOIN b.cars c")
	  List<CarWithBrandDto> getCarWithBrandDetails();
	  @Query("SELECT new schoolproject.RentACarProject.entities.dtos.CarWithColorDto(c.id, co.id, c.description, co.name, c.dailyPrice) FROM Color co INNER JOIN co.cars c")
	  List<CarWithColorDto> getCarWithColorDetails();
	  @Query("SELECT new schoolproject.RentACarProject.entities.dtos.CarWithModelDto(c.id, m.id, c.description, m.name, c.dailyPrice) FROM Model m INNER JOIN m.cars c")
	  List<CarWithModelDto> getCarWithModelDetails();
}
