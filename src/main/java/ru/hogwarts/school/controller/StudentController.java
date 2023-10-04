package ru.hogwarts.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.Collections;


@RestController
@RequestMapping("student")
public class StudentController {

    private StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public Student get(@PathVariable Long id) {
        return studentService.read(id);
    }

    @PostMapping
    public Student post(@RequestBody Student student) {
        return studentService.create(student);
    }

    @PutMapping
    public Student put(@RequestBody Student student) {
        return studentService.update(student);
    }

    @DeleteMapping("{id}")
    public Student ydolit(@PathVariable Long id) {
        return studentService.delete(id);
    }
    @GetMapping
    public ResponseEntity<Collection<Student>> findStudents(@RequestParam(required = false) int age) {
        if (age > 0) {
            return ResponseEntity.ok(studentService.findByAge(age));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }

     }

