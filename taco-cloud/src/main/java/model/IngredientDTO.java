package model;



import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import lombok.NoArgsConstructor;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(force=true)

public class IngredientDTO {
	private final String id;
	private final String name;
	@Enumerated(EnumType.STRING)
	private final Type type;

	public static enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}	
	private Boolean isEditBoolean = false;
}
