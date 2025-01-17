package com.practice.entity;

import com.practice.exception.OrderNotFoundException;
import com.practice.exception.StockUnavailableException;

import java.util.ArrayList;
import java.util.List;

//Represents a customer's shopping cart.
public class ShoppingCart {

    private Customer customer;
    private List<Order> orderItems = new ArrayList<Order>();

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    //Method addOrder() to add an order to the cart.
    public void addOrder(Order order) throws StockUnavailableException {

        this.orderItems.add(order);
        order.getProduct().reduceStock(order.getQuantity());
        System.out.printf("Order%d placed successfully.%n", order.getOrderId());
    }

    //Method removeOrder() to remove an order; throws OrderNotFoundException if the order does not exist.
    public void removeOrder(int orderId) throws OrderNotFoundException {

        for (Order order : this.orderItems) {
            System.out.println(order.getOrderId());
            if (order.getOrderId() == orderId) {
                orderItems.remove(order);
            }
        }
    }

    //Method to calculate the total price of cart
    public double totalPrice() {
        double totalPrice = 0;
        for (Order order : this.orderItems) {
            totalPrice += order.calculateTotal();
        }
        return totalPrice;
    }

    //Method to view order list
    public void viewCart() throws OrderNotFoundException {
        if (orderItems.isEmpty()) {
            throw new OrderNotFoundException("Cart is empty");
        } else {
            System.out.println("\nCustomer : " + customer.getName());
            System.out.println("Order Items: " + this.orderItems);
            System.out.println("Total Price: " + totalPrice());
        }
    }

    //Method to view total price and check out(clear out the cart)
    public void checkout() {
        System.out.println("\nSuccessfully checked out.");
        System.out.println("Your total Price is: " + totalPrice());
        orderItems.clear();
    }
}
