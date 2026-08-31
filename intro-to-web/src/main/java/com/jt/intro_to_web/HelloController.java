package com.jt.intro_to_web;

import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @RequestMapping("/home")
    public void sayHello(PrintWriter writer) {
        System.out.println("Hello web");
        writer.println("<h1>Hello Spring Web</h1>  <p> Welcome Home </p>");
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact_page";
    }

    // @RequestMapping("/submit-details")
    // public String submitForm(
    // @RequestParam("name"/* give the name what is present in the name attribute
    // */) String name1,
    // @RequestParam String phone, Model model) {
    // System.out.println("submit details handled");
    // System.out.println("name is: " + name1 + " " + "phone is: " + phone);

    // model.addAttribute("name", name1);
    // model.addAttribute("phone", phone);

    // return "details-page";
    /*
     * @RequestMapping(value = "/submit-details", method = RequestMethod.POST)
     * public String submitForm(
     * 
     * @RequestParam(value = "name", required = false, defaultValue = "Springboot")
     * String name1,
     * 
     * @RequestParam String phone, Model model) {
     * System.out.println("submit details handled");
     * System.out.println("name is: " + name1 + "    " + "phone is: " + phone);
     * 
     * model.addAttribute("name", name1);
     * model.addAttribute("phone", phone);
     * 
     * return "details-page";
     * 
     * }
     */

    /*
     * required(false) ======= required is used if name attribute is not there in
     * query param then
     * it throws error if i do required false then this error will not show
     * it will consider it as a otional
     * 
     * ======= default value is provided to give default value
     * 
     */

    @RequestMapping(value = "/submit-details", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute Person person, Model model) {
        model.addAttribute("name", person.getName1());
        model.addAttribute("phone", person.getPhone());

        return "details-page";

    }
}