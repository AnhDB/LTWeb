package product.service;

import java.util.List;

import product.model.Product;



public interface ProductServiceImpl {

	Product createProduct (Product product);
	
	Product getProductByCode (String code);
	
	List<Product> getAllProduct ();
	
	Product editProduct (String code,  Product product);
	
	void deleteProduct (Product product);
	
}
