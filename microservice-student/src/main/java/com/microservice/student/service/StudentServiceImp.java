package com.microservice.student.service;

import com.microservice.student.entities.Student;
import com.microservice.student.persistence.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements IStudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        // Trata de buscarlo y no se encuentra devuelve un error.
        return studentRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
        System.out.println(student.toString());
    }

    @Override
    public List<Student> findByIdCourse(Long idCourse) {
        return studentRepository.findAllStudentByCourseId(idCourse);
    }
}
