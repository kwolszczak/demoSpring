package dev.kwolszczak.demo.thymeleaf.model;

import lombok.Data;

@Data
public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private String city;
    private String favouriteLanguage;

    public Student() {
    }
}
