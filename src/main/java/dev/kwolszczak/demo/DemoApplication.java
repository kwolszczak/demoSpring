package dev.kwolszczak.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/* // for scanning diffrent locations than default to find @components and injection
@SpringBootApplication(
		scanBasePackages = {"dev.kwolszczak.demo",
							"dev.kwolszczak.util"}
)*/
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
