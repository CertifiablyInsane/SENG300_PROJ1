// Jiaqi Wu 30172397

package com.thelocalmarketplace.software.test;

import static org.junit.Assert.*;

import java.math.*;

import org.junit.*;
import com.thelocalmarketplace.software.*;

import ca.ucalgary.seng300.simulation.*;

import com.jjjwelectronics.scale.*;

// This class tests the payment manager class constructor.

public class TestPaymentManager_constructor {
	// Initialize local variables
	private PaymentManager testPayManager; // Initializes a new PaymentManager to be used for testing
	private float ZERO_PAID = 0; // Constant value for when amount paid is 0
	private BigDecimal NO_COIN = BigDecimal.valueOf(0); // Constant value for when no coin is inserted

	// Test when the coin is null
	@Test(expected = NullPointerSimulationException.class)
	public void testWhenCoinNull() {
		testPayManager = new PaymentManager(null, ZERO_PAID);
		throw new NullPointerSimulationException("No coin detected.");
	}

	// Test when the value of the coin is 0
	@Test(expected = InvalidArgumentSimulationException.class)
	public void testWhenCoinIsZero() {
		testPayManager = new PaymentManager(NO_COIN, ZERO_PAID);
		throw new InvalidArgumentSimulationException("Coin value of zero is not allowed.");
	}

	// Test when the value of the coin is less than 0
	@Test(expected = InvalidArgumentSimulationException.class)
	public void testWhenCoinsIsLessThanZero() {
		BigDecimal testNegative = BigDecimal.valueOf(-1);
		testPayManager = new PaymentManager(testNegative, ZERO_PAID);
		throw new InvalidArgumentSimulationException("Negative coin value is not allowed.");
	}

	// Test when the initial amount paid is less than 0
	@Test(expected = InvalidArgumentSimulationException.class)
	public void testNegativeAmountPaid() {
		testPayManager = new PaymentManager(NO_COIN, -1);
		throw new InvalidArgumentSimulationException("Negative initial amount paid is not allowed.");
	}

	// Test when the amount paid is null
	@Test(expected = NullPointerSimulationException.class)
	public void testAmountPaidNull() {
		float nullFloat = (Float) null;
		testPayManager = new PaymentManager(NO_COIN, nullFloat);
		throw new NullPointerSimulationException("Null amount paid is not allowed.");
	}

	// Test when the coin and the amount paid is null
	@Test(expected = NullPointerSimulationException.class)
	public void testBothNull() {
		BigDecimal nullBD = null;
		float nullFloat = (Float) null;
		testPayManager = new PaymentManager(nullBD, nullFloat);
		throw new NullPointerSimulationException(
				"Null coin detected and Null amount paid dected. Both are not allowed.");
	}
}
