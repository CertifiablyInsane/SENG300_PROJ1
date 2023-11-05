// Author: Camila Hernandez, UCID 30134911
package com.thelocalmarketplace.software.test;
import org.junit.*;

import com.thelocalmarketplace.software.OrderManager;

import static org.junit.Assert.*;

public class TestOrderManager_itemPlacedInBaggingArea {

	private OrderManager orderManager; 
	
	// Test method to verify that the itemPlacedInBaggingArea method sets the readyForNewItem 
	// flag to true when it is initially false and an item is placed in the bagging area
	@Test
    public void testItemPlacedInBaggingArea() {
        orderManager.readyForNewItem = false;
        orderManager.itemPlacedInBaggingArea();
        // Verify that itemPlacedInBaggingArea sets readyForNewItem to true
        assertTrue(orderManager.readyForNewItem);
    }
}
