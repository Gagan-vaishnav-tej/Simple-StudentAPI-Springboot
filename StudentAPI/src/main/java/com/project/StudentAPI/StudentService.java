package com.project.StudentAPI;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentByID(Integer id){
        return studentRepository.findById(id);
    }

    public List<Student> getStudentByName(String name){
        return studentRepository.findAllByName(name);
    }

    public void deleteStudent(Integer id){
        studentRepository.deleteById(id);
    }

    public void deleteByName(String name){
        studentRepository.deleteByName(name);
    }

}
