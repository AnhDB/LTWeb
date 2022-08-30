package product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;
	
	public List<Product> listAll(String key){
		if(key!=null) {
			return repo.findAll(key);
		}
		return repo.findAll();
	}
	
	public void save(Product p) {
		repo.save(p);
	}
	
	public Product get(String id) {
		return repo.findById(id).get();
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}
	
	public void edit(Product p) {
		repo.save(p);
	}
}
