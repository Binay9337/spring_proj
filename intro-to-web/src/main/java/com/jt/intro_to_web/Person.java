package com.jt.intro_to_web;

public class Person {
    private String phone;
    private String name1;

    public String getName1() {
        return name1;
    }

    public void setName(String name1) {
        this.name1 = name1;
        System.out.println("this is name field");
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
