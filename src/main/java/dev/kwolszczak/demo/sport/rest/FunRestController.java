package dev.kwolszczak.demo.sport.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${info.app.MilO}")
    private String propertyInfo;

    @Value("${info.fun}")
    private String propertyInfoNext;

    @GetMapping("/")
    public String  sayHello() {
        return "Hello World! with dev tools";

    }

    @GetMapping("/workout")
    public String getWorkout() {
        return "run hard every day!";
    }

    @GetMapping("/fortune")
    public String getFortune() {
        System.out.println(propertyInfoNext);
        return propertyInfo;
    }
}
