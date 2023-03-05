package com.clean.code.springboot.model;

public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private String course;

    public Student(Long id, String firstName, String lastName, String course) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
