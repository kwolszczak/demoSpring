package dev.kwolszczak.demo.employee.service;

import dev.kwolszczak.demo.employee.dao_oldJPA.EmployeeDAO;
import dev.kwolszczak.demo.employee.entity.Employee;
import dev.kwolszczak.demo.employee.repository_newDataJPA.EmployeeRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    //private final EmployeeDAO repo;
    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Employee> findAll() {
        return repo.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = repo.findById(id);
        Employee theEmployee = null;
        if (result.isPresent()) {
            theEmployee = result.get();
        }else {
            throw new RuntimeException("Couln't find id");
        }
        return theEmployee;
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return repo.save(employee);
    }
}
