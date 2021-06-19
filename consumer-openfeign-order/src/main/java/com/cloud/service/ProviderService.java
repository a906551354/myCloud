package com.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cloud-provider-payment")
public interface ProviderService {

    @GetMapping(value = "/payment/zk")
    String getPaymentById(@PathVariable("id") Long id);
}
