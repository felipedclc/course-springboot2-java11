package com.felipedclc.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.felipedclc.course.entities.User;
import com.felipedclc.course.services.UserService;

@RestController // CONTROLADOR REST
@RequestMapping(value = "/users") // CAMINHO DO CONTROLADOR 
public class UserResource { 
	
	@Autowired // INJEÇÃO AUT
	private UserService service;
	 
	@GetMapping // REQUISIÇÕES DO TIPO GET
	public ResponseEntity<List<User>> findAll(){ //RETORNA RESPOSTA DE REQUISIÇÕES WEB(findAll)
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list); // CORRESPONDE AO METODO GET
	}
	
	@GetMapping(value = "/{id}") // REQUISIÇÃO ACEITA O "ID" DENTRO DA URL
	public ResponseEntity<User> findById(@PathVariable Long id){ // "ANOTATION" PARA O SPRING CONSIDERAR O ID COMO PARAMAETRO
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj); // END POINT 
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){ // REQUEST BODY PARA O JSON 
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(obj.getId()).toUri(); // GERANDO O ENDEREÇO URI DO NOVO RECURSO 
		return ResponseEntity.created(uri).body(obj); 
	}
}