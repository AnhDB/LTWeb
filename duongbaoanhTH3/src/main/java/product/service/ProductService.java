package product.service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.model.Product;
import product.repository.ProductRepository;

@Service
public class ProductService implements ProductServiceImpl{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getProductByCode(String code) {
		return productRepository.findById(code).get();
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product editProduct(String code,  Product product) {
		Product p=productRepository.findById(code).get();
		p.setDescription(product.getDescription());
		p.setPrice(product.getPrice());
		return productRepository.save(p);
	}

	@Override
	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}

	
	
}
