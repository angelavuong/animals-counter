package com.aliction.animalscounterspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
@RequestMapping("animals")
public class AnimalsResource {

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    MeterRegistry meterRegistry;


    @GetMapping("dogs/{name}")
    public String Dogs(@PathVariable(value = "name") String name){
        meterRegistry.counter("animals.dogs.count").increment();
        Animal dog = new Animal(name, "dog", 1);
        animalRepository.save(dog);
        return "Adding a new dog " + name;
    }

    @GetMapping("cats/{name}")
    public String Cats(@PathVariable(value = "name") String name){
        meterRegistry.counter("animals.cats.count").increment();
        Animal cat = new Animal(name, "cat", 1);
        animalRepository.save(cat);
        return "Adding a new cat " + name;
    }

    @GetMapping("horses/{name}")
    public String Horses(@PathVariable(value = "name") String name){
        meterRegistry.counter("animals.horses.count").increment();
        Animal horse = new Animal(name, "horse", 1);
        animalRepository.save(horse);
        return "Adding a new horse " + name;
    }

    
}
