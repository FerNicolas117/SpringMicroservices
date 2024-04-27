package com.microservice.course.service;

import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;

import java.util.List;

public interface ICourseService {

    List<Course> findAll();

    Course findById(Long id);

    void save(Course course);

    // Implementacion del metodo que va a llamar a nuestro microservicio de Estudiante
    StudentByCourseResponse findStudentByIdCourse(Long idCourse);
}
