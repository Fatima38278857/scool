package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
@Service
public class FacultyService {

    private  final HashMap<Long, Faculty> hashMapFaculty = new HashMap<>();
    private long shot = 0;

    // В каждом сервисе реализовать CRUD-методы для создания, чтения, изменения и удаления сущностей.

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++shot);
        hashMapFaculty.put(shot, faculty);
        return faculty;
    }

    public Faculty readFaculty(long id){
        return hashMapFaculty.get(id);

    }

    public Faculty updateFaculty(Faculty faculty){
        return hashMapFaculty.put(shot, faculty);
    }

    public Faculty deleteFaculty(long id){
        return hashMapFaculty.remove(id);
    }


}
