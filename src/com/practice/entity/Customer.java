package com.practice.entity;

//Represents a customer in the system.
public class Customer {

	private int id;
	private String name;
	private String email;
	private String phone;

	//Constructor to initialize all attributes.
	public Customer(int id, String name, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	//equals() and hashCode() to compare customers by their id.
	@Override
	public int hashCode() {
		return email.hashCode() + name.hashCode() + id + phone.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null && getClass() != obj.getClass())
			return false;
		Customer customer = (Customer) obj;
		return email.equals(customer.email) && id == customer.id && name.equals(customer.name)
				&& phone.equals(customer.phone);
	}

	//toString() to display customer details.
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
}
