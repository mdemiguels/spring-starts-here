package com.mdemiguels.spring_testing.service;

import com.mdemiguels.spring_testing.exceptions.AccountNotFoundException;
import com.mdemiguels.spring_testing.model.Account;
import com.mdemiguels.spring_testing.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TransferServiceUnitTest {

    @Mock
    private AccountRepository accountRepository;
    @InjectMocks
    private TransferService transferService;

    @Test
    public void moneyTransferHappyFlow() {

        Account senderAccount = new Account();
        senderAccount.setId(1);
        senderAccount.setAmount(new BigDecimal(1000));

        Account receiverAccount = new Account();
        receiverAccount.setId(2);
        receiverAccount.setAmount(new BigDecimal(1000));

        given(accountRepository.findById(senderAccount.getId()))
                .willReturn(Optional.of(senderAccount));

        given(accountRepository.findById(receiverAccount.getId()))
                .willReturn(Optional.of(receiverAccount));

        transferService.transferMoney(1, 2, new BigDecimal(100));

        verify(accountRepository)
                .changeAmount(1, new BigDecimal(900));

        verify(accountRepository)
                .changeAmount(2, new BigDecimal(1100));
    }

    @Test
    public void moneyTransferDestinationAccountNotFound() {

        Account senderAccount = new Account();
        senderAccount.setId(1);
        senderAccount.setAmount(new BigDecimal(1000));

        given(accountRepository.findById(1L))
                .willReturn(Optional.of(senderAccount));

        given(accountRepository.findById(2L))
                .willReturn(Optional.empty());

        assertThrows(AccountNotFoundException.class, () ->
                transferService.transferMoney(1, 2, new BigDecimal(100)));

        verify(accountRepository, never())
                .changeAmount(anyLong(), any());

    }
}
