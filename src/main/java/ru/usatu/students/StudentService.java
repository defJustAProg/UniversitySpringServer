/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ru.usatu.students;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface StudentService {
    List<Student> getStudents();
    Student getStudent(int id);
    Student addStudent(Student student);
    Student editStudent(int id, String name);
    void deleteStudent(int id);
}
