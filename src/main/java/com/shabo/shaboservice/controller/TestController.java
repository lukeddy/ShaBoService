package com.shabo.shaboservice.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by slgxmh on 16-9-24.
 * 测试专用表现层
 */
@RestController
@RequestMapping("/test")
public class TestController {
    private Logger logger = Logger.getLogger(TestController.class);
}
