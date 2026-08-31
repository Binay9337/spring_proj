package com.jt.Into_To_Rest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tools.jackson.core.exc.JacksonIOException;
import tools.jackson.databind.ObjectMapper;

// @Controller
// @ResponseBody
@RestController
public class StudentController {
    ObjectMapper objectMapper;

    public StudentController(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
    }

    @ResponseBody // it tells spring to send json object
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public Student getStudent() {
        return new Student(101, "Ankit", new String[] { "java", "pyhon" });

    }

    @RequestMapping("/student1")
    public void converJavaObjectToJson() throws JacksonIOException {
        Student student = new Student(101, "Ankit", new String[] { "java", "pyhon" });

        String json = objectMapper.writeValueAsString(student);

        System.out.println("json value is: " + json);
    }

    @RequestMapping("/student2")
    public void converJsonObjectToJav() throws JacksonIOException {

        String json = """
                             {
                "id" : 102,
                "name" : "Aniket",
                "Courses" : ["C","java"]
                }
                        """;

        Student student = objectMapper.readValue(json, Student.class);
        System.out.println(student);
    }

    @RequestMapping("/fruits")
    // @ResponseBody
    public List<String> getString() {
        return List.of("apple", "mango");
    }

}

/*
 * springboot use jakson library to change java object to json object and
 * viseversa
 * jackson library uses ObjectMapper class to change java object to json Object
 * 
 * java object to json ----> writeValueAsString(object)
 * json to java object ----> readValue(json_object,className.class)
 */