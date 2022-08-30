package product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;
	public List<Product> listAll(){
		return repo.findAll();
	}
	
	public void save(Product p) {
		repo.save(p);
	}
	
	public Product get(String code) {
		return repo.findById(code).get();
	}
	
	public void delete(String code) {
		repo.deleteById(code);
	}
}
