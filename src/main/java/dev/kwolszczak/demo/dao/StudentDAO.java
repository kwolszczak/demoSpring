package dev.kwolszczak.demo.dao;

import dev.kwolszczak.demo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(long id);

    List<Student> findAll();
}
