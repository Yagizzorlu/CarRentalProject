package schoolproject.RentACarProject.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cars")  
@AllArgsConstructor  
@NoArgsConstructor  
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id")
	private int id;
	
	//@Column(name = "brand_id")
	//private int brandId;
	
	//@Column(name = "model_id")
	//private int modelId;
	
	//@Column(name = "color_id")
	//private int colorId;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "model_year")
	private int modelYear;
	
	@Column(name = "daily_price")
	private double dailyPrice;
	
	@ManyToOne()
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	@ManyToOne()
	@JoinColumn(name = "model_id")
	private Model model;
	
	@ManyToOne()
	@JoinColumn(name = "color_id")
	private Color color;
	
}
