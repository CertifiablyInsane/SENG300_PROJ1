package com.thelocalmarketplace.software.test;

import com.thelocalmarketplace.hardware.SelfCheckoutStation;
import com.thelocalmarketplace.software.SystemManager;
import org.junit.*;

public class SystemManagerTest {
	
	private SelfCheckoutStation hardware;
	private SystemManager systemManager;
	
	@Before
	public void setUp() {
		hardware = new SelfCheckoutStation();
		systemManager = new SystemManager(hardware); 
	}
}
