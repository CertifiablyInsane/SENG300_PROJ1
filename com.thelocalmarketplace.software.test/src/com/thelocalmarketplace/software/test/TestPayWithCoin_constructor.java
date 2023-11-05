package com.thelocalmarketplace.software.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.thelocalmarketplace.software.PayWithCoin;
import com.thelocalmarketplace.software.PaymentManager;

public class TestPayWithCoin_constructor {
	private PayWithCoin pwcInstance;
	private PaymentManager pmInstance;
	
	
	// test that the new instance created is not null
	@Test
	public void testInitializeIsNotNull(){
		pwcInstance = new PayWithCoin(pmInstance);
		assertNotNull(pwcInstance);	
	}

}