package com.klu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Order {
private int orderId;
private String customerName;
private int quantity;
@Autowired
private Product product;

public Order() {
	this.orderId=2005;
	this.customerName="patel";
	this.quantity=2;
}
public void display() {
	System.out.println("The Following are the Order Details :");
	System.out.println("OrderId : "+orderId);
	System.out.println("customerName : "+customerName);
	System.out.println("Quantity : "+quantity);
	System.out.println("The Following are the Product Details :");
	System.out.println("Product Id : "+product.getProductId());
	System.out.println("Product Name : "+product.getProductname());
	System.out.println("Product Price : "+product.getPrice());
	System.out.println("Product Category : "+product.getCategory());
}

}
