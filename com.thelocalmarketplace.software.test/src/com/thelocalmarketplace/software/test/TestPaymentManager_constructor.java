// Jiaqi Wu 30172397
// Test for PaymentManager

// Since PaymentManager has no parameters in the construction, there is only one test case.

package com.thelocalmarketplace.software.test;

import static org.junit.Assert.*;

import java.math.*;

import org.junit.*;
import com.thelocalmarketplace.software.*;

import ca.ucalgary.seng300.simulation.*;

import com.jjjwelectronics.scale.*;

// This class tests the payment manager class constructor.

public class TestPaymentManager_constructor {

	// Test for initialize manager
	@Test(expected = InvalidArgumentSimulationException.class)
	public void testWhenPaymentIsInitialized() {
		PaymentManager testPayManager = new PaymentManager();
		System.out.println("Payment manager is initialized.");
	}

}
