package com.mdemiguels.spring_data_persistance.controller;

import com.mdemiguels.spring_data_persistance.model.Account;
import com.mdemiguels.spring_data_persistance.model.TransferRequest;
import com.mdemiguels.spring_data_persistance.service.TransferService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest transferRequest) {
        transferService.transferMoney(
                transferRequest.getIdSender(),
                transferRequest.getIdReceiver(),
                transferRequest.getAmount());
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts(
            @RequestParam(required = false) String name
    ) {
        if (name == null) {
            return transferService.findAllAccounts();
        } else {
            return transferService.findAccountsByName(name);
        }
    }
}
