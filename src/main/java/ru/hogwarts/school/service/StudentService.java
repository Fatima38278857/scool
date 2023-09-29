package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.stream.Stream;

@Service
public class StudentService {

    private final HashMap<Long, Student> hashMapStudent = new HashMap<>();
    private long shot2 = 0;

    // В каждом сервисе реализовать CRUD-методы для создания, чтения, изменения и удаления сущностей.

    public Student create(Student student) {
        student.setId(++shot2);
        hashMapStudent.put(shot2, student);
        return student;
    }


    public Student read(long id) {
        return hashMapStudent.get(id);

    }

    public Student update(Student student) {
        return hashMapStudent.put(shot2, student);
    }

    public Student delete(long id) {
        return hashMapStudent.remove(id);
    }


    }

