package product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import product.model.Product;
import product.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("")
	public String listProducts(Model model) {
		model.addAttribute("products", productService.getAllProduct());
		return "/products";
	}

	@GetMapping("/addProduct")
	public String addNewProductGet(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "/addProduct";
	}

	@PostMapping("/addProduct")
	public String addNewProductPost(Model model, @ModelAttribute(name = "product") Product product) {
		productService.createProduct(product);
		return "redirect:/products";
	}

	@GetMapping("/editProduct/{code}")
	public String editProductGet(Model model, @PathVariable(name = "code") String code) {
		Product product = productService.getProductByCode(code);
		model.addAttribute("product", product);
		return "/editProduct";
	}

	@PostMapping("/editProduct/{code}")
	public String editProductPost(Model model, @PathVariable(name = "code") String code,
			@ModelAttribute(name = "product") Product product) {
		productService.editProduct(code, product);
		return "redirect:/products";
	}


	@GetMapping("/deleteProduct/{code}")
	public String deleteProductGet(Model model, @PathVariable(name = "code") String code) {
		Product product = productService.getProductByCode(code);
		model.addAttribute("product", product);
		return "/deleteProduct";
	}

	@PostMapping("/deleteProduct/{code}")
	public String deleteProductPost(HttpServletRequest request, Model model,@PathVariable(name = "code") String code) {
		String choose = request.getParameter("choose");
		if (choose.equals("yes")) {
			productService.deleteProduct(productService.getProductByCode(code));
		}
		return "redirect:/products";
	}

}
