package com.shabo.shaboservice.service;

import com.shabo.shaboservice.entity.User;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.util.Date;

/**
 * Created by slgxmh on 16-9-25.
 * 项目中经常使用的功能
 */
@Service
public class ShaBoTools {
    /**
     * 计算字符串的md5
     *
     * @param str 需要计算的字符串
     * @return md5值
     */
    public String md5Encode(String str) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(md5.digest(str.getBytes()));
    }

    public String createToken(User user) throws Exception {
        String date = String.valueOf(new Date().getTime());//获得时间戳
        return md5Encode("Sha" + user.getUsername() + "Bo" + date);
    }
}
