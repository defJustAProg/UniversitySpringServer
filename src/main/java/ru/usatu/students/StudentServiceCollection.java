/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.usatu.students;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */

@Service
public class StudentServiceCollection implements StudentService{
    private List<Student> students = new ArrayList<>();
    
    public StudentServiceCollection(){
        students.add(new Student(1,"Ivan"));
        students.add(new Student(2,"Ivan2"));
        students.add(new Student(3,"Ivan3"));
    }
    
    @Override
    public List<Student> getStudents(){return students;}
    
    @Override
    public Student getStudent(int id){
        return students.stream().filter(student -> student.getId() == id).findFirst()
                .orElse(new Student());
    }
    
    @Override
    public Student addStudent(Student student){
        students.add(student);
        return student;
    }
    
    @Override
    public Student editStudent(int id, String name){
        return students.stream().filter(student -> student.getId() == id).findFirst()
                .map(student -> {
                    student.setName(name);
                    return student;
                }).orElse(new Student());
    }
    
    @Override
    public void deleteStudent(int id){
        students = students.stream().filter(student -> student.getId() != id)
                .collect(Collectors.toList());
    }


}
