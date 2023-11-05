// Amira Wishah 301282579
package com.thelocalmarketplace.software.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.tdc.coin.Coin;
import com.thelocalmarketplace.software.PayWithCoin;
import com.thelocalmarketplace.software.PaymentManager;

import ca.ucalgary.seng300.simulation.NullPointerSimulationException;

public class TestPayWithCoin_insertCoin {
	PayWithCoin pwcInstance;
	PaymentManager pmInstance;
	
	@Test 
	public void testCountingInsertValueProperlyWhenInsertValueIs5() {// test that the coin value gets recorded accurately
		BigDecimal testCoinValue = new BigDecimal("5");
		Coin testCoin = new Coin(testCoinValue);
		
		float expected = 5;
		float actual = testCoin.getValue().floatValue() ;
	
		assertEquals(expected, actual, 0);
		
	}
	@Test// (expected = NullPointerSimulationException.class)
	public void testInsertWhenInsertValueIsInvalid() {// test that the coin value gets recorded accurately
		//BigDecimal testCoinValue = new BigDecimal("5");
		Coin testCoin = new Coin(null);
		testCoin.getValue().floatValue();
		throw new NullPointerSimulationException("No coin detected.");
	
	}
	
	@Test
	public void testAmountPaidAfterInsertValidPayment() { // tests that the amount paid is updated accurately after coin is inserted
		
		BigDecimal testCoinValue = new BigDecimal("5");
		Coin testCoin = new Coin(testCoinValue);
		
		pwcInstance.insertCoin(testCoin);
		
		
		float expected = 5;
		float actual = pmInstance.amountPaid;;	
		
		assertEquals(expected, actual, 0);
	}
	
	
	
} /**public void insertCoin(Coin testCoin) {
	float coinTempValue = testCoin.getValue().floatValue();
	paymentManager.amountPaid += coinTempValue; **/

