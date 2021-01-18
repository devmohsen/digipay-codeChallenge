package com.mydigipay.paymentService.feignClinet;

import com.mydigipay.paymentService.feignClinet.dto.SmsRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

@FeignClient(name = "notification-service" )
public interface NotificationServiceFeignClient {

    @PostMapping("/sms/send")
    Boolean sendSmd(@RequestBody SmsRequest request);
}
