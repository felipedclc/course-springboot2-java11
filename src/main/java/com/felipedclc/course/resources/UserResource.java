package com.felipedclc.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipedclc.course.entities.User;
import com.felipedclc.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource { 
	
	@Autowired // INJEÇÃO AUT
	private UserService service;
	 
	@GetMapping // REQUISIÇÕES DO TIPO GET
	public ResponseEntity<List<User>> findAll(){ //RETORNA RESPOSTA DE REQUISIÇÕES WEB
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list); // CORRESPONDE AO METODO GET
	}
	
	@GetMapping(value = "/{id}") // REQUISIÇÃO ACEITA O "ID" DENTRO DA URL
	public ResponseEntity<User> findById(@PathVariable Long id){ // "ANOTATION" PARA O SPRING CONSIDERAR O ID COMO PARAMAETRO
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj); // END POINT 
	}
}