package com.felipedclc.course.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELEVERED(4),
	CANCELED(5);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code; 
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) { // METODO PARA PASSAR O "CODE" E OBTER O RETORNO DO STATUS
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OederStatus code");
	}
}
