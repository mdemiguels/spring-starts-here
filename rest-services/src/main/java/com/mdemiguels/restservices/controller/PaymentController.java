package com.mdemiguels.restservices.controller;

import com.mdemiguels.restservices.exceptions.NotEnoughMoneyException;
import com.mdemiguels.restservices.service.ErrorDetails;
import com.mdemiguels.restservices.service.PaymentDetails;
import com.mdemiguels.restservices.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment() {

        PaymentDetails paymentDetails = paymentService.processPayment();
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);

    }
}
