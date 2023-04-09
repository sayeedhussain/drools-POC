package org.example.services;

import org.example.drools.DroolsSetUp;
import org.example.models.Order;
import org.kie.api.runtime.KieSession;

public class OrderService {

    public static Order applyDiscount(Order order) throws Exception {
        order.setAmount();
        Order orderWithDiscount = applyDiscountRules(order);
        return orderWithDiscount;
    }

    private static Order applyDiscountRules(Order order) {
        KieSession kieSession = DroolsSetUp.getSession();
        kieSession.insert(order);
        kieSession.fireAllRules();
        return order;
    }
}
