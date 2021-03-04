package com.sanjai.spacemanagement.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
public class InstanceDetails {
    @Id
    public int id;
    public String instance_id;
    public String purpose;
    public String user;
    public LocalDateTime time;

    public InstanceDetails(int id,String instance_id ,String purpose, String user) {
        this.id = id;
        this.instance_id=instance_id;
        this.purpose = purpose;
        this.user = user;
        this.time = java.time.LocalDateTime.now().withNano(0).withSecond(0) ;
    }

    public InstanceDetails() {

    }



    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsers() {
        return user;
    }

    public void setUsers(String users) {
        this.user = users;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
