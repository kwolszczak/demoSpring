package dev.kwolszczak.demo.thymeleaf.controller;

import dev.kwolszczak.demo.thymeleaf.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${cities}")
    private List<String> cities;

    @Value("${languages}")
    private List<String> languages;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {

        // create student object
        Student theStudent = new Student();

        // add student object to the model
        theModel.addAttribute("student",theStudent);

        // add countries to the model
        theModel.addAttribute("cities", cities);
        theModel.addAttribute("languages", languages);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String showStudentInfo(@ModelAttribute Student student) {
      System.out.println(student);
        return "student";
    }
}
