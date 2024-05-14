package schoolproject.RentACarProject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarWithModelDto {
	private int id;
	private int modelId;
	private String description;
	private String modelName;
	private double dailyPrice;
}
