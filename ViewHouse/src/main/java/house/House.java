package house;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class House {
	@Id
	private String id;
	private String address;
	private int area;
	private String type;
	private int approved;
	
}
