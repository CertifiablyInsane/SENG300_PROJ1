// André Beaulieu, UCID 30174544

package com.thelocalmarketplace.software.test;

import static org.junit.Assert.*;
import org.junit.*;
import com.thelocalmarketplace.software.*;

import ca.ucalgary.seng300.simulation.*;

import com.jjjwelectronics.scale.*;


// This class is dedicated to testing the constructor on WeightChecker
public class TestWeightChecker_constructor {
	
	private WeightChecker wcInstance;
	private ElectronicScale sampleScale;
	@Before
	public void setUp() {
		sampleScale = new ElectronicScale();
	}
	
	@Test (expected = NullPointerSimulationException.class)
	public void testWhenScaleIsNull() {
		wcInstance = new WeightChecker(null, 500f);
	}
	
	@Test (expected = InvalidArgumentSimulationException.class)
	public void testWhenLeniencyIsLessThanZero() {
		wcInstance = new WeightChecker(sampleScale, -1);
	}
	
	@Test
	public void testWhenScaleAndLeniencyAreValid() {
		wcInstance = new WeightChecker(sampleScale, 500f);
		// We expect the scale to register our weight checker as a listener
		assertTrue("The scale did not register the weight tester as a listener",
				sampleScale.listeners().contains(wcInstance));
	}
}
