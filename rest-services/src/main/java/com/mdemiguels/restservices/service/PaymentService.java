package com.mdemiguels.restservices.service;

import com.mdemiguels.restservices.exceptions.NotEnoughMoneyException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
