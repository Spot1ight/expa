package com.automation.expa.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "STUDENTS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Student {

    @Id
    private Long id;
    private String fullName;
    private LocalDateTime birthday;
    private String address;


}
