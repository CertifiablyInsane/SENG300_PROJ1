package com.thelocalmarketplace.software.test;

import org.junit.Before;

import com.thelocalmarketplace.hardware.SelfCheckoutStation;
import com.thelocalmarketplace.software.SystemManager;

public class TestSystemManager_constructor {

	// Reference to the hardware, providing access to SelfCheckoutStation.
	// Reference to the system manager, providing access to SystemManager.
	private SelfCheckoutStation hardware;
	private SystemManager systemManager;
		
	// Set up the test environment before each test method
	@Before
	public void setUp() {
		hardware = new SelfCheckoutStation();
		systemManager = new SystemManager(hardware); 
	}
}
