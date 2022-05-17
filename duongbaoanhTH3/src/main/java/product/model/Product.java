package product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Product {
	@Id
//	@NotBlank(message = "Code is not empty")
	private String code;
//	@NotEmpty(message = "Description is not empty")
	private String description;
//	@NotBlank (message = "Price is not empty")
	private Double price;
}
