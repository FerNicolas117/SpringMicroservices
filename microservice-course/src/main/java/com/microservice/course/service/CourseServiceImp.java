package com.microservice.course.service;

import com.microservice.course.client.IStudetClient;
import com.microservice.course.dto.StudentDTO;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.persistence.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImp implements ICourseService {

    // Inyeccion de dependicas.
    @Autowired
    private ICourseRepository iCourseRepository;

    // Conexion del Cliente del Estudiante para tener es Repository de Student
    @Autowired
    private IStudetClient iStudetClient;

    @Override
    public List<Course> findAll() {
        return (List<Course>) iCourseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return iCourseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        iCourseRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentByIdCourse(Long idCourse) {

        // Consultar el Curso
        Course course = iCourseRepository.findById(idCourse).orElse(new Course());

        // Obtener los Estudiantes
        /**
         * Con esto nuestro microservicio Course se va a conectar por debajo con el
         * microservicio Student y va a recuperer la respuesta y la va a guardar en
         * studentDTOList.
         */
        List<StudentDTO> studentDTOList = iStudetClient.findAllStudentByCourse(idCourse);

        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }
}
