package dev.kwolszczak.demo.thymeleaf.model;

import dev.kwolszczak.demo.thymeleaf.validation.CourseCode;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.RequiredTypes;

@Data
public class Customer {

    private String firstName;

    @NotNull(message = "is required")
    @NotBlank(message = "can't be empty")
    @Size(min = 1, max = 10, message = "is required")
    private String lastName;

    @Min(value = 0, message = "must be greater or equal than zero")
    @Max(value = 10, message = "must be lower than 11")
    @NotNull(message = "is required")
    private Integer freePasses;

    @Pattern(regexp = "\\d{2}-\\d{3}", message = "Valid postal code: xx-xxx")
    private String postalCode;

    @CourseCode
    private String courseCode;

    public Customer() {
    }
}
