package com.automation.expa.service;

import com.automation.expa.domain.Student;
import com.automation.expa.repository.StudentRepository;
import com.automation.expa.web.rest.StudentResource;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudentById(Long id) {
        return studentRepository.getOne(id);
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudentById(Long id){
        studentRepository.deleteById(id);
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public void removeAll() {
        studentRepository.deleteAll();
    }



}
