package product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;
	
	@RequestMapping("/products")
	public String listProduct(Model model, @Param("key") String key) {
//		String key="om";
		List<Product> list=service.listAll(key);
		model.addAttribute("products", list);
		model.addAttribute("key", key);
		return "products";
	}
	
	@RequestMapping("/addProducts")
	public String add(Model model) {
		Product p=new Product();
		model.addAttribute("product", p);
		return "addProduct";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Validated @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "addProduct";
		}
		service.save(product);
		return "redirect:/products";
	}
	
	@GetMapping("/edit/{id}")
	public String editGet(Model model, @PathVariable(name="id") String id) {
		Product p=service.get(id);
		model.addAttribute("product", p);
		return "editProduct";
	}
	
	@PostMapping("/edit/{id}")
	public String edit(@Validated @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "editProduct";
		}
		service.edit(product);
		return "redirect:/products";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteGet(Model model, @PathVariable(name="id") String id) {
		Product p=service.get(id);
		model.addAttribute("product", p);
		return "deleteProduct";
	}
	
	@PostMapping("/delete/{id}")
	public String delete(HttpServletRequest request,@PathVariable(name="id") String id) {
		String choose= request.getParameter("choose");
		if(choose.equals("yes")) {
			service.delete(id);
		}
		
		return "redirect:/products";
	}
}
