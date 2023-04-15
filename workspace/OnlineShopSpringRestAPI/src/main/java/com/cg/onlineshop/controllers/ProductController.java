package com.cg.onlineshop.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshop.exceptions.ProductDetailsNotFoundException;
import com.cg.onlineshop.pojos.Product;
import com.cg.onlineshop.services.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/sayHello")
	ResponseEntity<String> sayHello(){
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Hello all. Welcome to RESTful Web Services",HttpStatus.OK);
		return responseEntity;
	}
	
	
//	@PostMapping(value={"/addProduct"},consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//	ResponseEntity<Product> addProduct(@ModelAttribute Product product){
//		product = productService.acceptProductDetails(product);
//		ResponseEntity<Product> responseEntity = new ResponseEntity<Product>(product,HttpStatus.OK);
//		return responseEntity;
//	}
	
	@PostMapping(value={"/addProduct"},consumes=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Product> addProduct(@RequestBody Product product){
		product = productService.acceptProductDetails(product);
		ResponseEntity<Product> responseEntity = new ResponseEntity<Product>(product,HttpStatus.OK);
		return responseEntity;
	}
	
//	@GetMapping(value= {"/productDetails"})
//	public ResponseEntity<Product> getProductDetails(int id) throws ProductDetailsNotFoundException{
//		Product product = productService.getProductDetails(id);
//		return new ResponseEntity<Product>(product,HttpStatus.OK);
//	}
	
	@GetMapping(value= {"/productDetails/{id}"})
	public ResponseEntity<Product> getProductDetails(@PathVariable int id) throws ProductDetailsNotFoundException{
		Product product = productService.getProductDetails(id);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
}
