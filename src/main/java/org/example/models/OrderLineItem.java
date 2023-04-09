package org.example.models;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OrderLineItem {
    public String id;
    public String productId;
    public int quantity;
    public double pricePerUnit;
}
