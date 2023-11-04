// Author: Camila Hernandez, UCID 30134911

package com.thelocalmarketplace.software.test;

import com.thelocalmarketplace.hardware.SelfCheckoutStation;
import com.thelocalmarketplace.software.SystemManager;

import static org.junit.Assert.*;
import org.junit.*;

public class TestSystemManager_startSession {
	
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
	
	// Test method to verify starting a session enables software components
	@Test
	public void testStartSession() {
		systemManager.startSession();
		assertTrue(systemManager.orderManager.enabled);
        assertTrue(systemManager.paymentManager.enabled);
        assertTrue(systemManager.weightChecker.enabled);
	}
	
	// Test method to verify that when starting a session multiple times, the software components are still enabled
	@Test
	public void testStartSessionMultipleTimes() {
		systemManager.startSession();
		systemManager.startSession();
		assertTrue(systemManager.orderManager.enabled);
        assertTrue(systemManager.paymentManager.enabled);
        assertTrue(systemManager.weightChecker.enabled);
	}
}
