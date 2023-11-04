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
	
	// Test method to verify that the hardware is not null
	@Test
	public void testConstructorWithValidHardware() {
		systemManager = new SystemManager(hardware); 
		assertNotNull(systemManager);
	}
	
	// Test method to verify that the NullPointerSimulationException is thrown when hardware is null
	@Test (expected = NullPointerSimulationException.class)
	public void testConstructorWithNullHardware() {
		hardware = null;
		systemManager = new SystemManager(hardware);
	}
	
	// Test method to verify that the hardware is properly initialized when hardware is not null
	@Test
	public void testHardwareInitialization() {
		systemManager = new SystemManager(hardware); 
		assertEquals(hardware, systemManager.hardware);
	}
	
	// Test method to verify that the OrderManager is properly initialized when hardware is not null
	@Test
	public void testOrderManagerInitialization() {
		systemManager = new SystemManager(hardware);
		assertNotNull(systemManager.orderManager);
	}
	
	// Test method to verify that the PaymentManager is properly initialized when hardware is not null
	@Test
	public void testPaymentManagerInitialization() {
		systemManager = new SystemManager(hardware);
		assertNotNull(systemManager.paymentManager);
	}
	
	// Test method to verify that the WeightChecker is properly initialized when hardware is not null
	@Test
	public void testWeightCheckerInitialization() {
		systemManager = new SystemManager(hardware);
		assertNotNull(systemManager.weightChecker);
	}
	
}
