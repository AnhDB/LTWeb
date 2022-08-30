package student;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
	@Id
	private String id;
	@NotBlank
	private String name;
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	
	private Date dob;
	@Enumerated(EnumType.STRING)
	private Department department;
	private int approved;
	
	public static enum Department{
		CNTT, DTVT, MKT
	}

	public Student(String id, @NotBlank String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
	
	
	
}
