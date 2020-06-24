package com.felipedclc.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipedclc.course.entities.User;
import com.felipedclc.course.repositories.UserRepository;

@Service 
public class UserService {

	@Autowired // INJEÇÃO DE DEPENDÊNCIA AUTOMÁTICA
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get(); // RETORNA O OBJETO DENTRO DO "< >"
	}
	
	public User insert(User obj) { // OPERAÇÃO PARA INSERIR NO BANCO UM OBJETO DO TIPO USER  
		return repository.save(obj);
	}
}
