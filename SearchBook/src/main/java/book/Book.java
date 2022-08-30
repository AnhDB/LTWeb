package book;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
	@Id
	private String bookcode;
	private String title;
	private String author;
	private String category;
	private int booked;
	public Book(String bookcode, String title, String author, String category) {
		super();
		this.bookcode = bookcode;
		this.title = title;
		this.author = author;
		this.category = category;
	}
	
}
