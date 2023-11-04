// André Beaulieu, UCID 30174544

package com.thelocalmarketplace.software.test;

import static org.junit.Assert.*;
import org.junit.*;
import com.thelocalmarketplace.software.*;

import ca.ucalgary.seng300.simulation.*;

import com.jjjwelectronics.Mass;
import com.jjjwelectronics.scale.*;

public class TestWeightChecker_onAttendantOverride {
	
	private WeightChecker wcInstance;
	private ElectronicScale sampleScale;
	@Before
	public void setUp() {
		sampleScale = new ElectronicScale();
		wcInstance = new WeightChecker(sampleScale, 500f);
		sampleScale.register(wcInstance);
	}
	@Test
	public void testAttendantOverride() {
		wcInstance.setStatus(ScaleStatus.BLOCKED);
		
		wcInstance.onAttendantOverride();
		// This always sets status to be normal
		assertTrue("The Weight Checker had its status changed unexpectedly",
				wcInstance.status() == ScaleStatus.NORMAL);
	}
}
