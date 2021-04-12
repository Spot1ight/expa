package com.automation.expa;

import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@ToString
public class Student {

    private Long id;
    private String fullName;
    private LocalDateTime birthday;
    private String address;


}
