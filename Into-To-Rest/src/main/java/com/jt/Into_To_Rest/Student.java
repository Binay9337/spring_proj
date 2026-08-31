package com.jt.Into_To_Rest;

public class Student {
    private int id;
    private String name;
    private String cources[];

    public Student() {
    }

    public Student(int id, String name, String[] cources) {
        this.id = id;
        this.name = name;
        this.cources = cources;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getCources() {
        return cources;
    }

    public void setCources(String[] cources) {
        this.cources = cources;
    }

}
