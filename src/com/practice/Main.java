package com.practice;

import com.practice.entity.Customer;
import com.practice.entity.Order;
import com.practice.entity.Product;
import com.practice.entity.ShoppingCart;
import com.practice.exception.InvalidOrderException;
import com.practice.exception.OrderNotFoundException;
import com.practice.exception.StockUnavailableException;

public class Main {

    public static void main(String[] args) {

        //Adding products to stock
        Product shirt1 = new Product(101, "White Shirt", 100, 10);
        Product shirt2 = new Product(102, "Blue Shirt", 100, 15);
        Product pants1 = new Product(103, "Black Formal Pants", 150, 5);
        Product pants2 = new Product(104, "Brown Formal Pants", 150, 7);
        //Initializing ShoppingCart Object
        ShoppingCart sc1 = new ShoppingCart();

        //Initializing a Customer Object
        Customer arpan = new Customer(101, "Arpan", "arpan@email.com", "9970986473");
        //Assigning Customer a Shopping cart
        sc1.setCustomer(arpan);

        Order order1 = null;
        Order order2 = null;
        Order order3 = null;

        try {
            //Placing Orders
            order1 = new Order(1, arpan, shirt1, 5);
            order3 = new Order(3, arpan, pants1, 5);
            //Adding orders to shopping cart
            sc1.addOrder(order1);
            sc1.addOrder(order3);

        } catch (StockUnavailableException | InvalidOrderException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //trying to remove order from shopping cart; throws OrderNotFoundException as there is no order with orderId 10
        try {
            sc1.removeOrder(10);
        } catch (OrderNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Throws InvalidOrderException as quantity of product placed exceeds its initial quantity
        try {
            order2 = new Order(2, arpan, pants2, 8);
            sc1.addOrder(order2);

        } catch (InvalidOrderException | StockUnavailableException e) {
            e.getMessage();
        }

        try {
            Thread.sleep(100);
            //Viewing the shopping cart
            sc1.viewCart();
            //Checking out of shopping cart
            sc1.checkout();
        } catch (OrderNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
