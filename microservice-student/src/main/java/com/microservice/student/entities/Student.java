package com.microservice.student.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Relacion -> Un estudiante puede estar inscrito en uno o mas cursos,
 *              y un curso puede tener muchos estudiantes.
 *              La relacion es de muchos a muchos.
 */
@Data
@Entity
@Builder
@Table(name = "student")
@AllArgsConstructor // Constructor que toma todos los campos como argumentos
@NoArgsConstructor // Constructor default, requerido por JPA e Hibernate
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "last_name")
    private String lastName;
    private String email;

    @Column(name = "course_id")
    private Long courseId;
}
