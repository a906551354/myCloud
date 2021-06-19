package com.cloud;

import com.cloud.service.PaymentHystrixService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith( SpringRunner.class)
@SpringBootTest
public class Consumeropenfeign1 {

    @Autowired
    PaymentHystrixService paymentHystrixService;

    @Test
    public void test01(){
        ExecutorService pool = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 20000; i++){
            pool.execute(() -> {
                String s = paymentHystrixService.paymentInfo_TimeOut (20);
                System.out.println (s);
            });
        }

        pool.shutdown ();
        while (true){
            if(pool.isTerminated ()){
                break;
            }else{

            }
        }
    }
}
