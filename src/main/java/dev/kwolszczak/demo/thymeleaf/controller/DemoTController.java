package dev.kwolszczak.demo.thymeleaf.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class DemoTController {

    //requestMapping accept all http request: get, post, put ....
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    //when it's post method you will not see request param in browser url, they are in post body
    @PostMapping("/processForm")
    public String processForm(Model theModel, @RequestParam("studentName") String name) {
        theModel.addAttribute("theName", name.toUpperCase());
        theModel.addAttribute("theDate", LocalDate.now());
        return "helloworld";
    }

    @RequestMapping("/processFormTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        String name = request.getParameter("studentName");
        model.addAttribute("message", name.toUpperCase());
        return "helloworld";
    }
}
