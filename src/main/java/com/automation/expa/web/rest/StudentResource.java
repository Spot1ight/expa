package com.automation.expa.web.rest;

import com.automation.expa.domain.Student;
import com.automation.expa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {

    private StudentService studentService;

    @Autowired
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Student> deleteStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        studentService.deleteStudent(student);
        return ResponseEntity.ok().body(student);
    }

    @DeleteMapping("/students")
    public ResponseEntity deleteStudent() {
        studentService.removeAll();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,
                                                 @RequestBody Student student) {
        if (studentService.getStudentById(id) != null) {
            studentService.updateStudent(student);
            return ResponseEntity.ok(student);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAll();
    }

}
