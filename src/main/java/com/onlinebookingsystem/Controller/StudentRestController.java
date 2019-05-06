package com.onlinebookingsystem.Controller;

import com.onlinebookingsystem.Entity.Student;
import com.onlinebookingsystem.Exceptions.ExceptionResourceNotFound;
import com.onlinebookingsystem.Repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentRestController {
    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(value = "/getStudents", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getAllStudents() {
        return (List) studentRepository.findAll();
    }

    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createStudent(@RequestBody Student student) throws ExceptionResourceNotFound {
        if (student == null) {
            throw new ExceptionResourceNotFound("Object not found !");
        } else {

            return new ResponseEntity(studentRepository.save(student), HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "student/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudentById(@PathVariable(value = "id") Long id) throws ExceptionResourceNotFound {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (!optionalStudent.isPresent()) {
            throw new ExceptionResourceNotFound("Student not found !");
        } else {
            return optionalStudent.get();
        }

    }
    @RequestMapping(value = "/deleteStudent/{id}",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteStudent(@PathVariable(value = "id")Long id) throws ExceptionResourceNotFound {
        return studentRepository.findById(id).map(student -> {
                studentRepository.delete(student);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ExceptionResourceNotFound("student not found !"));
    }

    @RequestMapping(value="/updateStudent/{id}", method=RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateStudent(@PathVariable (value = "id")Long id,@RequestBody Student newStudent) throws ExceptionResourceNotFound {
        return studentRepository.findById(id).map(student -> {
               student.setFirstName(newStudent.getFirstName());
               student.setLastName(newStudent.getLastName());
               studentRepository.save(student);
               return ResponseEntity.ok().build();
        }).orElseThrow(()->new ExceptionResourceNotFound("Student not found !"));
    }
}