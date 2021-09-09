package com.automation.expa.web.rest;

import com.automation.expa.domain.Student;
import com.automation.expa.exception.StudentNotFoundException;
import com.automation.expa.repository.StudentRepository;
import com.automation.expa.service.StudentService;
import com.automation.expa.web.rest.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentResource {

    private final StudentService studentService;
    private final StudentRepository studentRepository;

    @Autowired
    public StudentResource(StudentService studentService,
                           StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Long id) {
        return studentRepository.findById(id)
                .map(StudentDto::mapToStudentDto)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        Student student = Student.mapToStudentDto(studentDto);
        return ResponseEntity.ok().body(studentDto);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Student> deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/students")
    public ResponseEntity deleteStudent() {
        studentService.removeAll();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/students/{id}")
    public ResponseEntity updateStudent(@PathVariable Long id,
                                                 @RequestBody StudentDto studentDto) {

        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = studentRepository.save(Student.mapToStudentDto(studentDto));
            return ResponseEntity.ok().body(StudentDto.mapToStudentDto(student));
        } else {
            throw new StudentNotFoundException(id);
        }
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
