package com.felipedclc.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipedclc.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	// REPOSITORIO RESPONSÁVEL POR FAZER OPERAÇÕES COM A ENTIDADE USER
}
