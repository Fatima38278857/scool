package ru.hogwarts.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

@RequestMapping("faculty")
@Controller
public class FacultyController {

    @Autowired
    private FacultyService facultyService;


    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    @GetMapping("{id}")
    public Faculty get(@PathVariable Long id){
        return facultyService.readFaculty(id);
    }

    @PostMapping
    public Faculty post(Faculty faculty){
        return facultyService.createFaculty(faculty);
    }

    @PutMapping
    public Faculty put(@RequestBody Faculty faculty){
        return facultyService.updateFaculty(faculty);
    }

    @DeleteMapping("{id}")
    public Faculty ydolit(@PathVariable Long id){
        return facultyService.deleteFaculty(id);
}
}
