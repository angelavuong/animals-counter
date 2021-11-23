package com.aliction.animalscounterspringboot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Animal {

    public Animal(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String type;
    public int age;
    
}
