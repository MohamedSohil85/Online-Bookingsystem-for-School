package com.onlinebookingsystem.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idLong;
    private String lastName;
    private String firstName;
    @OneToMany
    private List<Course> courses;
    public Long getIdLong() {
        return idLong;
    }
    public void setIdLong(Long idLong) {
        this.idLong = idLong;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public List<Course> getCourses() {
        return courses;
    }
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Student [idLong=");
        builder.append(idLong);
        builder.append(", lastName=");
        builder.append(lastName);
        builder.append(", firstName=");
        builder.append(firstName);
        builder.append(", courses=");
        builder.append(courses);
        builder.append("]");
        return builder.toString();
    }


}
