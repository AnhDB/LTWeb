package book;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
	private final BookRepository repo;

	@Autowired
	public BookController(BookRepository repo) {
		super();
		this.repo = repo;
	}
	
	@GetMapping("/")
	public String home(ModelMap model, HttpSession ses) {
		Book b= (Book) ses.getAttribute("booksession");
		if(b==null) {
			b=new Book(null, null, null, null);
			model.addAttribute("book", b);
		}
		else {
			model.addAttribute("book", b);
		}
		return "home";
	}
	
	@PostMapping("/search")
	public String search(ModelMap model, Book b, HttpServletRequest request) {
		request.getSession().setAttribute("booksession", b);
		List<Book> list=repo.search(b.getBookcode(), b.getTitle(), b.getAuthor(), b.getCategory());
		model.addAttribute("list", list);
		return "search";
	}
	
	@GetMapping("/book/{bookcode}")
	public String update(@PathVariable("bookcode") String bookcode, HttpServletRequest request) {
		Book b= repo.searchByCode(bookcode);
		b.setBooked(1);
		repo.save(b);
		return "redirect:/";
	}
}
