package com.mdemiguels.spring_cloud_client.controller;

import com.mdemiguels.spring_cloud_client.model.Payment;
import com.mdemiguels.spring_cloud_client.proxy.PaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentsController {

    private final PaymentsProxy paymentsProxy;

    public PaymentsController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment) {

        String requestId = UUID.randomUUID().toString();
        return paymentsProxy.createPayment(requestId, payment);

    }
}
