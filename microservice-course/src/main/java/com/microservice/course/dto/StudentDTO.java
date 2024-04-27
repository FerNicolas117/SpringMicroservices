package com.microservice.course.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Se tienen todas las caracteristicas del Entity de Studen
 * exepto el Id.
 * Es una representacion del Entity de nuestro microservicio de Estudiante -> Student.
 * DTO -> Data Transfer Object.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private String name;
    private String lastName;
    private String email;
    private Long courseId;
}
