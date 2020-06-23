package com.felipedclc.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipedclc.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	// REPOSITORIO RESPONSÁVEL POR FAZER OPERAÇÕES COM A ENTIDADE USER
}
