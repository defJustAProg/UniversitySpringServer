/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.usatu.students;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Admin
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "students")
public class Student {
    
    @XmlElement(name="id")
    @Id
    private int id;
    @XmlElement(name="name")
    @Column
    private String name;
    
    public Student(){
        
    }
    
    public Student(int id,String name){
        this.id=id;
        this.name=name;
    }
    
    public int getId(){return id;}
    public void setID(int id){this.id=id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
}
