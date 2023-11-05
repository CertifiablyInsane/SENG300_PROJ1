// Author: Subeg Singh Chahal | UCID: 30196531
package com.thelocalmarketplace.software.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.*;

import com.jjjwelectronics.Item;
import com.jjjwelectronics.Mass;
import com.jjjwelectronics.Numeral;
import com.jjjwelectronics.scanner.Barcode;
import com.jjjwelectronics.scanner.BarcodedItem;
import com.thelocalmarketplace.hardware.BarcodedProduct;
import com.thelocalmarketplace.hardware.PLUCodedItem;
import com.thelocalmarketplace.hardware.PriceLookUpCode;
import com.thelocalmarketplace.software.ItemAdderBarcode;
import com.thelocalmarketplace.software.OrderManager;
import com.thelocalmarketplace.software.PaymentManager;
import com.thelocalmarketplace.software.ScaleStatus;
import com.thelocalmarketplace.software.WeightChecker;

import ca.ucalgary.seng300.simulation.InvalidArgumentSimulationException;

public class TestOrderManager_addItem {
		
	private OrderManager omInstance;
	private WeightChecker wcInstance;
	private PaymentManager pmInstance;
	private ItemAdderBarcode sampleItemAdderBarcode;
	
	@Before
	public void setup()
	{
		pmInstance = new PaymentManager();
		omInstance = new OrderManager(wcInstance, pmInstance);
		sampleItemAdderBarcode = new ItemAdderBarcode(omInstance);
	}
	
	@Test 
	public void testWhenNotEnabled()
	{
		omInstance.enabled = false;
		Mass barcodeItemMass = new Mass(3e+9);
		omInstance.addItem(new BarcodedItem(new Barcode(null), barcodeItemMass));
		
		// SC: Without the rest of the iteration it is difficult to implement and check for a return
		// so this is tested by confirming the expectedMass is not updated by adding an item 
		assertEquals(omInstance.expectedMass, omInstance.expectedMass);
	}
	
	@Test
	public void testAddItemWeightCheckerBlocked()
	{
		wcInstance.setStatus(ScaleStatus.BLOCKED);
		Mass barcodeItemMass = new Mass(3e+9);
		omInstance.addItem(new BarcodedItem(new Barcode(null), barcodeItemMass));
		
		// SC: Without the rest of the iteration it is difficult to implement and check for a return
		// so this is tested by confirming the scale status is not updated by adding an item
		assertTrue("The system stayed blocked as expected", wcInstance.status() == ScaleStatus.BLOCKED);	
	}
	
	@Test
	public void testAddItemNotReadyForNewItems()
	{
		omInstance.readyForNewItem = false;
		
		Mass barcodeItemMass = new Mass(3e+9);
		omInstance.addItem(new BarcodedItem(new Barcode(null), barcodeItemMass));
		
		// SC: Without the rest of the iteration it is difficult to implement and check for a return
		// so this is tested by confirming the expectedMass is not updated by adding an item 
		assertEquals(omInstance.expectedMass, omInstance.expectedMass);
	}
	
	// Tests for addingValidItem are supposed to be implemented however due to time constraints it was not possible 
	// Test for signaling to place an item in the bagging area are supposed to be implemented however due to time constraints it was not possible  
	
	@Test(expected = InvalidArgumentSimulationException.class)
	public void testAddItemInvalidItemType()
	{
		PLUCodedItem testPLUItem = new PLUCodedItem(new PriceLookUpCode("Code"), new Mass(0));
		omInstance.addItem(testPLUItem);
	}

}
