
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import ru.usatu.students.Student;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
@XmlRootElement(name="students")
@XmlAccessorType(XmlAccessType.FIELD)
public class StudentList {
    @XmlElement(name="student")
    private List<Student> students;
    
    public List<Student> getStudents(){
        return students;
    }
    
    public void setStudents(List<Student> students){
        this.students=students;
    }
}
