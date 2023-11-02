package com.thelocalmarketplace.software;

import com.thelocalmarketplace.hardware.*;

// AB: Subeg, I created this class as the manager that will divert the
// added item to whichever type of item is added. No functionality yet,
// I just needed to be able to reference it.
public class OrderManager {
	public boolean enabled;

	public OrderManager() {
		System.out.println("OrderManager has been created");
	}
	
	public void addItem(Product item) {
		// AB: So here check if Product is of type BarcodedProduct, etc.
	}
	public void removeItem(Product item) {
		// Not yet implemented
		throw new UnsupportedOperationException();
	}
}
