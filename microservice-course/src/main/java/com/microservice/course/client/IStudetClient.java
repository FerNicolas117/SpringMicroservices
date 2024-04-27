package com.microservice.course.client;

import com.microservice.course.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// Nombre del microservicio el cual vamos a consultar
@FeignClient(name = "msvc-student", url = "localhost:8090/api/student")
public interface IStudetClient {

    @GetMapping(path = "/search-by-course/{idCourse}")
    List<StudentDTO> findAllStudentByCourse(@PathVariable Long idCourse);
}
