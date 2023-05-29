package com.example.school;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
    ProductRepository productRepository;

	public List<Product> getData() {
		return productRepository.findAll();
	}

	public void saveData(Product product) {
     productRepository.save(product);
		
	}

	public void deletProduct(long id) {
		productRepository.deleteById(id);
		
	}

	public Product getproduct(long id) {
		return productRepository.findById(id).get();
		 
	}

}
