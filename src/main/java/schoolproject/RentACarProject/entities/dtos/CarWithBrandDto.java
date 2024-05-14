package schoolproject.RentACarProject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarWithBrandDto {
	private int id;
	private int brandId;
	private String description;
	private String brandName;
	private double dailyPrice;
}


