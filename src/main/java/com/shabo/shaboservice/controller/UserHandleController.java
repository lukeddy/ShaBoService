package com.shabo.shaboservice.controller;

import com.shabo.shaboservice.entity.StMessage;
import com.shabo.shaboservice.service.UserHandle;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by slgxmh on 16-9-25.
 * 用户登陆注册相关api
 */
@RestController
@RequestMapping("/userhandle")
public class UserHandleController {
    private Logger logger = Logger.getLogger(UserHandleController.class);

    @Autowired
    private UserHandle userHandle;

    @ApiOperation(value = "注册", notes = "密码长度大于5")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
    })
    @RequestMapping(value = "/singup", method = RequestMethod.POST)
    public StMessage singUp(String username, String password) {
        short i = userHandle.singUp(username, password);
        if (i == 1) {
            logger.info("新用户注册：" + username);
            return new StMessage(1);
        } else if (i == 0) {
            logger.warn("注册数据校验失败，用户名：" + username + " " + "密码：" + password);
            return new StMessage(0);
        } else {
            logger.error("注册过程内部错误");
            return new StMessage(-1);
        }
    }

    @ApiOperation(value = "登录",notes = "会返回token，作为以后操作的凭证")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
    })
    @RequestMapping(value = "/singin", method = RequestMethod.POST)
    public StMessage singIn(String username, String password) {
        short st = userHandle.singIn(username, password);
        if (st == 1) {
            logger.info("登陆成功，用户:" + username);
            StMessage stMessage = new StMessage(1);
            stMessage.addMessage("token", userHandle.updateToken(username));
            return stMessage;
        } else {
            logger.warn("登陆失败，用户：" + username);
            return new StMessage(0);
        }
    }
}
