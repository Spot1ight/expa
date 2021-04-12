package com.automation.expa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class Controller {

    private TService tService;

    @Autowired
    public Controller(TService tService) {
        this.tService = tService;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable Long id) {
        return tService.getStudent(id);
    }

    @PostMapping("/students")
    public List<Student> add(@RequestBody Student student) {
        tService.add(student);
        return tService.getAll();
    }

    @DeleteMapping("/students/{id}")
    public List<Student> delete(@PathVariable Long id) {
        tService.delete(id);
        return tService.getAll();
    }

    @DeleteMapping("/students")
    public List<Student> delete() {
         tService.deleteAll();
         return tService.getAll();
    }

    @GetMapping("/students")
    public List<Student> getAll() {
        return tService.getAll();
    }

}
