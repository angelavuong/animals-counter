package com.aliction;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Animal extends PanacheEntity{

    public Animal(){
    }

    public Animal(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public String name;
    public String type;
    public int age;
}
