package com.shabo.shaboservice.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by slgxmh on 16-9-25.
 * 标准返回信息类
 */
public class StMessage {
    private int state;//返回状态码
    private long time;//时间戳
    private Map message;//信息内容

    public StMessage(int state) {
        this.state = state;
        this.time = new Date().getTime();
    }

    public void addMessage(String key, Object value) {
        if (message == null) {
            message = new HashMap<String, Object>();
        }
        message.put(key, value);
    }

    public void deleteMessage(String key) {
        message.remove(key);
    }

    public int getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public long getTime() {
        return time;
    }

    public Map getMessage() {
        return message;
    }

    public void setMessage(Map message) {
        this.message = message;
    }
}
