package com.fahreza.amigoscode.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public boolean addNewStudent(Student student) {
        // System.out.println(student);
        Student db = studentRepository.save(student);
        return db.getId() != null;
    }

    public boolean deleteStudent(Long id) {
        boolean exist = studentRepository.existsById(id);
        if (!exist) {
            throw new IllegalStateException(
                    "Not found student with id = " + id
            );
        }

        studentRepository.deleteById(id);
        return true;
    }

    @Transactional
    public boolean updateStudent(Long id, Student student) {
        Student dbObject = studentRepository.findById(id).orElseThrow(
                () -> new IllegalStateException((
                        "Not found student with id = " + id
                        ))
        );

        if (student.getName() != null && !Objects.equals(student.getName(), "")) {
            dbObject.setName(student.getName());
        }

        if (student.getBirthDate() != null) {
            dbObject.setBirthDate(student.getBirthDate());
        }

        return true;
    }
}
