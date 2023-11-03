// André Beaulieu, UCID 30174544
package com.thelocalmarketplace.software;

import java.math.BigDecimal;

import com.jjjwelectronics.IDevice;
import com.jjjwelectronics.IDeviceListener;
import com.jjjwelectronics.Mass;
import com.jjjwelectronics.scale.*;

public class WeightChecker implements ElectronicScaleListener{
	public boolean enabled;
	
	// AB: Any other components trying to get the status should 
	// do something along the lines of:
	// if(WeightChecker.status() == ScaleStatus.BLOCKED){
	// 		// Do something...
	//	}
	private static ScaleStatus status = ScaleStatus.NORMAL;
	public static ScaleStatus status() {return status;}

	private ElectronicScale scale;
	private BigDecimal LENIENCY; // Leniency, in Grams
	
	// Take keep the supplied scale as a pointer 
	// and register yourself with that scale.
	public WeightChecker(ElectronicScale scaleToMonitor, float leniencyInGrams) {
		scale = scaleToMonitor;
		// Register this class as a listener for this scale.
		scale.register(this);
		LENIENCY = new BigDecimal(leniencyInGrams);
	}
	
	// If outside the bounds of expectation, shut the system down.
	// Once we're back within these bounds, re-enable the system
	@Override
	public void theMassOnTheScaleHasChanged(IElectronicScale scale, Mass mass) {
		if(!enabled) { return; }
		
		Mass expectedMass = new Mass(0);//OrderManager.getExpectedMass();
		BigDecimal upperLimit = expectedMass.inGrams().add(LENIENCY);
		BigDecimal lowerLimit = expectedMass.inGrams().subtract(LENIENCY);
		if(status() == ScaleStatus.NORMAL) {
			if(mass.inGrams().compareTo(upperLimit) > 0 ||
					mass.inGrams().compareTo(lowerLimit) < 0){
				// Outside expectation bounds, blocking...
				setStatus(ScaleStatus.BLOCKED);
			}			
		}
		else if(status() == ScaleStatus.BLOCKED) {
			if(mass.inGrams().compareTo(upperLimit) < 0 &&
					mass.inGrams().compareTo(lowerLimit) > 0){
				// Back within expectation bounds, returning to normal...
				setStatus(ScaleStatus.NORMAL);
			}	
		}
	}
	
	// AB: I acknowledge that onAttendantOverride and onDoNotBagRequest are the
	// same. They are split because they will become different later.
	
	// When the attendant verifies and allows the weight discrepancy.
	// Return the status to normal and continue
	public void onAttendantOverride() {
		setStatus(ScaleStatus.NORMAL);
	}
	// When the customer indicates they did not bag the item on purpose.
	// Return the status to normal and continue
	public void onDoNotBagRequest() {
		setStatus(ScaleStatus.NORMAL);
	}
	
	// Set the WeightChecker's status to be the supplied status
	private static void setStatus(ScaleStatus ss) {
		// TODO: Add GUI that tells customer the scale is blocked.
		// TODO: Add GUI that tells the attendant the scale is blocked.
		status = ss;
	}

	//
	// AB: We do not care about these implementations. Left blank and put to the side.
	//
	@Override
	public void theMassOnTheScaleHasExceededItsLimit(IElectronicScale scale) {}
	@Override
	public void theMassOnTheScaleNoLongerExceedsItsLimit(IElectronicScale scale) {	}
	@Override
	public void aDeviceHasBeenEnabled(IDevice<? extends IDeviceListener> device) {}
	@Override
	public void aDeviceHasBeenDisabled(IDevice<? extends IDeviceListener> device) {}
	@Override
	public void aDeviceHasBeenTurnedOn(IDevice<? extends IDeviceListener> device) {}
	@Override
	public void aDeviceHasBeenTurnedOff(IDevice<? extends IDeviceListener> device) {}

}
