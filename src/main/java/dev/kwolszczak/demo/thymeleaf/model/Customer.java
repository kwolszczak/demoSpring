package dev.kwolszczak.demo.thymeleaf.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Customer {

    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, max = 10)
    private String lastName;

    public Customer() {
    }
}
