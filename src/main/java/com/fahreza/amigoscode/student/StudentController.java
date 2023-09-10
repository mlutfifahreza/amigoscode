package com.fahreza.amigoscode.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public boolean registerNewStudent(@RequestBody Student student) {
        return studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{id}")
    public boolean deleteStudent(@PathVariable("id") Long id) {
        return studentService.deleteStudent(id);
    }

    @PutMapping(path = "{id}")
    public boolean updateStudent(
            @PathVariable("id") Long id,
            @RequestBody Student student
    ) {
        return studentService.updateStudent(id, student);
    }

}
