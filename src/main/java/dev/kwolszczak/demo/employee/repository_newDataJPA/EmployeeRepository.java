package dev.kwolszczak.demo.employee.repository_newDataJPA;

import dev.kwolszczak.demo.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {


    List<Employee> findAllByOrderByLastNameAsc();
}
