// André Beaulieu, UCID 30174544

package com.thelocalmarketplace.software.test;

import static org.junit.Assert.*;
import org.junit.*;
import com.thelocalmarketplace.software.*;

import ca.ucalgary.seng300.simulation.*;

import com.jjjwelectronics.Mass;
import com.jjjwelectronics.scale.*;

public class TestWeightChecker_theMassOnTheScaleHasChanged {
	
	private WeightChecker wcInstance;
	private ElectronicScale sampleScale;
	@Before
	public void setUp() {
		sampleScale = new ElectronicScale();
		wcInstance = new WeightChecker(sampleScale, 500f);
		sampleScale.register(wcInstance);
	}
	
	// TODO: Make order manager's expected weight == 3000.
	// For now, new Mass(3000) is hard-coded into WeightChecker
	@Test
	public void testWhenNotEnabled() {
		wcInstance.enabled = false;
		// Expected weight is 3000 grams (3e+9 micrograms)
		wcInstance.setStatus(ScaleStatus.NORMAL);
		wcInstance.theMassOnTheScaleHasChanged(sampleScale, new Mass(5e+8));
		// We expect literally nothing to happen, just a straight return.
		
		// AB: It is very tough to test that nothing happens without modifying
		// source code. For now, the best I can do is confirm the state has
		// not changed when the weight change indicates it should.
		assertTrue("The Weight Checker had its status changed unexpectedly",
				wcInstance.status() == ScaleStatus.NORMAL);
	}
	
	@Test
	public void testWhenStatusNormalAndOverBounds() {
		wcInstance.enabled = true;
		// Expected weight is 3000 grams (3e+9 micrograms)
		wcInstance.setStatus(ScaleStatus.NORMAL);
		wcInstance.theMassOnTheScaleHasChanged(sampleScale, new Mass(4e+9));
		
		// 4000 > 3000 + 500, so we expect a blockage.
		assertTrue("The system did not block as expected",
				wcInstance.status() == ScaleStatus.BLOCKED);
	}
	
	@Test
	public void testWhenStatusNormalAndUnderBounds() {
		wcInstance.enabled = true;
		// Expected weight is 3000 grams (3e+9 micrograms)
		wcInstance.setStatus(ScaleStatus.NORMAL);
		wcInstance.theMassOnTheScaleHasChanged(sampleScale, new Mass(2e+9));
		
		// 2000 < 3000 - 500, so we expect a blockage.
		assertTrue("The system did not block as expected",
				wcInstance.status() == ScaleStatus.BLOCKED);
	}
	
	@Test
	public void testWhenStatusNormalAndInBounds() {
		wcInstance.enabled = true;
		// Expected weight is 3000 grams (3e+9 micrograms)
		wcInstance.setStatus(ScaleStatus.NORMAL);
		wcInstance.theMassOnTheScaleHasChanged(sampleScale, new Mass(3e+9));
		
		// 3000 < 3000 + 500 and 3000 > 3000 - 500, 
		// so we do not expect a blockage.
		assertTrue("The system blocked unexpectedly",
				wcInstance.status() == ScaleStatus.NORMAL);
	}
	
	@Test
	public void testWhenStatusBlockedAndOverBounds() {
		wcInstance.enabled = true;
		// Expected weight is 3000 grams (3e+9 micrograms)
		wcInstance.setStatus(ScaleStatus.BLOCKED);
		wcInstance.theMassOnTheScaleHasChanged(sampleScale, new Mass(4e+9));
		
		// 4000 > 3000 + 500, so we do not expect return to normal.
		assertTrue("The system did not stay blocked as expected",
				wcInstance.status() == ScaleStatus.BLOCKED);
	}
	
	@Test
	public void testWhenStatusBlockedAndUnderBounds() {
		wcInstance.enabled = true;
		// Expected weight is 3000 grams (3e+9 micrograms)
		wcInstance.setStatus(ScaleStatus.BLOCKED);
		wcInstance.theMassOnTheScaleHasChanged(sampleScale, new Mass(4e+9));
		
		// 2000 < 3000 - 500, so we do not expect a return to normal.
		assertTrue("The system did not stay blocked as expected",
				wcInstance.status() == ScaleStatus.BLOCKED);
	}
	@Test
	public void testWhenStatusBlockedAndInBounds() {
		wcInstance.enabled = true;
		// Expected weight is 3000 grams (3e+9 micrograms)
		wcInstance.setStatus(ScaleStatus.BLOCKED);
		wcInstance.theMassOnTheScaleHasChanged(sampleScale, new Mass(3e+9));
		
		// 3000 < 3000 + 500 and 3000 > 3000 - 500, 
		// so we do not expect a blockage.
		assertTrue("The system blocked unexpectedly",
				wcInstance.status() == ScaleStatus.NORMAL);
	}
}
