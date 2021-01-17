package com.mydigipay.paymentService.debtCardTransfer.service.impl;

import com.mydigipay.paymentService.debtCardTransfer.model.DebtCardTransferRecord;
import com.mydigipay.paymentService.debtCardTransfer.service.IBankService;
import com.mydigipay.paymentService.debtCardTransfer.service.IDebtCardTransferRecordService;
import com.mydigipay.paymentService.debtCardTransfer.service.TransferService;
import com.mydigipay.paymentService.debtCardTransfer.util.BankServiceFactory;
import com.mydigipay.paymentService.debtCardTransfer.web.dto.CardTransferDTO;
import com.mydigipay.paymentService.user.model.DebtCard;
import com.mydigipay.paymentService.user.service.IDebtCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {

    private final BankServiceFactory transferServiceFactory;
    private final IDebtCardService debtCardService;
    private final IDebtCardTransferRecordService transferRecordService;

    @Override
    public Mono<ResponseEntity<Boolean>> transfer(CardTransferDTO dto) {
        Optional<DebtCard> optionalDebtCard = debtCardService.find(dto.getCardId());
        String firstFourNum = dto.getDestination().substring(0, 4);
        IBankService bankService = transferServiceFactory.getProvider(firstFourNum);
        // not found on .get method handles in implementation of IDebtCardService
        return bankService.transfer(dto, optionalDebtCard.get())
                .flatMap(cardTransferResponse -> {

                    transferRecordService.save(new DebtCardTransferRecord(optionalDebtCard.get(),
                            dto.getDestination(), dto.getAmount(), cardTransferResponse.isSuccess()));

                    if (cardTransferResponse.isSuccess()) {

                        return Mono.just(new ResponseEntity<>(true, HttpStatus.OK));
                    } else return Mono.just(new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR));

                });
    }
}
