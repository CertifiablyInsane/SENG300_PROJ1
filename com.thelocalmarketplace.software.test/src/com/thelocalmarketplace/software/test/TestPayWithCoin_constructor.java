package com.thelocalmarketplace.software.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import java.math.*;

import com.thelocalmarketplace.software.PayWithCoin;
import com.thelocalmarketplace.software.PaymentManager;

public class TestPayWithCoin_constructor {
	private PayWithCoin pwcInstance;
	
	
	@Before
	public void setUp() {
		
	}
	@Test
	public void testTotalPaidWithInput1(){
		BigDecimal totalDue = new BigDecimal ("1");
		pwcInstance = new PayWithCoin(totalDue);
		
		//float actualTotalPaid = newCOinSession.getValuePaid;
		fl//oat expectedTotalPaid = 
		
		
		
		
	}

	@Test
	public void testIncorrectInput(){
		//float floatTest = 5;
		//pwcInstance = new PayWithCoin(floatTest);

	}


}

