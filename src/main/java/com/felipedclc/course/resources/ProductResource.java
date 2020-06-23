package com.felipedclc.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipedclc.course.entities.Product;
import com.felipedclc.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource { 
	
	@Autowired // INJEÇÃO AUT
	private ProductService service;
	 
	@GetMapping // REQUISIÇÕES DO TIPO GET
	public ResponseEntity<List<Product>> findAll(){ //RETORNA RESPOSTA DE REQUISIÇÕES WEB
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list); // CORRESPONDE AO METODO GET
	}
	
	@GetMapping(value = "/{id}") // REQUISIÇÃO ACEITA O "ID" DENTRO DA URL
	public ResponseEntity<Product> findById(@PathVariable Long id){ // "ANOTATION" PARA O SPRING CONSIDERAR O ID COMO PARAMAETRO
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj); // END POINT 
	}
}