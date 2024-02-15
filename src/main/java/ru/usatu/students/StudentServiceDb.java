/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.usatu.students;

import java.util.List;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
@Primary
public class StudentServiceDb implements StudentService {
    private final StudentRepository studentRepository;
    
    public StudentServiceDb(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    
 

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
    
    
    @Override
    public Student getStudent(int id){
        try{
            return studentRepository.findById(id).orElse(new Student());
        }
        catch(Exception e){
            
        }
        return new Student();
    }
    
    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
    
    @Override
    public Student editStudent(int id, String name) {
        Student findStudent = getStudent(id);
        findStudent.setName(name);
        return studentRepository.save(findStudent);
    }
    
    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
