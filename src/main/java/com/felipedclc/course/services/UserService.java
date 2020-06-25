	package com.felipedclc.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.felipedclc.course.entities.User;
import com.felipedclc.course.repositories.UserRepository;
import com.felipedclc.course.services.exception.DatabaseException;
import com.felipedclc.course.services.exception.ResourceNotFoundException;

@Service 
public class UserService { 

	@Autowired // INJEÇÃO DE DEPENDÊNCIA AUTOMÁTICA
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); //RETORNA O ID OU UMA EXCEPTION 
	}
	
	public User insert(User obj) { // OPERAÇÃO PARA INSERIR NO BANCO UM OBJETO DO TIPO USER  
		return repository.save(obj);
	}
	
	public void delete(Long id) { // USAR O RuntimeException PARA DESCOBRIR O ERRO
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			 throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		try {
			User entity = repository.getOne(id); // GET ONE PREPARA O OBJETO SEM IR NO BANCO DE DADOS	
			updateData(entity, obj);
		 	return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName()); // ATUALIZANDO O NOME DO ENTITY
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
