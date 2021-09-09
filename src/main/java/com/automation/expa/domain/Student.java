package com.automation.expa.domain;

import com.automation.expa.web.rest.dto.StudentDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "STUDENTS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Student implements Serializable{

    @Id
    private Long id;
    private String fullName;
    private LocalDateTime birthday;
    private String address;

    public static Student mapToStudentDto(StudentDto studentDto) {
        return Student
                .builder()
                .id(studentDto.getId())
                .fullName(studentDto.getFullName())
                .birthday(studentDto.getBirthday())
                .address(studentDto.getAddress())
                .build();
    }
}
