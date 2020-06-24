package com.felipedclc.course.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.felipedclc.course.entities.pk.OrderItemPK;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId // ID COMPOSTO
	private OrderItemPK id; // ATRIBUTO IDENTIFICADOR
	
	private Integer quantity;
	private Double price;
	
	public OrderItem() {
		
	}

	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		id.setOrder(order); // CONSTRUTOR MANUAL
		id.setProduct(product); // CONSTRUTOR MANUAL
		this.quantity = quantity;
		this.price = price;
	}
	
	public Order getOrder() { // CONSTRUTOR MANUAL
		return id.getOrder();
	}
	
	public void setOrder(Order order) {// CONSTRUTOR MANUAL
		id.setOrder(order);
	}

	public Product getProduct() {// CONSTRUTOR MANUAL
		return id.getProduct();
	}
	
	public void setProduct(Product product) {// CONSTRUTOR MANUAL
		id.setProduct(product);
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
