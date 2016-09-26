package com.shabo.shaboservice.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by slgxmh on 26/06/2016.
 */
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"})
})
public class User {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String password;
    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private List<UserRoles> roles;


    //建造器实现
    public static class Builder {
        private String username;
        private String password;
        private List<UserRoles> roles;

        private long ID = 0;

        public Builder(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public Builder Id(long val) {
            ID = val;
            return this;
        }

        public Builder roles(List<UserRoles> vals) {
            roles = vals;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public User() {
        super();
    }

    private User(Builder builder) {
        id = builder.ID;
        username = builder.username;
        password = builder.password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
