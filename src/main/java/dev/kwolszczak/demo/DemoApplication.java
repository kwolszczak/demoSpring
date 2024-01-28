package dev.kwolszczak.demo;

import dev.kwolszczak.demo.student.dao.StudentDAO;
import dev.kwolszczak.demo.student.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

 // for scanning diffrent locations than default to find @components and injection
@SpringBootApplication(
		scanBasePackages = {"dev.kwolszczak.demo",
							"dev.kwolszczak.employee",
							"dev.kwolszczak.poligon"}
)
//@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner->{
			System.out.println("Hello World");
		//	saveStudent(studentDAO);
			getStudent(studentDAO);
			getAllStudents(studentDAO);
			updateStudent(studentDAO);
			//deleteStudent(studentDAO);
		} ;
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: "+ studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrive student based on the id: primary key
		int studentId =1;
		System.out.println("Getting student whit id: "+studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "scooby"
		System.out.println("Updating student ...");
		myStudent.setFirstName("Scooby2");

		// update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println(studentDAO.findById(studentId));

	}

	private void getAllStudents(StudentDAO studentDAO) {
		studentDAO.findAll().forEach(System.out::println);
	}

	private void getStudent(StudentDAO studentDAO) {
		var student=studentDAO.findById(4);
		System.out.println(student);
	}

	private static void saveStudent(StudentDAO studentDAO) {
		//create
		System.out.println("Creating new student object....");
		Student tmpStudent = new Student();
		tmpStudent.setFirstName("Tom");
		tmpStudent.setLastName("Bobinsky");
		tmpStudent.setEmail("tbobinsky@example.com");

		//save
		System.out.println("Saving student");
		studentDAO.save(tmpStudent);

		//display id of saved object
		System.out.println("Saved student: Generated id: "+tmpStudent.getId());
	}

}
