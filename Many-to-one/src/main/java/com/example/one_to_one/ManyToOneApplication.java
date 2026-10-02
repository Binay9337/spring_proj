package com.example.one_to_one;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class ManyToOneApplication {
    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;

    public static void main(String[] args) {
        SpringApplication.run(ManyToOneApplication.class);
    }

    @Bean
    public CommandLineRunner commandLineRunner(){
        return args -> {
    //  oneWayBinding();
            Teacher newTeacher = Teacher.builder().teacherName("Ankit").build();
            Subject subject1 = Subject.builder().subjectName("C").teacher(newTeacher).build();
            Subject subject2 = Subject.builder().subjectName("C++").teacher(newTeacher).build();
            Subject subject3 = Subject.builder().subjectName("Java").teacher(newTeacher).build();

            newTeacher.setSubjects(List.of(subject1,subject2,subject3));

//            upddate
            Teacher newTeacher2 = Teacher.builder().teacherName("Ram").build();

            List<Subject> subjects = newTeacher.getSubjects();

         subjects.forEach(sub -> sub.setTeacher(newTeacher2));

//         delete
        teacherRepository.deleteById(4);

//            extract

            teacherRepository.findById(1).orElseThrow().getSubjects().forEach(subject -> {
                System.out.println(subject.getTeacher().getTeacherName() +" ==>> "+subject.getSubjectName()); });

        };
    }
    private void oneWayBinding(){
        Teacher teacher = Teacher.builder().build();
        Subject subject1 = Subject.builder().subjectName("C").teacher(teacher).build();
        Subject subject2 = Subject.builder().subjectName("C++").teacher(teacher).build();
        Subject subject3 = Subject.builder().subjectName("Java").teacher(teacher).build();

        subjectRepository.saveAll(List.of(subject1,subject2,subject3));


//        update
        Teacher teacher1 = subjectRepository.findById(2).orElseThrow().getTeacher();
        subject1.setTeacher(teacher1);

//        Delete
        subjectRepository.deleteById(1);

//        extract
        subjectRepository.findAll().forEach(subject -> System.out.println(subject.getSubjectName() + "--->>"+subject.getTeacher().getTeacherName()) );
    }
}
