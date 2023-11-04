// Jiaqi Wu 30172397

package com.thelocalmarketplace.software.test;

import static org.junit.Assert.*;

import java.math.*;

import org.junit.*;
import com.thelocalmarketplace.software.*;

import ca.ucalgary.seng300.simulation.*;

import com.jjjwelectronics.scale.*;

//package com.thelocalmarketplace.software.test;

// This class tests the payment manager class constructor.

public class TestPaymentManager_constructor {
	private PaymentManager testPayManager;
	private float ZERO_PAID = 0;

	@Test(expected = NullPointerSimulationException.class)
	public void testWhenCoinNull() {
		testPayManager = new PaymentManager(null, ZERO_PAID);
	}

	@Test(expected = InvalidArgumentSimulationException.class)
	public void testWhenLeniencyIsLessThanZero() {
		BigDecimal testNegative;
		
		testNegative = testNegative.negate();
		testPayManager = new PaymentManager(testNegative, ZERO_PAID);
	}
}
