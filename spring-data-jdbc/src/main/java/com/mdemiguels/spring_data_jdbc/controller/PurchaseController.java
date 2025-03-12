package com.mdemiguels.spring_data_jdbc.controller;

import com.mdemiguels.spring_data_jdbc.model.Purchase;
import com.mdemiguels.spring_data_jdbc.repository.PurchaseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @PostMapping
    public void storePurchase(@RequestBody Purchase purchase) {
        purchaseRepository.storePurchase(purchase);
    }

    @GetMapping
    public List<Purchase> findAllPurchases() {
        return purchaseRepository.findAll();
    }
}
