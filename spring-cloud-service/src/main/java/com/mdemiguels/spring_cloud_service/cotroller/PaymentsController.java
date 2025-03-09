package com.mdemiguels.spring_cloud_service.cotroller;

import com.mdemiguels.spring_cloud_service.model.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentsController {

    private static Logger logger = LoggerFactory.getLogger(PaymentsController.class);

    @PostMapping("/payment")
    public ResponseEntity<Payment> createPayment(
            @RequestHeader String requestId,
            @RequestBody Payment payment) {

        logger.info("Received request with id: {}", requestId);

        payment.setId(UUID.randomUUID().toString());

        return ResponseEntity
                .status(HttpStatus.OK)
                .header("requestId", requestId)
                .body(payment);
    }

}
