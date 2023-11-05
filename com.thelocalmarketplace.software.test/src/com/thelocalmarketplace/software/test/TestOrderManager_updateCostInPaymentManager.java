// Amira Wishah UCID: 30182579
package com.thelocalmarketplace.software.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.thelocalmarketplace.software.OrderManager;
import com.thelocalmarketplace.software.PaymentManager;

import ca.ucalgary.seng300.simulation.InvalidArgumentSimulationException;
import ca.ucalgary.seng300.simulation.NullPointerSimulationException;

public class TestOrderManager_updateCostInPaymentManager {
	OrderManager tomInstance;
	PaymentManager pmInstance;
	
	
	//checks that the cost is updated accurately according the to item price
	@Test
	public void checkCostIsUpdatedAccuratelyWhenPriceIs25() {
		float testItemCost = 25;
		tomInstance.updateCostInPaymentManager(testItemCost);
		
		float expected = testItemCost;
		float actual = pmInstance.amountDue ;
		
		assertEquals(expected, actual, 0);
	}
	
	// checks that cost is updated properly when adding on to a positive non-zero amount due
	@Test
	public void checkCostIsUpdatedAccuratelyWhenPriceIs25AndAmountDueIsAlready5() {
		float testItemCost = 25;
		
		pmInstance.amountDue = 5;
		tomInstance.updateCostInPaymentManager(testItemCost);
		
		float expected = testItemCost;
		float actual = pmInstance.amountDue ;
		
		assertEquals(expected, actual, 0);
	}
	
	// checks that cost is updated accurately when price of item is zero
	public void checkCostIsUpdatedAccuratelyWhenPriceZero() {
		float testItemCost = 0;
		tomInstance.updateCostInPaymentManager(testItemCost);
		
		float expected = testItemCost;
		float actual = pmInstance.amountDue;
		
		assertEquals(expected, actual, 0);
	}
	
	// Checks for an invalid, negative item cost
	@Test (expected =  InvalidArgumentSimulationException.class)
	public void checkCostIsUpdatedAccuratelyWhenPriceIsNegativeTwo() {
		float testItemCost = -2;
		tomInstance.updateCostInPaymentManager(testItemCost);
		throw new InvalidArgumentSimulationException("negative value item is not allowed.");
	}	
	
}