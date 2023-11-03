// André Beaulieu, UCID 30174544
package com.thelocalmarketplace.software;

import com.thelocalmarketplace.hardware.*;

public class SystemManager {
	// Reference for the hardware. 
	public SelfCheckoutStation hardware;
	
	// AB: All classes can access the hardware if they can access SystemManager
	// Alternatively, classes should have a hardware reference built into
	// their constructor. (For instance, WeightChecker does this)
	
	private OrderManager orderManager;
	private PaymentManager paymentManager;
	private WeightChecker weightChecker;
	
	
	public SystemManager(SelfCheckoutStation hardware) {
		this.hardware = hardware;
		orderManager = new OrderManager();
		paymentManager = new PaymentManager();
		weightChecker = new WeightChecker(this.hardware.baggingArea);
		// Normally, UI would cause this to happen. 
		// For now, it will be automatic
		startSession();
	}
	
	// Starts the session, and enabled all software components
	public void startSession() {
		orderManager.enabled = true;
		paymentManager.enabled = true;
		weightChecker.enabled = true;
	}
	
	// Currently Unused.
	public void endSession() {
		orderManager.enabled = false;
		paymentManager.enabled = false;
		weightChecker.enabled = false;
	}
	
	
}
