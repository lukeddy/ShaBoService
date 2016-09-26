package com.shabo.shaboservice.dao;

import com.shabo.shaboservice.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by slgxmh on 06/07/2016.
 */
public interface TokenDao extends JpaRepository<Token, Long> {
    Token findByUserId(Long userID);

    Token findByToken(String token);
}
