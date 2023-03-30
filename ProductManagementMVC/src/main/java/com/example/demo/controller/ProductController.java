package com.example.demo.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;


@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	
	//1. show Register Page
		@RequestMapping("/register")
		public String showPage(Model model) {
			//set form backing object-[Form<=>Object]
			model.addAttribute("product", new Product());
			return "ProductRegister";
		}
		
		//2. save/update data
		@RequestMapping(value="/save",method=POST)
		public String saveProduct(@ModelAttribute Product product,Model model) {
			//save operation
			Integer prodId=service.saveProduct(product);
			//clean form
			model.addAttribute("product", new Product());
			//return message to UI
			model.addAttribute("message", "Product '"+prodId+"' saved");
			return "ProductRegister";
		}
		
		//3. display all values
		@RequestMapping("/all")
		public String showAllProducts(Model model) {
			List<Product> prods=service.getAllProducts();
			model.addAttribute("list", prods);
			return "ProductData";
		}
		//4. Delete Product based on PathVariable-id
		@RequestMapping("/delete/{id}")
		public String deleteProduct(@PathVariable Integer id,Model model) {
			//delete record
			service.deleteProduct(id);
			//get new data and goto UI
			List<Product> prods=service.getAllProducts();
			model.addAttribute("message", "Product '"+id+"' Deleted");
			model.addAttribute("list", prods);
			return "ProductData";
		}
		//5. show Edit Page
		@RequestMapping("/edit/{id}")
		public String showEditPage(@PathVariable Integer id,Model model) {
			//load Product from DB
			Product p=service.getProductById(id);
			//send object to UI => Form data
			model.addAttribute("product", p);
			return "ProductRegister";
		}
}
