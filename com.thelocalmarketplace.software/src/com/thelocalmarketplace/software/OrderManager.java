// Author: Subeg Singh Chahal | UCID: 30196531
package com.thelocalmarketplace.software;

import java.util.ArrayList;

import com.jjjwelectronics.Item;
import com.jjjwelectronics.Mass;
import com.jjjwelectronics.scanner.*;
import com.tdc.DisabledException;
import com.thelocalmarketplace.hardware.*;

import ca.ucalgary.seng300.simulation.InvalidArgumentSimulationException;

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
		System.out.println("OrderManager has been created");
		this.weightChecker = weightChecker;

		itemAdderBarcode = new ItemAdderBarcode(this);
	}

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

		// SC: In future iterations the rest of the item types needed for add will be
		// implemented
		else {
			throw new InvalidArgumentSimulationException("Item must be one of the specified types");
		}

		// SC: Temporary solution to signaling user, as there is no GUI
		System.out.println("Please place item in bagging area");
	}

	public void removeItem(Product item) {
		// Not yet implemented
		throw new UnsupportedOperationException();
	}

	public void itemPlacedInBaggingArea() {
		readyForNewItem = true;
	}
}
