package ru.hogwarts.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("faculty")
public class FacultyController {


    private FacultyService facultyService;


    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    @GetMapping("{id}")
    public Faculty get(@PathVariable Long id) {
        return facultyService.readFaculty(id);
    }

    @PostMapping
    public Faculty post(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @PutMapping
    public Faculty put(@RequestBody Faculty faculty) {
        return facultyService.updateFaculty(faculty);
    }

    @DeleteMapping("{id}")
    public Faculty ydolit(@PathVariable Long id) {
        return facultyService.deleteFaculty(id);
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> findFaculties(@RequestParam(required = false) String color) {
        if (color != null && !color.isBlank()) {
            return ResponseEntity.ok(facultyService.findColor(color));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }
}

