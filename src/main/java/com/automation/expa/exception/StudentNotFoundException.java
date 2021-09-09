package com.automation.expa.exception;

import com.automation.expa.domain.Student;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super("Student for id: [" + id + "] was not found");
    }

    public StudentNotFoundException(Student student) {
        super("Student [" + student + "] was not found");
    }
}
