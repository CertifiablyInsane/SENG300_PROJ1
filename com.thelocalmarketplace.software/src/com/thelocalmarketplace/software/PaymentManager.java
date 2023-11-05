// Jiaqi Wu 30172397 + Amira Wishah 30182579 Payment Manager Class

package com.thelocalmarketplace.software;

import com.tdc.coin.Coin;

// AB: Jiaqi and Amira, I created this class as the manager that will
// Divert different kinds of payment. Just needed to be able to reference
// a class. Thanks.
public class PaymentManager {
    public boolean enabled;

	public float amountDue = 0;
	public float amountPaid = 0;
	private PayWithCoin payWithCoin;


	public PaymentManager() {
		System.out.println("Payment Manager has been created");
		payWithCoin = new PayWithCoin(this);
	}

	public void addPayment(Coin newCoin) {
		payWithCoin.insertCoin(newCoin);
		if (amountPaid >= amountDue) {
			// implement print receipt here
		}
	}

}

