package tacos.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import model.IngredientDTO;
import tacos.data.IngredientRepository;
import tacos.service.IngredientService;
import tacos.Ingredient;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {
	private final IngredientRepository ingredientRepo;

	@Autowired
	private IngredientService service;
	@Autowired
	public IngredientController(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}

//	@RequestMapping("")
//	public String liString(ModelMap model) {
//		List<Ingredient> list = (List<Ingredient>) ingredientRepo.findAll();
//		model.addAttribute("ingredients", list);
//		return "list";
//	}

	@RequestMapping(value = "" , method = RequestMethod.GET)
	public String liString(ModelMap model, @Param("name") String name) {
		List<Ingredient> list;
		
		if(name !=null) {
			 list = ingredientRepo.searchIngredient(name);
		}else {
			 list = (List<Ingredient>) ingredientRepo.findAll();
		}
		model.addAttribute("ingredients", list);
		return "list";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("ingredient", new Ingredient(null, null, null));
		return "addIngredient";
	}

	@PostMapping
	public String addIngredient(Ingredient ingredient, Model model) {
		ingredientRepo.save(ingredient);
		model.addAttribute(ingredient);
//	  log.info("Ingredient saved: " + ingredient);
		return "redirect:/ingredient";
	}

//	@GetMapping("edit/{ingredientId}")
//	public String edit(ModelMap model, @PathVariable("ingredientId") String ingredientId) {
//		Optional<Ingredient> opt = ingredientRepo.findById(ingredientId);
//		IngredientDTO dto = new IngredientDTO();
//		Ingredient entity = opt.get();
//		BeanUtils.copyProperties(entity, dto);
//		model.addAttribute("ingredient", entity);
//		dto.setIsEditBoolean(true);
//		return "edit";
//	}

	@GetMapping("delete/{ingredientId}")
	public String delete(@PathVariable("ingredientId") String ingredientId, Model model) {
		ingredientRepo.deleteById(ingredientId);
		List<Ingredient> list = (List<Ingredient>) ingredientRepo.findAll();
		model.addAttribute("ingredients", list);
		return "list"; // trả về controll
	}
	@GetMapping("edit/{ingredientId}")
	public ModelAndView delete(ModelMap model, @PathVariable("ingredientId") String ingredientId) {
		Optional<Ingredient> opt = ingredientRepo.findById(ingredientId);
		IngredientDTO dto = new IngredientDTO();
		Ingredient entity = opt.get();
		BeanUtils.copyProperties(entity, dto);
		model.addAttribute("ingredient", entity);
		return new ModelAndView("edit");
	}

//	
//	@GetMapping("/search")
//	public String search(ModelMap model, @RequestParam(name = "name") String name) {
//
//		List<Ingredient> list = null;
//
//		if (StringUtils.hasText(name)) {
//			list = ingredientRepo.findByNameContaining(name);
//		} else {
//			list = (List<Ingredient>) ingredientRepo.findAll();
//		}
//		model.addAttribute("ingredients", list);
//		return "search";
//	}

}
