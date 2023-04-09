package org.example.services;

import org.example.drools.DroolsSetUp;
import org.example.models.Applicant;
import org.example.models.SuggestedRole;
import org.kie.api.runtime.KieSession;


public class RoleService {

    public static void assignRoleToApplicant(Applicant applicant) throws Exception {
        SuggestedRole suggestedRole = new SuggestedRole();
        assignRole(applicant, suggestedRole);
        System.out.println("Suggested Role : " + suggestedRole.getRole());
    }

    public static void assignRole(Applicant applicant, SuggestedRole suggestedRole) throws Exception {
        KieSession kieSession = DroolsSetUp.getSession();
        kieSession.insert(applicant);
        kieSession.setGlobal("suggestedRole", suggestedRole);
        kieSession.fireAllRules();
    }
}
