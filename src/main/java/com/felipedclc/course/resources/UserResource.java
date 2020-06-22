package com.felipedclc.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipedclc.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource { 
	
	@GetMapping
	public ResponseEntity<User> findAll(){ //RETORNA RESPOSTA DE REQUISIÇÕES WEB
		User u = new User((long) 1, "Maria do Carmo", "mc@gmail.com", "99999999", "12345");
		return ResponseEntity.ok().body(u); // CORRESPONDE AO METODO GET
	}
}