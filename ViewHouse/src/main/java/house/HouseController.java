package house;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HouseController {
	private final HouseRepository repo;
	@Autowired
	public HouseController(HouseRepository repo) {
		super();
		this.repo = repo;
	}
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/view")
	public String view(Model model) {
		model.addAttribute("list", repo.search());
		return "view";
	}
	
	@GetMapping("/approve/{id}")
	public String approve(@PathVariable("id") String id, Model model) {
		House h=repo.searchById(id);
		h.setApproved(1);
		repo.save(h);
		return "redirect:/view";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteGet(@PathVariable("id") String id, Model model) {
		House h=repo.searchById(id);
		model.addAttribute("house", h);
		return "delete";
	}
	
	@PostMapping("/delete/{id}")
	public String deletePost(HttpServletRequest request, @PathVariable("id") String id) {
		String chon=request.getParameter("chon");
		if(chon.equals("yes")) {
			repo.deleteById(id);
			
		}
		return "redirect:/view";
	}
}
