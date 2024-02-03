package dev.kwolszczak.demo.employee.mvccontroller;

import dev.kwolszczak.demo.employee.entity.Employee;
import dev.kwolszczak.demo.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String getEmployees(Model theModel) {
        List<Employee> employees = service.findAll();
        //  employees.sort(Comparator.comparing(e->e.getLastName().toLowerCase()));
        theModel.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormAdd")
    public String addEmployee(Model theModel) {
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }

    @GetMapping("/showFormUpdate")
    public String updateForm(Model theModel, @RequestParam("employeeId") Integer id) {
        Employee theEmployee = service.findById(id);
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }

    //for save and update
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
        service.save(theEmployee);
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId")Integer id) {
        service.deleteById(id);
        return "redirect:/employees/list";
    }
}
