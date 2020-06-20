package com.chd9.controller;

/**
 * @Author: donnie99
 * @Date: 2020/6/17 23:14
 * @Version 1.0
 */

import com.chd9.client.ServiceFeignClient;
import com.chd9.entity.ServiceInfo;
import com.common.utils.CommUtils;
import com.common.entity.RestfulResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController // 重要，如果用Controller会404
public class ServiceController {
    @Autowired
    ServiceFeignClient serviceFeignClient;
    // 调用：localhost:6004/consumerService?token=1
    @RequestMapping("/consumerService")
    public void consumerService(HttpServletRequest request, HttpServletResponse response,
                                @RequestBody ServiceInfo serviceInfo){

        RestfulResult restfulResult =  serviceFeignClient.hello(serviceInfo);

        CommUtils.printDataJason(response, restfulResult);
    }
}
/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
