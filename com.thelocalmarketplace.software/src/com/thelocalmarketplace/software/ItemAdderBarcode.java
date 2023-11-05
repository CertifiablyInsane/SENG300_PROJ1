// Author: Subeg Singh Chahal | UCID: 30196531
package com.thelocalmarketplace.software;

import com.jjjwelectronics.Mass;
import com.jjjwelectronics.scanner.Barcode;
import com.jjjwelectronics.scanner.BarcodedItem;
import com.thelocalmarketplace.hardware.BarcodedProduct;
import com.thelocalmarketplace.hardware.external.ProductDatabases;

public class ItemAdderBarcode {
	private OrderManager orderManager;

	public ItemAdderBarcode(OrderManager orderManager) {
		this.orderManager = orderManager;
	}

	public void addBarcodedItem(BarcodedItem barcodedItem) {
		Barcode currentBarcode = barcodedItem.getBarcode();
		BarcodedProduct associatedProduct = ProductDatabases.BARCODED_PRODUCT_DATABASE.get(currentBarcode);

		Mass itemMass = new Mass(associatedProduct.getExpectedWeight() * 1e+6);
		long itemPrice = associatedProduct.getPrice();

		orderManager.updateCostInPaymentManager((float) itemPrice);

		orderManager.expectedMass = orderManager.expectedMass.sum(itemMass);
		orderManager.items.add(barcodedItem);
	}
}
