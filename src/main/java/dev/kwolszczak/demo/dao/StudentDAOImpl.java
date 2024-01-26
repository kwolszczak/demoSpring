package dev.kwolszczak.demo.dao;

import dev.kwolszczak.demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        //it using JPQL , Student to nazwa entity a nie nazwa tabeli
        // "FROM Student where firstName = :parametr"  //fristName to nazwa pola w entity a nie w bazie danych
        TypedQuery<Student> query =entityManager.createQuery("FROM Student order by lastName", Student.class);
        return query.getResultList();
    }

    @Override
    public Student findById(long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }
}
