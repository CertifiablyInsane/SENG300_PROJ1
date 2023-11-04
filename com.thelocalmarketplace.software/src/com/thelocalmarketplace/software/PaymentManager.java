package com.thelocalmarketplace.software;

import java.math.BigDecimal;

import com.tdc.coin.Coin;

// AB: Jiaqi and Amira, I created this class as the manager that will
// Divert different kinds of payment. Just needed to be able to reference
// a class. Thanks.
public class PaymentManager {
    public boolean enabled;

    private float amountDueFloat;
    private float amountPaid;

    public PaymentManager(BigDecimal amountDue, float amountPaid) {
        System.out.println("PaymentManager has been created");
        amountDueFloat = amountDue.floatValue();
        this.amountPaid = amountPaid;
    }

    public float getValueDue() {
        return amountDueFloat;
    }

    public float getValuePaid() {
        return amountPaid;
    }
}