package org.example.services;

import org.example.drools.DroolsSetUp;
import org.example.drools.TrackingAgendaEventListener;
import org.example.models.Order;
import org.kie.api.definition.rule.Rule;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.runtime.KieSession;

import java.util.Collection;
import java.util.List;

public class OrderService {

    public static Order applyDiscount(Order order) {
        return applyDiscountRules(order);
    }

    private static Order applyDiscountRules(Order order) {
        KieSession kieSession = DroolsSetUp.getSession();
        addEventListener(kieSession);
        kieSession.insert(order);
        kieSession.fireAllRules();
        List<Rule> matchedRules = getMatchedRules(kieSession);
        System.out.println("Matched Rules: " + matchedRules);
        return order;
    }

    private static void addEventListener(KieSession kieSession) {
        TrackingAgendaEventListener agendaEventListener = new TrackingAgendaEventListener();
        kieSession.addEventListener(agendaEventListener);
    }

    private static List<Rule> getMatchedRules(KieSession kieSession) {
        Collection<AgendaEventListener> eventListener = kieSession.getAgendaEventListeners();
        TrackingAgendaEventListener agendaEventListener = (TrackingAgendaEventListener) eventListener.stream().filter(it -> it.getClass().equals(TrackingAgendaEventListener.class)).toList().get(0);
        return agendaEventListener.getMatchedRules();
    }

}
