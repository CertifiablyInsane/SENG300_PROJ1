// Jiaqi Wu 30172397 + Amira Wishah 30182579 Payment Manager Class

package com.thelocalmarketplace.software;

import java.math.BigDecimal;

import com.tdc.coin.Coin;

// AB: Jiaqi and Amira, I created this class as the manager that will
// Divert different kinds of payment. Just needed to be able to reference
// a class. Thanks.
public class PaymentManager {
    public boolean enabled;

<<<<<<< HEAD
<<<<<<< HEAD
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
=======
	private float amountDueFloat = 0;
	private float amountPaid = 0;
=======
	public float amountDue = 0;
	public float amountPaid = 0;
	private PayWithCoin payWithCoin;
>>>>>>> refs/remotes/origin/main

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

<<<<<<< HEAD
	public float getValueDue() {
		return amountDueFloat - this.amountPaid;
	}

	public float getValuePaid() {
		return amountPaid;
	}

}
>>>>>>> refs/remotes/origin/main
=======
}
>>>>>>> refs/remotes/origin/main
