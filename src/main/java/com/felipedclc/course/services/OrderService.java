package com.felipedclc.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipedclc.course.entities.Order;
import com.felipedclc.course.repositories.OrderRepository;

@Service 
public class OrderService {

	@Autowired // INJEÇÃO DE DEPENDÊNCIA AUTOMÁTICA
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get(); // RETORNA O OBJETO DENTRO DO "< >"
	}
}
