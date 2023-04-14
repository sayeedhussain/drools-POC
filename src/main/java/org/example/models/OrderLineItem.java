package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class OrderLineItem {
    private String id;
    private String productId;
    @Getter
    private int quantity;
    @Getter
    private double pricePerUnit;
}
