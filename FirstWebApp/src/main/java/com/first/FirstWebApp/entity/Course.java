package com.first.FirstWebApp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
public class Course {
    @Id
    @JoinColumn(name = "Course_ID")
    private Integer id;

    private String name;

    private String description;

    @ManyToMany(mappedBy = "courses")
    List<Student111>student111s;


    public Course(){

    }
    public Course(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

}
