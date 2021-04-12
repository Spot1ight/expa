package com.automation.expa;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter
public class TService {

    private List<Student> students = new ArrayList<>();

    public Student getStudent(Long id) {
        for (Student student : this.students) {
            if (student.getId().equals(id)) return student;
        }
        return null;
    }

    public void add(Student student){
        this.students.add(student);
    }

    public void delete(Long id){
        for (Student student: this.students) {
            if (student.getId().equals(id)) this.students.add(student);
        }
    }

    public List<Student> getAll() {
        return students;
    }

    public void deleteAll() {
        students.clear();
    }



}
