package org.example.drools;

import org.drools.core.event.DefaultAgendaEventListener;
import org.kie.api.definition.rule.Rule;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.runtime.rule.Match;

import java.util.ArrayList;
import java.util.List;

public class TrackingAgendaEventListener extends DefaultAgendaEventListener {

    private List<Rule> matchedRules = new ArrayList<>();

    @Override
    public void afterMatchFired(AfterMatchFiredEvent event) {
        Rule rule = event.getMatch().getRule();
        matchedRules.add(rule);
    }

    public boolean isRuleFired(String ruleName) {
        for (Rule rule : matchedRules) {
            if (rule.getName().equals(ruleName)) {
                return true;
            }
        }
        return false;
    }

    public void reset() {
        matchedRules.clear();
    }

    public final List<Rule> getMatchedRules() {
        return matchedRules;
    }

}