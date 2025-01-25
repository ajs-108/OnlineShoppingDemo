package com.practice.entity;

import com.practice.exception.StockUnavailableException;

//Represents a product in the shopping system.
public class Product {

	private int id;
	private String name;
	private double price;
	private int quantity;

	//Constructor to initialize all attributes.
	public Product(int id, String name, double price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	//Method reduceStock to decrease stock;
	public void reduceStock(int quantity) throws StockUnavailableException {
		
		if(this.quantity <= 0) {
			throw new StockUnavailableException();
		}
		else {
			this.quantity -= quantity;
		}
	}

	//equals() and hashCode() to compare products by their id.
	@Override
	public int hashCode() {
		return id + name.hashCode() + (int) price + quantity;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null && getClass() != obj.getClass())
			return false;
		Product product = (Product) obj;
		return id == product.id && name.equals(product.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(product.price) && quantity == product.quantity;
	}

	//toString() to display product details.
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
}
