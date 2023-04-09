package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Applicant {
    public String name;
    public int age;
    public double currentSalary;
    public double experienceInYears;
}
