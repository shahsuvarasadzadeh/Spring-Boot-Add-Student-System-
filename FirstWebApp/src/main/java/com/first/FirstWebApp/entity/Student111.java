package com.first.FirstWebApp.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Student111 {
    @Id
    @Column(name = "Students_ID")
    @Positive(message = "Zehmet olmasa musbet eded daxil edin")
    @NotNull(message = "Zehmet olmasa  eded daxil edin")
    private Integer id;

    @Column(name = "Name")
    @NotBlank(message = "Xahis olunur ad daxil edin")
    @Size(min = 3, max = 30 , message = "adin uzunlugu 3 den az ola bilmez")
    private String name;
    @Column(name = "Surname")
    @NotBlank(message = "Xahis olunur ad daxil edin")
    @Size(min = 3, max = 30 , message = "soyadin uzunlugu 3 den az ola bilmez")
    private String surname;


    @ManyToMany
    @JoinTable(name = "Students_Courses",
            joinColumns = @JoinColumn(name = "Students_ID"),
            inverseJoinColumns = @JoinColumn(name = "Course_ID"))
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Student111() {

    }

    public Student111(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


}
