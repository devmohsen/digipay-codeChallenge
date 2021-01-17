package com.mydigipay.paymentService.debtCardTransfer.service;

import com.mydigipay.paymentService.debtCardTransfer.web.dto.CardTransferDTO;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface TransferService {
    Mono<ResponseEntity<Boolean>> transfer(CardTransferDTO dto);
}
