package org.example;

import org.example.models.Applicant;
import org.example.models.SuggestedRole;
import org.example.services.RoleService;

public class Main {
    public static void main(String[] args) throws Exception {
        Applicant applicant = new Applicant("David", 37, 1600000.0, 11);
        SuggestedRole role = RoleService.assignRoleToApplicant(applicant);
        System.out.println("Suggested Role : " + role.getRole());
    }
}
