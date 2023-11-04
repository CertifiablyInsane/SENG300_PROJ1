// Project Iteration 1 Jiaqi Wu 30172397, Amira Wishah 30182579
// SENG 300 Group 9
// Transcribe the use case model into a java software class using the hardware from the given file in d2l description.

//Package declaration
package com.thelocalmarketplace.software;

//Global Imports
import java.math.BigDecimal;

import com.tdc.coin.Coin;

import com.thelocalmarketplace.software.PaymentManager;
//Initialize private variables
public class PayWithCoin {
    private BigDecimal totalDue;
    private float totalPaid;

    public PayWithCoin(BigDecimal totalDue) {
        this.totalDue = totalDue;
        this.totalPaid = 0;
    }

    // Insert coin class
    public void insertCoin(Coin testCoin) {
        // float coinTempValue = testCoin.getValue().floatValue(); // temporary value to
        // convert from BigDecimal to a float
        totalPaid = totalPaid +0;
        System.out.println("Inserted " + testCoin.toString() + ". Total paid: " + totalPaid + " cents."); // printing
                                                                                                            // from
                                                                                                            // hardware
                                                                                                            // toString()
    }
// Payment complete boolean class
    public boolean isPaymentComplete() {
        float totalDueTemp = totalDue.floatValue();
        if (totalPaid > totalDueTemp) {
            dispenseChange();
        }
        return totalPaid >= totalDueTemp;

    }

    // Get the remaining amount due
    public float getAmountDue() {
        float totalDueTemp = totalDue.floatValue();
        if ((totalDueTemp - totalPaid) < 0) {
            dispenseChange();
        }
        return totalDueTemp - totalPaid;

    }

    public float dispenseChange() {
        float totalDueTemp = totalDue.floatValue();
        float changeDue = totalPaid - totalDueTemp;

        return changeDue;
    }
=======
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
>>>>>>> refs/remotes/origin/main
}
