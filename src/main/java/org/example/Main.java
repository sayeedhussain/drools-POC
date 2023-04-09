package org.example;

import org.example.models.Order;
import org.example.models.OrderLineItem;
import org.example.services.OrderService;

import java.text.MessageFormat;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Order order1 = getOrder1();
        order1 = OrderService.applyDiscount(order1);
        System.out.println(
                MessageFormat.format("Order Amount: {0}, Order Discount: {1}, Amount Payable: {2}", order1.amount, order1.discount, order1.amountPayable)
        );

        Order order2 = getOrder2();
        order2 = OrderService.applyDiscount(order2);
        System.out.println(
                MessageFormat.format("Order Amount: {0}, Order Discount: {1}, Amount Payable: {2}", order2.amount, order2.discount, order2.amountPayable)
        );

    }

    private static Order getOrder1() {

        OrderLineItem orderLineItem1 = new OrderLineItem();
        orderLineItem1.id = "1";
        orderLineItem1.productId = "product1";
        orderLineItem1.quantity = 1;
        orderLineItem1.pricePerUnit = 1200.00;

        OrderLineItem orderLineItem2 = new OrderLineItem();
        orderLineItem2.id = "2";
        orderLineItem2.productId = "product2";
        orderLineItem2.quantity = 1;
        orderLineItem2.pricePerUnit = 500.00;

        Order order = new Order();
        order.id = "1";
        order.lineItems = List.of(orderLineItem1, orderLineItem2);

        return order;
    }

    private static Order getOrder2() {

        OrderLineItem orderLineItem1 = new OrderLineItem();
        orderLineItem1.id = "1";
        orderLineItem1.productId = "product1";
        orderLineItem1.quantity = 2;
        orderLineItem1.pricePerUnit = 1200.00;

        Order order = new Order();
        order.id = "2";
        order.lineItems = List.of(orderLineItem1);

        return order;
    }

}
