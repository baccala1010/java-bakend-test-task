package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.antlr.v4.runtime.misc.NotNull;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Sensor() {

    }

    public @Size(min = 3, max = 50) String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Sensor(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @NotNull
    @Size(min = 3, max = 50)
    @Column(unique = true)
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(@Size(min = 3, max = 50) String name) {
        this.name = name;
    }
}
