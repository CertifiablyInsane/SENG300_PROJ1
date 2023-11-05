// Amira Wishah UCID: 30182579
package com.thelocalmarketplace.software.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.thelocalmarketplace.software.OrderManager;
import com.thelocalmarketplace.software.PaymentManager;

public class TestOrderManager_updateCostInPaymentManager {
	OrderManager tomInstance;
	PaymentManager pmInstance;
	
	
	//checks that the cost is updated accurately according the to item price
	@Test
	public void CheckCostIsUpdatedAccuratelyWhenPriceIs25() {
		float testItemCost = 25;
		tomInstance.updateCostInPaymentManager(testItemCost);
		
		float expected = testItemCost;
		float actual = pmInstance.amountDue ;
		
		assertEquals(expected, actual, 0);
	}
	
	public void CheckCostIsUpdatedAccuratelyWhenPriceZero() {
		float testItemCost = 0;
		tomInstance.updateCostInPaymentManager(testItemCost);
		
		float expected = testItemCost;
		float actual = pmInstance.amountDue;
		
		assertEquals(expected, actual, 0);
	}
	// Should this throw an exception? or is it valid for when doing a refund
	public void CheckCostIsUpdatedAccuratelyWhenPriceIsNegativeTwo() {
		float testItemCost = -2;
		
	}
}

/**public void updateCostInPaymentManager(float itemCost) {
paymentManager.amountDue += itemCost;
}
}**/