package schoolproject.RentACarProject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarWithColorDto {
	private int id;
	private int colorId;
	private String description;
	private String colorName;
	private double dailyPrice;
}
