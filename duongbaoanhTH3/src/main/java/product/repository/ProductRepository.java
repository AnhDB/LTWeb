package product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import product.model.Product;

public interface ProductRepository extends JpaRepository<Product, String>{

}
