// Jiaqi Wu 30172397 + Amira Wishah 30182579 PayWithCoin class

package com.thelocalmarketplace.software;

import java.math.BigDecimal;

import com.tdc.coin.Coin;

import com.thelocalmarketplace.software.*;

//import com.jjjwelectronics.*;

public class PayWithCoin {
	private PaymentManager paymentManager;

	public PayWithCoin(PaymentManager newPM) {

		paymentManager = newPM;

	}

	public void insertCoin(Coin testCoin) {
		float coinTempValue = testCoin.getValue().floatValue();
		paymentManager.amountPaid += coinTempValue;
	}
}
