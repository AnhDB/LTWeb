package product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/productMaint")
@Controller
public class ProductController {
	@Autowired
	private ProductService service;
	
	@RequestMapping("/displayProducts")
	public String listProduct(Model model) {
		List<Product> list=service.listAll();
		model.addAttribute("products", list);
		return "products";
	}
	
	@RequestMapping("/addProducts")
	public String showNewProductForm(Model model) {
		Product product=new Product();
		model.addAttribute("product", product);
		return "addProduct";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveProduct(@Validated @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "addProduct";
		}
		service.save(product);
		return "redirect:/productMaint/displayProducts";
	}
	
	@RequestMapping("/update/{code}")
	public ModelAndView edit(@PathVariable(name="code")String code) {
		ModelAndView mav= new ModelAndView("editProduct");		
		Product p=service.get(code);
		mav.addObject("product", p);
		return mav;
	}
	
	@GetMapping("/delete/{code}")
	public String delete(Model model, @PathVariable(name="code") String code) {
		Product p= service.get(code);
		model.addAttribute("product", p);
		return "deleteProduct";
	}
	
	@PostMapping("/delete/{code}")
	public String del(HttpServletRequest request,Model model, @PathVariable(name="code")String code) {
		String choose=request.getParameter("choose");
		if(choose.equals("yes")) {
			service.delete(code);
		}
		return "redirect:/productMaint/displayProducts";
	}
	
}
