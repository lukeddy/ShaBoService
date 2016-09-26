package com.shabo.shaboservice.dao;

import com.shabo.shaboservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by slgxmh on 26/06/2016.
 */
public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
