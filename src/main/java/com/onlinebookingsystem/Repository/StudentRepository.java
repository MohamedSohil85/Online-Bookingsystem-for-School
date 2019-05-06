package com.onlinebookingsystem.Repository;

import com.onlinebookingsystem.Entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class StudentRepository implements CrudRepository<Student,Long> {

}
