package com.mydigipay.notificationService.controller;

import com.mydigipay.notificationService.event.SmsEventProducer;
import com.mydigipay.notificationService.event.SmsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("sms")
@RequiredArgsConstructor
public class SmsController {

    private final SmsEventProducer smsEventProducer;

    @PostMapping("send")
    public Boolean sendSmd(@RequestBody SmsRequest request) {
        smsEventProducer.sendMessage(request);
        int randomNum =(int) (Math.random() * 3);
        return randomNum != 0;
    }
}
