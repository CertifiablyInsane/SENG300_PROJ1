// Jiaqi Wu 30172397 + Amira Wishah 30182579 Payment Manager Class

package com.thelocalmarketplace.software;

import java.math.BigDecimal;

import com.tdc.coin.Coin;

// AB: Jiaqi and Amira, I created this class as the manager that will
// Divert different kinds of payment. Just needed to be able to reference
// a class. Thanks.
public class PaymentManager {
	public boolean enabled;

	private float amountDueFloat = 0;
	private float amountPaid = 0;

	public PaymentManager(BigDecimal amountDueParam, float amountPaidParam) {
		System.out.println("PaymentManager has been created");
		amountDueFloat = amountDueParam.floatValue() + this.amountDueFloat;
		this.amountPaid = amountPaidParam + this.amountPaid;
		if (enabled == false)
		{
			amountDueFloat = 0;
			amountPaid = 0;
		}
	}

	public float getValueDue() {
		return amountDueFloat - this.amountPaid;
	}

	public float getValuePaid() {
		return amountPaid;
	}

}
