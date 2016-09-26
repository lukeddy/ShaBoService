package com.shabo.shaboservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by slgxmh on 26/06/2016.
 */
@Entity
@Table(name = "UserRoles")
public class UserRoles {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    public UserRoles() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
