// Amira Wishah UCID:30182579
package com.thelocalmarketplace.software.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


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
		assertNotNull(pwcInstance);	//checks that initialization goes through and the parameter passed is not null 
	}
}