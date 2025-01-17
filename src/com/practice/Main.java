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
        Product shirt1 = new Product(101,"White Shirt", 100, 10);
        Product shirt2 = new Product(102, "Blue Shirt", 100, 15);
        Product pants1 = new Product(103, "Black Formal Pants", 150, 5);
        Product pants2 = new Product(104, "Brown Formal Pants", 150, 7);
        //Initializing ShoppingCart Object
        ShoppingCart sc1 = new ShoppingCart();

        //Initializing a Customer Object
        Customer arpan = new Customer(101, "Arpan", "arpan@email.com", "9970986473");
        //Assigning Customer a Shopping cart
        sc1.setCustomer(arpan);

        try{
            //Placing Orders
            Order order1 = new Order(1, arpan, shirt1, 5);
            Order order2 = new Order(2, arpan, pants2, 3);
            Order order3 = new Order(3, arpan, pants1, 2);

            //Adding orders to shopping cart
            sc1.addOrder(order1);
            sc1.addOrder(order2);
            sc1.addOrder(order3);
            //removing order from shopping cart
            sc1.removeOrder(3);
            //Viewing the shopping cart
            sc1.viewCart();
        }
        catch(StockUnavailableException e){
            System.out.println(e.getMessage());
        }
        catch(InvalidOrderException e){
            System.out.println(e.getMessage());
        }
        catch(OrderNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        //Checking out of shopping cart
        sc1.checkout();
    }
}
