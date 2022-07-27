package tacos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.deser.impl.NullsAsEmptyProvider;

import tacos.Ingredient;
import tacos.data.IngredientRepository;

@Service
public class IngredientService {
	@Autowired
	private IngredientRepository repo;

	public IngredientService(IngredientRepository repo) {
		super();
		this.repo = repo;
	}
//	public List<Ingredient> listAll( String name){
//		if(name != null) {
//			return repo.findAll(name);
//		}
//		return (List<Ingredient>) repo.findAll();
//	}
	
}
