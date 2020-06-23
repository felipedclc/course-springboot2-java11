package com.felipedclc.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipedclc.course.entities.Category;
import com.felipedclc.course.repositories.CategoryRepository;

@Service 
public class CategoryService {

	@Autowired // INJEÇÃO DE DEPENDÊNCIA AUTOMÁTICA
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get(); // RETORNA O OBJETO DENTRO DO "< >"
	}
}
