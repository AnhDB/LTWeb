package tacos.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tacos.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {

//	@Query(value="SELECT p FROM ingredient p where p.name LIKE %?1%",nativeQuery = true)
//	public List<Ingredient> findAll(String name);
	@Query(value = "SELECT * FROM ingredient WHERE name LIKE %?1%", nativeQuery = true)
	public List<Ingredient> searchIngredient(String name);
}