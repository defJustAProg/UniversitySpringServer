/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.usatu.students;

import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
//import ru.usatu.students.Student;
import ru.usatu.students.StudentList;


/**
 *
 * @author Admin
 */
@Service
// Default inection is container
//@Primary
public class StudentServiceXML implements StudentService {
     private static final String FILE_PATH = "students.xml";
     
     @Override
     public List<Student> getStudents() {
         try{
            return getStudentList().getStudents();
         }
         catch(Exception e){       
         }
         return null;
     }
     
     @Override
     public Student getStudent(int id) {
         try{
         return (Student) getStudents().stream().filter(student -> student.getId() == id)
                .findFirst().orElse(new Student());
         }
         catch(Exception e){
           return new Student();  
         }
     }
     
     @Override
     public Student addStudent(Student student)    {
         try{
            StudentList studentList = getStudentList();
            studentList.getStudents().add(student);
            save(studentList);
         }
         catch(Exception e){
             
         }
         return student;
     }
     
     @Override
     public Student editStudent(int id, String name){
         Student findStudent = null;
         try{
            StudentList studentList = getStudentList();
            findStudent = studentList.getStudents().stream().filter(student -> student.getId() == id)
                    .findFirst().orElse(null);
            if (findStudent==null){
                return new Student();
            }
            findStudent.setName(name);
            save(studentList);
         }
         catch(Exception e){
             
         }
         return findStudent;
     }
     
     @Override
     public void deleteStudent(int id) {
         try{
            StudentList studentList = getStudentList();
            Student findStudent = studentList.getStudents().stream().filter(student -> student.getId() == id)
                    .findFirst().orElse(null);
            if (findStudent != null){
               studentList.getStudents().remove(findStudent);
               save(studentList);
           }
         }
         catch(Exception e){
             
         }
     }
     
     private StudentList getStudentList() throws Exception{
         File file = new File(FILE_PATH);
         JAXBContext context = JAXBContext.newInstance(StudentList.class);
         Unmarshaller unMarshaller = context.createUnmarshaller();
         return(StudentList) unMarshaller.unmarshal(file);
     }
     
     private void save(StudentList studentList) throws Exception{
         File file = new File(FILE_PATH);
         JAXBContext context = JAXBContext.newInstance(StudentList.class);
         Marshaller marshaller = context.createMarshaller();
         marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
         marshaller.marshal(studentList, file);
     }
}
