package product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, String>{
	@Query("SELECT p FROM Product p WHERE p.name LIKE %?1%"
            + " OR p.brand LIKE %?1%"
            + " OR p.madein LIKE %?1%"
            + " OR CONCAT(p.price, '') LIKE %?1%")
	public List<Product> findAll(String key);
}
