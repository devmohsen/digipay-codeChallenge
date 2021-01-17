package com.mydigipay.paymentService.debtCardTransfer.web;


import com.mydigipay.paymentService.debtCardTransfer.dto.CardTransferResponse;
import com.mydigipay.paymentService.debtCardTransfer.service.IBankService;
import com.mydigipay.paymentService.debtCardTransfer.service.TransferService;
import com.mydigipay.paymentService.debtCardTransfer.util.BankServiceFactory;
import com.mydigipay.paymentService.debtCardTransfer.web.dto.CardTransferDTO;
import com.mydigipay.paymentService.user.model.DebtCard;
import com.mydigipay.paymentService.user.service.IDebtCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/debt-card-transfer")
@RequiredArgsConstructor
public class DebtCardTransferController {

    private final TransferService service;


    @PostMapping
    public Mono<ResponseEntity<Boolean>> transfer(@RequestBody @Valid CardTransferDTO dto) {

        return service.transfer(dto);
    }
}
