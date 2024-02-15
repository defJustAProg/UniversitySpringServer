/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.usatu.students;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;
    
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    
    @GetMapping
    public @ResponseBody
    List<Student> getStudents(){ return studentService.getStudents(); }
    
    @GetMapping("/{id}")
    public @ResponseBody
    Student getStudent(@PathVariable int id){ return studentService.getStudent(id); }
    
    @PostMapping
    public @ResponseBody
    Student addStudent(@RequestBody Student student) { return studentService.addStudent(student); }
    
    @PutMapping("/{id}")
    public @ResponseBody
    Student editStudent(@PathVariable int id, @RequestBody String name){ return studentService.editStudent(id, name); }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable int id){ studentService.deleteStudent(id); }
    
}
