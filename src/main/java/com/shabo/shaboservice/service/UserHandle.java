package com.shabo.shaboservice.service;

import com.shabo.shaboservice.dao.TokenDao;
import com.shabo.shaboservice.dao.UserDao;
import com.shabo.shaboservice.entity.Token;
import com.shabo.shaboservice.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by slgxmh on 28/06/2016.
 * 用户注册，token获取之类的方法
 */
@Service
public class UserHandle {
    @Autowired
    private UserDao userDao;
    @Autowired
    private TokenDao tokenDao;

    @Autowired
    private ShaBoTools shaBoTools;
    private Logger logger = Logger.getLogger(UserHandle.class);

    public short singUp(String username, String password) {
        if (username == null || password == null || password.length() < 6) {
            logger.warn("用户注册信息校验失败");
            return 0;
        } else {
            try {
                User user = new User.Builder(username,
                        shaBoTools.md5Encode(username + "ShaBoYi" + password)).build();
                userDao.save(user);
                logger.info("用户注册，用户名：" + user.getUsername());
                Token token = new Token(user);
                token.setToken(shaBoTools.createToken(user));
                tokenDao.save(token);
                logger.info("分配token，用户名：" + user.getUsername());
                return 1;
            } catch (Exception e) {
                logger.error("注册过程中系统内部错误");
                e.printStackTrace();
                return -1;
            }
        }
    }

    public short singIn(String username, String password) {
        User user = userDao.findByUsername(username);
        if (username == null || password == null) {
            logger.warn("用户登陆信息校验失败");
            return -1;
        } else if (user == null) {
            return 0;
        } else {
            try {
                if (user.getPassword().equals(shaBoTools.md5Encode(username + "ShaBoYi" + password))) {
                    return 1;
                } else {
                    return 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }

        }
    }

    public String updateToken(String username) {
        try {
            User user = userDao.findByUsername(username);
            Token token = tokenDao.findByUserId(user.getId());
            token.setToken(shaBoTools.createToken(user));
            tokenDao.save(token);
            logger.info("升级token，用户名：" + user.getUsername());
            return token.getToken();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
