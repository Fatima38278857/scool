package ru.hogwarts.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;


@RequestMapping("student")
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public Student get(@PathVariable Long id) {
        return studentService.read(id);
    }

    @PostMapping
    public Student post(Student student) {
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
     @GetMapping({"age"})
    public Student getAge(@PathVariable int age){
        return studentService.read(age);
     }
}
