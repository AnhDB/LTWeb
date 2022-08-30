package book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends JpaRepository<Book, String>, CrudRepository<Book, String>{
	@Query(value = "select * from Book where bookcode like %?1% and title like %?2% and author like %?3% and category like %?4%", nativeQuery = true)
	public List<Book> search(String bookcode, String title, String author, String category);
	
	@Query(value = "select * from Book where bookcode like %?1%", nativeQuery = true)
	public Book searchByCode(String bookcode);
}
