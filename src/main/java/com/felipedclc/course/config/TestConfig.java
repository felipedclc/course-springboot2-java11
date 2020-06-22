package com.felipedclc.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.felipedclc.course.entities.User;
import com.felipedclc.course.repositories.UserRepository;

@Configuration  // CLASE ESPECÍFICA DE CONFIGURAÇÃO
@Profile("test")
public class TestConfig implements CommandLineRunner { 

	// CLASE ESPECÍFICA DE CONFIGURAÇÃO
	
	@Autowired 
	private UserRepository userRepository;       // MECANISMO AUTOMATICO DE INJEÇÃO DE DEPENDÊNCIA

	@Override
	public void run(String... args) throws Exception { // METODO SERÁ SEMPRE EXECUTADO ASSIM QUE APLICAÇÃO INICIAR
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		userRepository.saveAll(Arrays.asList(u1, u2)); // 
	}
	
	// MECANISMO AUTOMATICO DE INJEÇÃO DE DEPENDÊNCIA
	
	
	
}
