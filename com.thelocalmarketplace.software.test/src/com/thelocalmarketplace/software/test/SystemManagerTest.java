package com.thelocalmarketplace.software.test;

import com.thelocalmarketplace.hardware.SelfCheckoutStation;
import com.thelocalmarketplace.software.SystemManager;

import static org.junit.Assert.*;
import org.junit.*;

public class SystemManagerTest {
	
	private SelfCheckoutStation hardware;
	private SystemManager systemManager;
	
	@Before
	public void setUp() {
		hardware = new SelfCheckoutStation();
		systemManager = new SystemManager(hardware); 
	}
	
	@Test
	public void testStartSession() {
		systemManager.startSession();
		assertTrue(systemManager.orderManager.enabled);
        assertTrue(systemManager.paymentManager.enabled);
        assertTrue(systemManager.weightChecker.enabled);
	}
	
}
