package com.microservice.student.persistence;

import com.microservice.student.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Long porque el id de la entidad Student es de
 * tipo Long.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.courseId = :idCourse")
    List<Student> findAllStudentByCourseId(Long idCourse);

    // List<Student> findAllByCourseId(Long idCourse);
}
