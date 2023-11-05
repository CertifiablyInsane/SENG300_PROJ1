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

<<<<<<< HEAD
// AB: Subeg, I created this class as the manager that will divert the
// added item to whichever type of item is added. No functionality yet,
// I just needed to be able to reference it.
public class OrderManager {
	public boolean enabled;
	private boolean readyForNewItem = true;
	public Mass expectedMass = new Mass(0);
	public ArrayList<Item> items = new ArrayList<>();
	private WeightChecker weightChecker;
	private ItemAdderBarcode itemAdderBarcode;

	public OrderManager(WeightChecker weightChecker) {
=======
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
	private WeightChecker weightChecker; //
	private PaymentManager paymentManager;
	private ItemAdderBarcode itemAdderBarcode;

	// The constructor for OrderManager initializes and gives the class access to
	// the following
	public OrderManager(WeightChecker weightChecker, PaymentManager paymentManager) {
>>>>>>> refs/remotes/origin/main
		System.out.println("OrderManager has been created");
		this.weightChecker = weightChecker;
<<<<<<< HEAD
=======
		this.paymentManager = paymentManager;
>>>>>>> refs/remotes/origin/main

		itemAdderBarcode = new ItemAdderBarcode(this);
	}

<<<<<<< HEAD
=======
	// SC: In future iterations the rest of the ways that items are added will be
	// implemented
>>>>>>> refs/remotes/origin/main
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

		readyForNewItem = false;

		if (item instanceof BarcodedItem) {
			BarcodedItem barcodedItem = (BarcodedItem) item;
			itemAdderBarcode.addBarcodedItem(barcodedItem);
		}

<<<<<<< HEAD
		// SC: In future iterations the rest of the item types needed for add will be
		// implemented
=======
		// This should not occur, but if an item is added without using one of the
		// previous techniques an exception is thrown:
>>>>>>> refs/remotes/origin/main
		else {
			throw new InvalidArgumentSimulationException("Item must be one of the specified types");
		}

		// SC: Temporary solution to signaling user, as there is no GUI
		System.out.println("Please place item in bagging area");
	}

<<<<<<< HEAD
	public void removeItem(Product item) {
		// Not yet implemented
=======
	// SC: Not yet implemented in the first iteration:
	public void removeItem(Product item) {
>>>>>>> refs/remotes/origin/main
		throw new UnsupportedOperationException();
	}

<<<<<<< HEAD
=======
	// Unblocks the hardware the when the items and weight of the station have been
	// appropriately updated
>>>>>>> refs/remotes/origin/main
	public void itemPlacedInBaggingArea() {
		readyForNewItem = true;
	}

	public void updateCostInPaymentManager(float itemCost) {
		paymentManager.amountDue += itemCost;
	}
}
