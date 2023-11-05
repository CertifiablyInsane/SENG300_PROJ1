// Authors: André Beaulieu, UCID 30174544 &	Camila Hernandez, UCID 30134911
package com.thelocalmarketplace.software;

import com.thelocalmarketplace.hardware.*;

import ca.ucalgary.seng300.simulation.NullPointerSimulationException;

public class SystemManager {
	// Reference to the hardware, providing access to the SelfCheckoutStation. 
	public SelfCheckoutStation hardware;
	
	// AB: All classes can access the hardware if they can access SystemManager
	// Alternatively, classes should have a hardware reference built into
	// their constructor. (For instance, WeightChecker does this)
	
	public OrderManager orderManager;
	public PaymentManager paymentManager;
	public WeightChecker weightChecker;
	
	// Constructor for the SystemManager, initializes hardware and software components.
	public SystemManager(SelfCheckoutStation hardware) {
		if (hardware == null) {
			throw new NullPointerSimulationException("The hardware is not properly initialized.");
		}
		this.hardware = hardware;
		paymentManager = new PaymentManager();
		weightChecker = new WeightChecker(this.hardware.baggingArea, 500f);
		orderManager = new OrderManager(weightChecker, paymentManager);
		// Further initialization if needed
		weightChecker.setOrderManager(orderManager);
		// Normally, user interface would trigger this process. 
		// However, in this project iteration, it is set to occur automatically.
		startSession();
	}
	
	// Starts a shopping session, enabling all software components.
	public void startSession() {
		orderManager.enabled = true;
		paymentManager.enabled = true;
		weightChecker.enabled = true;
	}
	
	// Ends the shopping session, disabling all software components.
	// This is currently being unused in this project iteration.
	public void endSession() {
		orderManager.enabled = false;
		paymentManager.enabled = false;
		weightChecker.enabled = false;
	}
	
	
}
