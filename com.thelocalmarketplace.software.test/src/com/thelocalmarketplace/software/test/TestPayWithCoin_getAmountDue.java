package com.thelocalmarketplace.software.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.tdc.coin.Coin;
import com.thelocalmarketplace.software.*;

public class TestPayWithCoin_getAmountDue {
	
	PayWithCoin pwcInstance ;
	
	@Before
	public void setUp() {
			
	}
	@Test
	public void testWhenAmountDueIsPositive() { // test for a positive amount when nothing has been paid
		BigDecimal value = new BigDecimal("4");
		pwcInstance = new PayWithCoin(value);
		
		
		float expected = 4;
		float actual = pwcInstance.getAmountDue();
		float delta = 0;
		assertEquals(expected, actual, delta);	
	}
	
	
	public void testWhenAmountDueisNegative () { // test for a negative amount i.e customer has over paid
		BigDecimal owed = new BigDecimal("5");
		BigDecimal paid = new BigDecimal("7");
		pwcInstance = new PayWithCoin(owed);
		
		Coin testCoin = new Coin(paid); // create instance of coin where the value is what customer paid
		pwcInstance.insertCoin(testCoin);
		
		
		float expected = -2;
		float actual = pwcInstance.getAmountDue();
		float delta = 0;
		assertEquals(expected, actual, delta);	
	}
	
	public void testWhenAmountDueis0() {
		
	}
}


