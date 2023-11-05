// Jiaqi Wu 30172397
// This class tests the PaymentManager method addPayment

package com.thelocalmarketplace.software.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.*;

import com.tdc.coin.Coin;
import com.thelocalmarketplace.software.*;

import ca.ucalgary.seng300.simulation.InvalidArgumentSimulationException;
import ca.ucalgary.seng300.simulation.NullPointerSimulationException;

public class TestPaymentManager_addPayment {

	// Initialize local variables
	private PaymentManager testPayManager; // Initializes a new PaymentManager to be used for testing

	// Test when the coin is null
	@Test(expected = NullPointerSimulationException.class)
	public void testWhenCoinNull() {
		Coin nullCoin = new Coin(null);
		testPayManager.addPayment(nullCoin);

		throw new NullPointerSimulationException("No coin detected.");
	}

	// Test when the value of the coin is 0
	@Test(expected = InvalidArgumentSimulationException.class)
	public void testWhenCoinIsZero() {
		BigDecimal tempZero = BigDecimal.ZERO;
		Coin zeroCoin = new Coin(tempZero);
		testPayManager.addPayment(zeroCoin);
		throw new InvalidArgumentSimulationException("Coin value of zero is not allowed.");
	}

	// Test when the value of the coin is less than 0
	@Test(expected = InvalidArgumentSimulationException.class)
	public void testWhenCoinsIsLessThanZero() {
		BigDecimal testNegative = BigDecimal.valueOf(-1);
		Coin negativeCoin = new Coin(testNegative);
		testPayManager.addPayment(negativeCoin);
		throw new InvalidArgumentSimulationException("Negative coin value is not allowed.");
	}

}
