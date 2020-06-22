package com.felipedclc.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipedclc.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	// REPOSITORIO RESPONSÁVEL POR FAZER OPERAÇÕES COM A ENTIDADE USER
}
