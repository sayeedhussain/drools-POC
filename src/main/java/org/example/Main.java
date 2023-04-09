package org.example;

import org.example.models.Applicant;
import org.example.services.RoleService;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");
        Applicant applicant = new Applicant("David", 37, 1600000.0, 11);
        RoleService.assignRoleToApplicant(applicant);
    }
}
