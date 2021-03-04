package com.sanjai.spacemanagement.models;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Instance {
    @Id
    private int id;
    private String name;
    @Value("${some.key:false}")
    private boolean state;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
