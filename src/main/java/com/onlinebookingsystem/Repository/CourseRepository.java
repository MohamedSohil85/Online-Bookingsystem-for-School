package com.onlinebookingsystem.Repository;

import com.onlinebookingsystem.Entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class CourseRepository implements CrudRepository<Course,Long> {
}
