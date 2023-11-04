// Author: Camila Hernandez, UCID 30134911
//
//
package com.thelocalmarketplace.software.test;

import static org.junit.Assert.*;
import org.junit.*;

import com.thelocalmarketplace.hardware.SelfCheckoutStation;
import com.thelocalmarketplace.software.SystemManager;

import ca.ucalgary.seng300.simulation.NullPointerSimulationException;

public class TestSystemManager_constructor {

	// Reference to the hardware, providing access to SelfCheckoutStation.
	// Reference to the system manager, providing access to SystemManager.
	private SelfCheckoutStation hardware;
	private SystemManager systemManager;
		
	// Set up the test environment before each test method
	@Before
	public void setUp() {
		hardware = new SelfCheckoutStation();
	}
	
	@Test
	public void testConstructorWithValidHardware() {
		systemManager = new SystemManager(hardware); 
		assertNotNull(systemManager);
	}
	
	@Test (expected = NullPointerSimulationException.class)
	public void testConstructorWithNullHardware() {
		hardware = null;
		systemManager = new SystemManager(hardware);
	}
	
	@Test
	public void testOrderManagerInitialization() {
		systemManager = new SystemManager(hardware);
		assertNotNull(systemManager.orderManager);
	}
	
	@Test
	public void testPaymentManagerInitialization() {
		systemManager = new SystemManager(hardware);
		assertNotNull(systemManager.paymentManager);
	}
	
	@Test
	public void testWeightCheckerInitialization() {
		systemManager = new SystemManager(hardware);
		assertNotNull(systemManager.weightChecker);
	}
	
}
