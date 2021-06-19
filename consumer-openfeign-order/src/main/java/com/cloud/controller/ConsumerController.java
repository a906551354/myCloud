package com.cloud.controller;

import com.cloud.entity.CommonResult;
import com.cloud.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private ProviderService providerService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        System.out.println (id);
        String paymentById = providerService.getPaymentById (id);
        return new CommonResult<> (200, paymentById);
    }
}