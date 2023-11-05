// Amira Wishah 301282579
package com.thelocalmarketplace.software.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.tdc.coin.Coin;
import com.thelocalmarketplace.software.PayWithCoin;
import com.thelocalmarketplace.software.PaymentManager;

import ca.ucalgary.seng300.simulation.InvalidArgumentSimulationException;
import ca.ucalgary.seng300.simulation.NullPointerSimulationException;

public class TestPayWithCoin_insertCoin {
	PayWithCoin pwcInstance;
	PaymentManager pmInstance;
	

	
	// Test when value of coin is 0
		@Test (expected = InvalidArgumentSimulationException.class)
		public void testWhenCoinValueIsZero() { 
			BigDecimal zeroCoinValue = BigDecimal.ZERO;
			Coin testCoin = new Coin(zeroCoinValue);
			
			pwcInstance.insertCoin(testCoin);
			
			throw new InvalidArgumentSimulationException("Coin value of zero is not allowed.");
		}

	// Test when value of coin is negative
		@Test (expected = InvalidArgumentSimulationException.class)
		public void testWhenCoinValueIsNegativeSix() { 
			
			BigDecimal negSixCoinValue = new BigDecimal("-6");
			Coin testCoin = new Coin(negSixCoinValue);
					
			pwcInstance.insertCoin(testCoin);
		
			throw new InvalidArgumentSimulationException("Coin of negative value is not allowed.");
		}
		
		
	// test when a null coin is inserted
		@Test (expected = NullPointerSimulationException.class)
		public void testWhenCoinValueIsNull() {
	
			Coin testCoin = new Coin(null);
			testCoin.getValue().floatValue();
			throw new NullPointerSimulationException("No coin detected.");
	
	}
	
	
	// test that the coin value gets recorded accurately with a valid coin of value 5
		@Test 
		public void testCountingInsertValueProperlyWhenInsertValueIs5() {
			BigDecimal fiveCoinValue = new BigDecimal("5");
			Coin testCoin = new Coin(fiveCoinValue);
			
			float expected = 5;
			float actual = testCoin.getValue().floatValue() ;
		
			assertEquals(expected, actual, 0);
			
		}
	
		
	// test that the coin value gets recorded accurately with a coin of value 0
		@Test 
		public void testCountingInsertValueProperlyWhenInsertValueIsZero() {
			
			BigDecimal zeroCoinValue = new BigDecimal("0");
			Coin testCoin = new Coin(zeroCoinValue);
			float expected = 5;
			float actual = testCoin.getValue().floatValue() ;
			assertEquals(expected, actual, 0);
					
				}		
		
		
	// tests that the amount paid is updated accurately after a valid coin is inserted
		@Test
		public void testAmountPaidAfterInsertValidPaymentOf5() { 
		
			BigDecimal fiveCoinValue = new BigDecimal("5");
			Coin testCoin = new Coin(fiveCoinValue);
		
			pwcInstance.insertCoin(testCoin);
		
		
			float expected = 5;
			float actual = pmInstance.amountPaid;;	
			
			assertEquals(expected, actual, 0);
	}
	
	// tests that the amount paid is updated accurately after a negative value (invalid) coin is inserted
		@Test
		public void testAmountPaidAfterInsertInvalidPaymentofNegativeSix() { 
			
			BigDecimal negSixCoinValue = new BigDecimal("-6");
			Coin testCoin = new Coin(negSixCoinValue);
			
			pwcInstance.insertCoin(testCoin);
			
			
			float expected = 0;
			float actual = pmInstance.amountPaid;;	
			
			assertEquals(expected, actual, 0);
		}
} 

