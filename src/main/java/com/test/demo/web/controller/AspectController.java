package com.test.demo.web.controller;

import com.test.demo.web.service.AspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Describe:
 * @Author: yangqingfang
 * @Date: 2022/5/6 11:55
 */
@RestController
@RequestMapping("/yang")
public class AspectController {

    @Autowired
    private AspectService aspectService;

    @RequestMapping(value = "/aspectTest")
    public void aspectTest(){
        aspectService.aspectTest();
    }

}
