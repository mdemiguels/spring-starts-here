package com.mdemiguels.spring_testing.controller;

import com.mdemiguels.spring_testing.model.Account;
import com.mdemiguels.spring_testing.model.TransferRequest;
import com.mdemiguels.spring_testing.service.TransferService;
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
