package com.automation.expa.web.rest.dto;

import com.automation.expa.domain.Student;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class StudentDto {

    private Long id;
    private String fullName;
    private String address;
    private LocalDateTime birthday;

    public static StudentDto mapToStudentDto(Student student) {
        return StudentDto
                .builder()
                .id(student.getId())
                .fullName(student.getFullName())
                .birthday(student.getBirthday())
                .address(student.getAddress())
                .build();
    }
}
