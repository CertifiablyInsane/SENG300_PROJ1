// André Beaulieu, UCID 30174544
package com.thelocalmarketplace.software;

public class SystemManager {
	private OrderManager orderManager;
	private PaymentManager paymentManager;
	
	public void initialize() {
		orderManager = new OrderManager();
		paymentManager = new PaymentManager();
		
		// Normally, UI would cause this to happen. 
		// For now, it will be automatic
		startSession();
	}
	
	// Starts the session.
	public void startSession() {
		orderManager.enabled = true;
		paymentManager.enabled = true;
	}
	
	// Currently Unused.
	public void endSession() {
		orderManager.enabled = false;
		paymentManager.enabled = false;
	}
	
	
}
