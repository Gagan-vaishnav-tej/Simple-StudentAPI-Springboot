package com.project.StudentAPI;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentContoller {

    private final StudentService studentService;

    public StudentContoller(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/student")
    public ResponseEntity<Student> postStudent(@RequestBody Student student)
    {
        return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/student/{name}")
    public List<Student> getAllStudentsByName(@PathVariable String name){
        return studentService.getStudentByName(name);
    }

    @GetMapping("/student/id/{id}")
    public Optional<Student> getStudentById(@PathVariable Integer id){
        return studentService.getStudentByID(id);
    }

    @DeleteMapping("student/id/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return new ResponseEntity<String>(("Student with id"+id+"deleted"),HttpStatus.NO_CONTENT);
    }
/*
Why @Transactional is not required for get and only for delete 
Read Operations (like your getByName method):
Typically do not require an active transaction. JPA provides a snapshot of the entity state, and READ operations (like finding an entity) can be performed without an explicit transaction.
Write Operations (like your deleteByName method):
Require an active transaction because they modify the state of the database. Writing to the database involves creating a transactional context to ensure that changes can be rolled back if necessary.
 */
    @DeleteMapping("student/{name}")
    @Transactional
    public ResponseEntity<String> deleteStudentByName(@PathVariable String name){
        studentService.deleteByName(name);
        return ResponseEntity.ok("Student with name "+name+" deleted");
    }

}
