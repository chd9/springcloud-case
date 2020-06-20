package com.chd9.client;

/**
 * @Author: donnie99
 * @Date: 2020/6/20 12:27
 * @Version 1.0
 */
import com.chd9.entity.ServiceInfo;
import com.common.entity.RestfulResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@Component
@FeignClient(value = "userServer", fallback=ServiceFallback.class) //这里的value对应调用服务的spring.applicatoin.name
public interface ServiceFeignClient {

    @RequestMapping(value = "/service/hello")
    RestfulResult hello(@RequestBody ServiceInfo serviceInfo);

}