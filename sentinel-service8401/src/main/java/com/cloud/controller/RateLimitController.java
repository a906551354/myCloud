package com.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.entity.CommonResult;
import com.cloud.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        Payment payment = new Payment ();
        payment.setId (1111L);
        payment.setSerial ("11111");
        return new CommonResult (200, "按资源名称限流测试OK", payment);
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult (444, exception.getClass ().getCanonicalName () + "\t 服务不可用");
    }
}
