package com.felipedclc.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipedclc.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	// REPOSITORIO RESPONSÁVEL POR FAZER OPERAÇÕES COM A ENTIDADE USER
}
