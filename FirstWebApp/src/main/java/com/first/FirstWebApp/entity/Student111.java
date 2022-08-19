package com.first.FirstWebApp.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student111 {
    @Id
    private Integer id;

    @Column(name = "Name")
    private String name;
    @Column(name = "Surname")
    private String surname;

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
