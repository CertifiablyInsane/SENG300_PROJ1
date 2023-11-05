// Amira Wishah UCID: 30182579
package com.thelocalmarketplace.software.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.thelocalmarketplace.software.OrderManager;
import com.thelocalmarketplace.software.PaymentManager;

import ca.ucalgary.seng300.simulation.InvalidArgumentSimulationException;

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
	
	public void checkCostIsUpdatedAccuratelyWhenPriceZero() {
		float testItemCost = 0;
		tomInstance.updateCostInPaymentManager(testItemCost);
		
		float expected = testItemCost;
		float actual = pmInstance.amountDue;
		
		assertEquals(expected, actual, 0);
	}
	
	@Test (expected =  InvalidArgumentSimulationException.class)
	public void checkCostIsUpdatedAccuratelyWhenPriceIsNegativeTwo() {
		float testItemCost = -2;
		tomInstance.updateCostInPaymentManager(testItemCost);
		throw new InvalidArgumentSimulationException("negative value item is not allowed.");
	}
	
	@Test
	public void checkForNullItem(){
		
	}
	
}

/**public void updateCostInPaymentManager(float itemCost) {
paymentManager.amountDue += itemCost;
}
}**/