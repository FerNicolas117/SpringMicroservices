package com.microservice.course.controller;

import com.microservice.course.entities.Course;
import com.microservice.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/course")
public class CourseController {

    // Inyeccion del Servicio.
    @Autowired
    private ICourseService iCourseService;

    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody Course course) {
        iCourseService.save(course);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<?> findAllCourse(){
        return ResponseEntity.ok(iCourseService.findAll());
    }

    @GetMapping(path = "/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(iCourseService.findById(id));
    }

    @GetMapping(path = "/search-student/{idCourse}")
    public ResponseEntity<?> findStudentByIdCourse(@PathVariable Long idCourse) {
        return ResponseEntity.ok(iCourseService.findStudentByIdCourse(idCourse));
    }
}
