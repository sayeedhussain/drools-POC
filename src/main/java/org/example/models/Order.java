package org.example.models;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class Order {
    public String id;
    public List<OrderLineItem> lineItems;
    public double discount;
    public double amount;
    public double amountPayable;

    public void setAmount() {
        amount = lineItems.stream().map(item -> item.pricePerUnit * item.quantity).reduce((double) 0, (a, b) -> a + b);
    }
}
