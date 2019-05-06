package com.onlinebookingsystem.Entity;

import javax.persistence.*;
import java.util.List;

public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long courseId;
    private String courseName;
    @ManyToOne
    private Teacher teacher;
    @ManyToOne
    private Student student;
    @ManyToMany
    private List<Note>notenList;
    private CourseStatus courseStatus;
    public Long getCourseId() {
        return courseId;
    }
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public List<Note> getNotenList() {
        return notenList;
    }
    public void setNotenList(List<Note> notenList) {
        this.notenList = notenList;
    }
    public CourseStatus getCourseStatus() {
        return courseStatus;
    }
    public void setCourseStatus(CourseStatus courseStatus) {
        this.courseStatus = courseStatus;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Course [courseId=");
        builder.append(courseId);
        builder.append(", courseName=");
        builder.append(courseName);
        builder.append(", teacher=");
        builder.append(teacher);
        builder.append(", student=");
        builder.append(student);
        builder.append(", notenList=");
        builder.append(notenList);
        builder.append(", courseStatus=");
        builder.append(courseStatus);
        builder.append("]");
        return builder.toString();
    }



}
