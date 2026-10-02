package com.example.one_to_one;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class OneToOneApplication {

	private final StudentRepository studentRepository;
	private final AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
//owningSide();

		};
	}
	public void owningSide(){
		Address address = Address.builder().city("BBSR").state("Odisha").country("IN").build();
		Student student = Student.builder().studentName("subhra").studentEmail("s@gmail.com").address(address).build();
//	studentRepository.save(student); // because owning side was tried to be saved but inverse side was not saved

//	for this error we have two ideas to solution
//	1.manually save address and then add it and save
//	addressRepository.save(address);
//	studentRepository.save(student);
//	2. use cascading
		studentRepository.save(student);

//	update

		Student existingStudent = studentRepository.findById(4).orElseThrow();
		existingStudent.setStudentName("padia");
		Address existingAddress = existingStudent.getAddress();
		existingAddress.setCity("ctc"); // it wont update in adddresss table  qso we can manual update or use cascade.mrge
		studentRepository.save(existingStudent);

//	remove
//	studentRepository.deleteById(5); // it also same owning side delete but inverse not delete


// retrieve
//	Student studentWithRoll5 = studentRepository.findById(5).orElseThrow();
//	System.out.println("student Name is: "+ studentWithRoll5.getStudentName());
//	System.out.println("student email is: "+ studentWithRoll5.getStudentEmail());
//
//	Address studentWithRoll5Address = studentWithRoll5.getAddress();
//	System.out.println("Address city "+ studentWithRoll5Address.getCity());
//	System.out.println("Address state "+ studentWithRoll5Address.getState());
//	System.out.println("Address Country "+ studentWithRoll5Address.getCountry());
	};

	public void inverseSide(){
//		save
		Student student = Student.builder().studentName("xyz").studentEmail("x@gmail.com").build();
		Address address = Address.builder().city("BBSR").state("Odisha").country("IN").student(student).build();
		student.setAddress(address);
		addressRepository.save(address);

//		update
		Address address2 = addressRepository.findById(3).orElseThrow();
		Student student1 = address2.getStudent();
		student1.setStudentName("ram");
		addressRepository.save(address2);

//		delete
		addressRepository.deleteById(4);



	}
}


//if i make lazy fetch type then inverse side won't be retrieved. if eager fetch type then it comes
