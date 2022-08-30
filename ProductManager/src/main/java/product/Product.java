package product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
	@Id
	private String id;
	@NotNull
	@Size(min=5, message="Name must be at least 5 characters long")
	private String name;
	@NotNull
	@Size(min=2, message="Brand must be at least 2 characters long")
	private String brand;
	@NotNull
	@Size(min=5, message="Made in must be at least 5 characters long")
	private String madein;
	@NotNull
	@PositiveOrZero(message="Price must be equal or greater than 0")
	private float price;
}
