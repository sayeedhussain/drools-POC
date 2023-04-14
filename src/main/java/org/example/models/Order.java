package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public class Order {
    private String id;
    private List<OrderLineItem> lineItems;
    @Getter
    private double amount;
    @Setter
    @Getter
    private double discount;
    @Setter
    @Getter
    private double amountPayable;

    public Order(String id, List<OrderLineItem> lineItems) {
        this.id = id;
        this.lineItems = lineItems;
        this.amount = lineItems.stream().map(item -> item.getPricePerUnit() * item.getQuantity()).reduce((double) 0, (a, b) -> a + b);
    }
}
