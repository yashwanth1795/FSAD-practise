package com.klu.model;
import org.springframework.stereotype.Component;

@Component
public class Product {
private int productId;
private String productname;
private double price;
private String category;
public Product() {
	this.productId=101;
	this.productname="Shoe";
	this.price=1500.23;
	this.category="FootWear";
}
public int getProductId() {
	return productId;
}
public String getProductname() {
	return productname;
}
public double getPrice() {
	return price;
}
public String getCategory() {
	return category;
}

}
