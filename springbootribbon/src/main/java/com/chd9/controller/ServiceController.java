package com.chd9.controller;

/**
 * @Author: donnie99
 * @Date: 2020/6/17 23:14
 * @Version 1.0
 */

import com.chd9.entity.ServiceInfo;
import com.common.entity.RestfulResult;
import com.common.utils.CommUtils;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController // 重要，如果用Controller会404
public class ServiceController {
    @Autowired
    RestTemplate restTemplate;

    @Value("${server.port}")
    String port;
    // 调用：localhost:6007/consumerServiceRibbon?token=1
    @RequestMapping("/ribbonServer")
    @HystrixCommand(fallbackMethod="ribbonServerFallback")
    public String ribbonServer(@RequestBody ServiceInfo serviceInfo){
        String result = this.restTemplate.postForObject("http://userServer/service/hello?token=1", serviceInfo, String.class);
        return result;
    }

    public String ribbonServerFallback(@RequestBody ServiceInfo serviceInfo) {
        return "ribbonServer，端口：" + port + "，Name=" + serviceInfo.getName();
    }
}
/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
