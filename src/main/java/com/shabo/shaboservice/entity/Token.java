package com.shabo.shaboservice.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by slgxmh on 06/07/2016.
 * token实体类
 */
@Entity
@Table(name = "user_token")
public class Token {
    @Id
    @GeneratedValue
    private long id;
    private String token;
    private String time;
    @OneToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private User user;

    public Token() {
        super();
    }

    public Token(User user) {
        time = String.valueOf(new Date().getTime());//获得时间戳
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public User getUserEntity() {
        return user;
    }

    public void setUserEntity(User user) {
        this.user = user;
    }
}
