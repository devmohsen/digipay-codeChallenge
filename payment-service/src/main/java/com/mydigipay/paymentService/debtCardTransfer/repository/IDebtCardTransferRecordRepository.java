package com.mydigipay.paymentService.debtCardTransfer.repository;


import com.mydigipay.paymentService.debtCardTransfer.model.DebtCardTransferRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDebtCardTransferRecordRepository extends JpaRepository<DebtCardTransferRecord,Long> {
}
