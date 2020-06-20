package com.chd9.client;

/**
 * @Author: donnie99
 * @Date: 2020/6/20 12:38
 * @Version 1.0
 */
import com.chd9.entity.ServiceInfo;
import com.common.entity.RestfulResult;
import org.springframework.stereotype.Component;
@Component
public class ServiceFallback implements ServiceFeignClient{

    @Override
    public RestfulResult hello(ServiceInfo serviceInfo) {
        RestfulResult result = new RestfulResult();
        result.setData("服务调用失败");
        return result;
    }
}