// Author: Camila Hernandez, UCID 30134911
package com.thelocalmarketplace.software.test;

import org.junit.*;
import static org.junit.Assert.*;

import com.jjjwelectronics.scale.ElectronicScale;
import com.thelocalmarketplace.software.OrderManager;
import com.thelocalmarketplace.software.PaymentManager;
import com.thelocalmarketplace.software.WeightChecker;

// This class is used to test the various functions of the OrderManager constructor:
public class TestOrderManager_constructor {

	// Reference to the weightChecker, providing access to WeightChecker.
	// Reference to the paymentManager, providing access to PaymentManager.
	// Reference to the orderManager, providing access to OrderManager.
	private WeightChecker weightChecker;
	private PaymentManager paymentManager;
	private OrderManager orderManager; 
	
	// Set up the test environment before each test method
	@Before
	public void setup() {
		ElectronicScale scaleToMonitor = new ElectronicScale();
		float LENIENCY = 0;
		weightChecker = new WeightChecker(scaleToMonitor, LENIENCY);
        paymentManager = new PaymentManager();
        orderManager = new OrderManager(weightChecker, paymentManager);
    }

	// Test method to verify that the software components are properly initialized in the constructor
	@Test
    public void testOrderManagerConstructor() {
        assertNotNull(orderManager);
        assertEquals(weightChecker, orderManager.weightChecker);
        assertEquals(paymentManager, orderManager.paymentManager);
        assertNotNull(orderManager.itemAdderBarcode);
    }
}
