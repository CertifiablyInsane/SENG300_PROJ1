// Author: Subeg Singh Chahal | UCID: 30196531
package com.thelocalmarketplace.software;

// The imports required for this class to function from the hardware:
import java.util.ArrayList;

import com.jjjwelectronics.Item;
import com.jjjwelectronics.Mass;
import com.jjjwelectronics.scanner.*;
import com.tdc.DisabledException;
import com.thelocalmarketplace.hardware.*;

import ca.ucalgary.seng300.simulation.InvalidArgumentSimulationException;

// The primary function of the OrderManager class is to keep track of the items in the customer's current order and coordinate
// with the weightChecker and PaymentManager classes to set payments and update the weight in the bagging area, accordingly:
public class OrderManager {
	// The following are instance variables, class variables, and objects that are
	// declared for use later in this class:
	public boolean enabled; // Used to check whether the hardware is enabled
	private boolean readyForNewItem = true; // Used to block the self-checkout station when it is ready to add items
	public Mass expectedMass = new Mass(0); // Stores the updated mass used in the WeightChecker class when items are
											// added/removed
	public ArrayList<Item> items = new ArrayList<>(); // Holds the specific items that get added to the bagging area
	private WeightChecker weightChecker; // Stores instance of weightChecker
	private PaymentManager paymentManager; // Stores instance of paymentManager
	private ItemAdderBarcode itemAdderBarcode; // Stores instance of itemAdderBarcode

	// The constructor for OrderManager sets all objects needed to be accessed by the OrderManager class
	// to appropriate instance variables, as select methods/variables from these classes will be used later 
	// in the code:
	public OrderManager(WeightChecker weightChecker, PaymentManager paymentManager) {
		System.out.println("OrderManager has been created");
		this.weightChecker = weightChecker;
		this.paymentManager = paymentManager;

		// Creates an itemAdderBarcode with reference to an instance of this class which is used
		// in the addItem method to add barcode items. It needs a reference to this class in order
		// to use the updateCostInPaymentManager method
		itemAdderBarcode = new ItemAdderBarcode(this);
	}

	// SC: In future iterations the rest of the ways that items are added will be
	// implemented
	public void addItem(Item item) {
		 
		if (!enabled) {
			return;
		}

		if (weightChecker.status() == ScaleStatus.BLOCKED) {
			return;
		}

		if (!readyForNewItem) {
			return;
		}
		
		// Used to block the system when adding items
		readyForNewItem = false;

		// Checks the class of the item entered in order to determine which form of adding is required
		// SC: The following if else statements will be expanded when other forms of 
		// payment are required
		if (item instanceof BarcodedItem) {
			BarcodedItem barcodedItem = (BarcodedItem) item;
			itemAdderBarcode.addBarcodedItem(barcodedItem);
		}

		// This should not occur, but if an item is added without using one of the
		// previous techniques an exception is thrown:
		else {
			throw new InvalidArgumentSimulationException("Item must be one of the specified types");
		}

		// SC: Temporary solution to signaling user, as there is no GUI
		System.out.println("Please place item in bagging area");
	}

	// SC: Not yet implemented in the first iteration:
	public void removeItem(Product item) {
		throw new UnsupportedOperationException();
	}

	// Unblocks the hardware when the items and weight of the station have been
	// appropriately updated
	public void itemPlacedInBaggingArea() {
		readyForNewItem = true;
	}

	// Used by the ItemAdder classes to update the total cost of the bagging area whenever an item is added
	// or removed
	// SC: Currently only the ItemAdderBarcode class has been created for the first iteration
	public void updateCostInPaymentManager(float itemCost) {
		paymentManager.amountDue += itemCost;
	}
}
