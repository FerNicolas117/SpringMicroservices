package com.microservice.student.controller;

import com.microservice.student.entities.Student;
import com.microservice.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/student")
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student) {
        iStudentService.save(student);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<?> findAllStudent() {
        return ResponseEntity.ok(iStudentService.findAll());
    }

    @GetMapping(path = "/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(iStudentService.findById(id));
    }

    /**
     * Habilitacion de un Endpoint el cual pueda ser consumido desde nuestro
     * microservicio de Cursos
     */
    @GetMapping(path = "/search-by-course/{idCourse}")
    public ResponseEntity<?> findByIdCourse(@PathVariable Long idCourse) {
        return ResponseEntity.ok(iStudentService.findByIdCourse(idCourse));
    }
}
