package dev.kwolszczak.demo.thymeleaf.controller;

import dev.kwolszczak.demo.thymeleaf.model.Customer;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    // add an initbinder ... to convert trim input string
    // remove leading and trailing whitespaces
    // it's global
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


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

        log.info("Customer lastName: '{}'",theCustomer.getLastName());

        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(x->log.info("ERROR: {}",x));

            theBindingResult.getAllErrors().forEach(x->log.info("LOG: {}",x));
            return "customer-form";
        } else {
            return "customer-confirmation";
        }
    }
}
