package com.mdemiguels.spring_data_persistance.model;

import java.math.BigDecimal;

public class TransferRequest {

    private long idSender;
    private long idReceiver;
    private BigDecimal amount;

    public long getIdSender() {
        return idSender;
    }

    public void setIdSender(long idSender) {
        this.idSender = idSender;
    }

    public long getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(long idReceiver) {
        this.idReceiver = idReceiver;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
