// Jiaqi Wu 30172397 + Amira Wishah 30182579 PayWithCoin class

package com.thelocalmarketplace.software;

import java.math.BigDecimal;

import com.tdc.coin.Coin;

import com.thelocalmarketplace.software.*;

//import com.jjjwelectronics.*;

public class PayWithCoin {
	private BigDecimal totalDue;
	private float totalPaid;
	private float totalDueFloat;

	public PayWithCoin(BigDecimal totalDue) {
		PaymentManager newCoinSession = new PaymentManager(totalDue, 0);
		totalPaid = newCoinSession.getValuePaid();
		totalDueFloat = newCoinSession.getValueDue();
	}

	public void insertCoin(Coin testCoin) {
		float coinTempValue = testCoin.getValue().floatValue();
		totalPaid = totalPaid + coinTempValue;
		System.out.println("Inserted " + testCoin.toString() + ". Total paid: " + totalPaid + " cents.");
	}

	public boolean isPaymentComplete() {
		return totalPaid >= totalDueFloat;
	}

	// Get the remaining amount due
	public float getAmountDue() {
		return totalDueFloat - totalPaid;
	}

	public float dispenseChange() {
		return totalPaid - totalDueFloat;
	}
}
