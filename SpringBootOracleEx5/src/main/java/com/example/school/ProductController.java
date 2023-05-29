package com.example.school;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;

	@GetMapping("/")
	public String homepage(Model model) {
		List<Product> product = productService.getData();
		model.addAttribute("product", product);
		return "index1";
	}

	@GetMapping("/new")
	public String newProduct(Model model){
		model.addAttribute("product",new Product());
		return "new_product";
	}
	
	@PostMapping("/save")
	public String saveProduct(Product product) {
		productService.saveData(product);
		return "redirect:/";
		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable long id) {
		System.out.println(id);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable long id, Model model) {
		Product product=productService.getproduct(id);
		model.addAttribute("product",product);
		return "edit";
	}	
}
