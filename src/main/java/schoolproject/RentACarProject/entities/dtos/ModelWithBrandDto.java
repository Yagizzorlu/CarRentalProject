package schoolproject.RentACarProject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelWithBrandDto {
	private int id;
	private int brandId;
	private String name;
	private String brandName;
}
