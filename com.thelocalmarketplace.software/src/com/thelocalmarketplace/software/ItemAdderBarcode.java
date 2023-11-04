// Author: Subeg Singh Chahal | UCID: 30196531
package com.thelocalmarketplace.software;

import com.jjjwelectronics.Mass;
import com.jjjwelectronics.scanner.BarcodedItem;

public class ItemAdderBarcode 
{
	private OrderManager orderManager;
	
	public ItemAdderBarcode(OrderManager orderManager) 
	{
		this.orderManager = orderManager;
	}
	
	public void addBarcodedItem(BarcodedItem barcodedItem)
	{
		// TODO: Payments still need to be setup
		Mass itemMass = barcodedItem.getMass();
		
		orderManager.expectedMass = orderManager.expectedMass.sum(itemMass);
	}
}
