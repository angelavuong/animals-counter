package com.aliction;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.micrometer.core.instrument.MeterRegistry;

@Path("/animals")
public class AnimalsResource {

    private final MeterRegistry registry;

    AnimalsResource(MeterRegistry registry){
        this.registry = registry;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String animals() {
        return "Add animal name to your url path to count";
    }

    @GET
    @Path("dogs/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public String dog(@PathParam("name") String name) {
        this.registry.counter("animals.dogs.count").increment();
        Animal dog = new Animal(name, "dog", 1);
        dog.persist();
        return "Adding a new dog " + name;
    }

    @GET
    @Path("cats/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public String cat(@PathParam("name") String name) {
        this.registry.counter("animals.cats.count").increment();
        Animal cat = new Animal(name, "cat", 1);
        cat.persist();
        return "Adding a new cat " + name;
    }

    @GET
    @Path("horses/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public String horse(@PathParam("name") String name) {
        this.registry.counter("animals.horses.count").increment();
        Animal horse = new Animal(name, "horse", 1);
        horse.persist();
        return "Adding a new horse " + name;
    }
}