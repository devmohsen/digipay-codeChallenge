package com.mydigipay.notificationService.event;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class SmsRequest {
    private String target;
    private String msg;
}
