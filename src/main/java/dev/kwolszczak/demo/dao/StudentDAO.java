package dev.kwolszczak.demo.dao;

import dev.kwolszczak.demo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(long id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(long id);

    int deleteAll();
}
