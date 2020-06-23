package com.felipedclc.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipedclc.course.entities.Order;
import com.felipedclc.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource { 
	
	@Autowired // INJEÇÃO AUT
	private OrderService service;
	 
	@GetMapping // REQUISIÇÕES DO TIPO GET
	public ResponseEntity<List<Order>> findAll(){ //RETORNA RESPOSTA DE REQUISIÇÕES WEB
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list); // CORRESPONDE AO METODO GET
	}
	
	@GetMapping(value = "/{id}") // REQUISIÇÃO ACEITA O "ID" DENTRO DA URL
	public ResponseEntity<Order> findById(@PathVariable Long id){ // "ANOTATION" PARA O SPRING CONSIDERAR O ID COMO PARAMAETRO
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj); // END POINT 
	}
}