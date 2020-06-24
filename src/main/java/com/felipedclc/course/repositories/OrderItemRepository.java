package com.felipedclc.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipedclc.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

	// REPOSITORIO RESPONSÁVEL POR FAZER OPERAÇÕES COM A ENTIDADE USER
}
