// Author: Subeg Singh Chahal | UCID: 30196531
package com.thelocalmarketplace.software;

import com.jjjwelectronics.Mass;
import com.jjjwelectronics.scanner.Barcode;
import com.jjjwelectronics.scanner.BarcodedItem;
import com.thelocalmarketplace.hardware.BarcodedProduct;
import com.thelocalmarketplace.hardware.external.ProductDatabases;

// Used by OrderManager to add items via barcode scanning:
public class ItemAdderBarcode {
	
	private OrderManager orderManager;

	// In the Constructor a reference to an instance of the OrderManager is set
	public ItemAdderBarcode(OrderManager orderManager) {
		this.orderManager = orderManager;
	}

	// Used to scan barcoded items to the self-checkout station 
	public void addBarcodedItem(BarcodedItem barcodedItem) {
		
		// The barcode of the item is stored and used to determine its associated product
		Barcode currentBarcode = barcodedItem.getBarcode();
		BarcodedProduct associatedProduct = ProductDatabases.BARCODED_PRODUCT_DATABASE.get(currentBarcode);

		// This product is used to determine the mass and price values of the item:
		Mass itemMass = new Mass(associatedProduct.getExpectedWeight() * 1e+6);
		long itemPrice = associatedProduct.getPrice();

		// The total cost of the bagging area is updated using this value by calling upon OrderManager
		orderManager.updateCostInPaymentManager((float) itemPrice);

		// The total mass of the bagging area is updated and stored using this value by calling upon OrderManager
		orderManager.expectedMass = orderManager.expectedMass.sum(itemMass);
		
		// The item is stored to an Arraylist, which represents all items added to the self-checkout station
		// SC: this will be utilized better in future iterations and is currently setup here for convenience
		orderManager.items.add(barcodedItem);
	}
}
