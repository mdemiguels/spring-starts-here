package com.mdemiguels.spring_testing.integration;

import com.mdemiguels.spring_testing.model.Account;
import com.mdemiguels.spring_testing.repository.AccountRepository;
import com.mdemiguels.spring_testing.service.TransferService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TransferServiceSpringIntegrationTest {

    @MockitoBean
    private AccountRepository accountRepository;
    @Autowired
    private TransferService transferService;

    @Test
    void transferServiceTransferAmountTest() {

        Account senderAccount = new Account();
        senderAccount.setId(1);
        senderAccount.setAmount(new BigDecimal(1000));

        Account receiverAccount = new Account();
        receiverAccount.setId(2);
        receiverAccount.setAmount(new BigDecimal(1000));

        when(accountRepository.findById(1L)).thenReturn(Optional.of(senderAccount));
        when(accountRepository.findById(2L)).thenReturn(Optional.of(receiverAccount));

        transferService.transferMoney(1, 2, new BigDecimal(100));

        verify(accountRepository).changeAmount(1, new BigDecimal(900));
        verify(accountRepository).changeAmount(2, new BigDecimal(1100));
    }
}
