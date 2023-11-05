// Jiaqi Wu 30172397 + Amira Wishah 30182579 PayWithCoin class

package com.thelocalmarketplace.software;

import java.math.BigDecimal;

import com.tdc.coin.Coin;

import com.thelocalmarketplace.software.*;

//import com.jjjwelectronics.*;

public class PayWithCoin {
	private PaymentManager paymentManager;

	public PayWithCoin(PaymentManager newPM) {

		// the PayWithCoin creates a new instance of PaymentManager, from the one
		// specified in the constructor- JW
		paymentManager = newPM;

	}

	public void insertCoin(Coin testCoin) {
		// adds the value of the coin to the amount paid
		float coinTempValue = testCoin.getValue().floatValue();
		paymentManager.amountPaid += coinTempValue;
	}
}
