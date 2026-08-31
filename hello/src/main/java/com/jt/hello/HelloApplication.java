package com.jt.hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import com.Teacher;

@ImportResource("beans.xml")
@SpringBootApplication
@ComponentScan(basePackages = { "com" })
public class HelloApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HelloApplication.class, args);

		// using xml
		Greet greet = context.getBean(Greet.class);
		greet.sayHello();

		// by stereoType annotation
		Person person = context.getBean(Person.class);
		person.sayHello();

		// by @configuration
		Student std = context.getBean(Student.class);
		std.sayHello();

		Teacher teacher = context.getBean(Teacher.class);
		Teacher teacher1 = context.getBean(Teacher.class);
		teacher.sayHello();

		System.out.println(teacher.hashCode());
		System.out.println(teacher1.hashCode());

	}

}
