package com.felipedclc.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipedclc.course.entities.Product;
import com.felipedclc.course.repositories.ProductRepository;

@Service 
public class ProductService {

	@Autowired // INJEÇÃO DE DEPENDÊNCIA AUTOMÁTICA
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get(); // RETORNA O OBJETO DENTRO DO "< >"
	}
}
