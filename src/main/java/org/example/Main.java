package org.example;

import org.example.models.Order;
import org.example.models.OrderLineItem;
import org.example.services.OrderService;

import java.text.MessageFormat;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Order order1 = getOrder1();
        order1 = OrderService.applyDiscount(order1);
        System.out.println(
                MessageFormat.format("Order Amount: {0}, Order Discount: {1}, Amount Payable: {2}", order1.getAmount(), order1.getDiscount(), order1.getAmountPayable())
        );

        Order order2 = getOrder2();
        order2 = OrderService.applyDiscount(order2);
        System.out.println(
                MessageFormat.format("Order Amount: {0}, Order Discount: {1}, Amount Payable: {2}", order2.getAmount(), order2.getDiscount(), order2.getAmountPayable())
        );

    }

    private static Order getOrder1() {
        OrderLineItem orderLineItem1 = new OrderLineItem("1", "product1", 1, 1200.00);
        OrderLineItem orderLineItem2 = new OrderLineItem("2", "product2", 1, 500.00);
        return new Order("1", List.of(orderLineItem1, orderLineItem2));
    }

    private static Order getOrder2() {
        OrderLineItem orderLineItem1 =  new OrderLineItem("1", "product1", 2, 1200.00);
        return new Order("2", List.of(orderLineItem1));
    }

}
