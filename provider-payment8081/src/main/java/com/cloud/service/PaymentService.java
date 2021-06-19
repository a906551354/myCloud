package com.cloud.service;

import com.cloud.entity.Payment;
import com.cloud.mapper.PaymentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentService {
    @Resource
    private PaymentMapper paymentMapper;


    public int create(Payment payment) {
        return paymentMapper.create (payment);
    }


    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById (id);
    }
}
