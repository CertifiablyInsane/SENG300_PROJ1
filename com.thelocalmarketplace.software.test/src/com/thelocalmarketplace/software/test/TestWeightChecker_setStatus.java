// André Beaulieu, UCID 30174544

package com.thelocalmarketplace.software.test;

import static org.junit.Assert.*;
import org.junit.*;
import com.thelocalmarketplace.software.*;

import ca.ucalgary.seng300.simulation.*;

import com.jjjwelectronics.Mass;
import com.jjjwelectronics.scale.*;

public class TestWeightChecker_setStatus {
	
	private WeightChecker wcInstance;
	private ElectronicScale sampleScale;
	@Before
	public void setUp() {
		sampleScale = new ElectronicScale();
		wcInstance = new WeightChecker(sampleScale, 500f);
		sampleScale.register(wcInstance);
	}
	@Test (expected = InvalidArgumentSimulationException.class)
	public void testWhenStatusIsNull() {
		wcInstance.setStatus(null);
	}

	@Test
	public void testWhenStatusIsNotNull() {
		wcInstance.setStatus(ScaleStatus.NORMAL);
		wcInstance.setStatus(ScaleStatus.BLOCKED);
		
		assertTrue("The Weight Checker is not updating status correctly",
				wcInstance.status() == ScaleStatus.BLOCKED);
	}
}
