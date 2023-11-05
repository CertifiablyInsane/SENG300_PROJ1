// Author: Subeg Singh Chahal | UCID: 30196531
package com.thelocalmarketplace.software.test;

import org.junit.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import com.jjjwelectronics.scale.ElectronicScale;
import com.thelocalmarketplace.software.ItemAdderBarcode;
import com.thelocalmarketplace.software.OrderManager;
import com.thelocalmarketplace.software.PaymentManager;
import com.thelocalmarketplace.software.SystemManager;
import com.thelocalmarketplace.software.WeightChecker;

// This class is used to test the various functions of the OrderManager constructor:
public class TestOrderManager_constructor {

	private WeightChecker weightChecker;
	private PaymentManager paymentManager;
	private OrderManager orderManager; 
	
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
