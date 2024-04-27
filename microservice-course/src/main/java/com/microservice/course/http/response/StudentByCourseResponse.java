package com.microservice.course.http.response;

import com.microservice.course.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentByCourseResponse {

    // Esto es lo que se le va a devolver al clienre cuando este consulte el microservicio
    private String courseName;
    private String teacher;
    private List<StudentDTO> studentDTOList;
}
