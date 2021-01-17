package com.mydigipay.paymentService.user.web.api;


import com.mydigipay.paymentService.base.service.MapperService;
import com.mydigipay.paymentService.user.model.DebtCard;
import com.mydigipay.paymentService.user.service.IDebtCardService;
import com.mydigipay.paymentService.user.web.validation.AddDebtCardValidationGroup;
import com.mydigipay.paymentService.user.web.validation.UpdateDebtCardValidationGroup;
import com.mydigipay.paymentService.user.web.viewModel.DebtCardVM;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user/debt-card")
@RequiredArgsConstructor
public class DebtCardController {

  private final IDebtCardService service;
  private final MapperService mapperService;

  @PostMapping
  public DebtCardVM create(@RequestBody @Validated(AddDebtCardValidationGroup.class) DebtCardVM debtCardVM) {
    DebtCard debtCard = mapperService.convert(debtCardVM, DebtCard.class);
    service.save(debtCard);
    return mapperService.convert(debtCard, DebtCardVM.class);
  }

  @PutMapping
  public DebtCardVM update(@RequestBody @Validated(UpdateDebtCardValidationGroup.class) DebtCardVM debtCardVM) {
    return mapperService.convert(service.update(debtCardVM), DebtCardVM.class);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Integer id) {
    service.delete(id);
  }

  @GetMapping("{userId}")
  public List<DebtCardVM> findAll(@PathVariable Integer userId) {
    return mapperService.convert(service.findAll(userId), DebtCardVM.class);
  }

}
