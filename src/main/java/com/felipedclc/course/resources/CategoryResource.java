package com.felipedclc.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipedclc.course.entities.Category;
import com.felipedclc.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource { 
	
	@Autowired // INJEÇÃO AUT
	private CategoryService service;
	 
	@GetMapping // REQUISIÇÕES DO TIPO GET
	public ResponseEntity<List<Category>> findAll(){ //RETORNA RESPOSTA DE REQUISIÇÕES WEB
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list); // CORRESPONDE AO METODO GET
	}
	
	@GetMapping(value = "/{id}") // REQUISIÇÃO ACEITA O "ID" DENTRO DA URL
	public ResponseEntity<Category> findById(@PathVariable Long id){ // "ANOTATION" PARA O SPRING CONSIDERAR O ID COMO PARAMAETRO
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj); // END POINT 
	}
}