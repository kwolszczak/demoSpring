package dev.kwolszczak.demo.student.rest;

import dev.kwolszczak.demo.student.entity.Student;
import dev.kwolszczak.demo.student.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();
        students.add(new Student("Poornima", "Patel", "ppatel@example.com"));
        students.add(new Student("Mario", "Rossi", "mrossi@example.com"));
        students.add(new Student("Mary", "Smith", "msmith@example.com"));
        students.add(new Student("Harry", "Maguaier", "msmith@example.com"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable("id") Integer studentId) {
        if (studentId >= students.size() || studentId < 0) {
            throw new StudentNotFoundException("Student with id '%d' not found:".formatted(studentId));
        }
        int index = studentId - 1;
        return students.get(index);
    }

}
