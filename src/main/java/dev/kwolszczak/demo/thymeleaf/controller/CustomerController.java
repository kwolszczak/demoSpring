package dev.kwolszczak.demo.thymeleaf.controller;

import dev.kwolszczak.demo.thymeleaf.model.Customer;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/")
    public String showForm(Model theModel) {

        theModel.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/customerProcessForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer theCustomer,
            Errors errors,
            BindingResult theBindingResult) {
        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(System.out::println);
            theBindingResult.getAllErrors().forEach(System.out::println);

            return "customer-form";
        } else {
            return "customer-confirmation";
        }

    }
}
