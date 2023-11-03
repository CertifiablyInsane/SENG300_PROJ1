package com.thelocalmarketplace.software;

import java.math.BigDecimal;

import com.tdc.coin.Coin;

public class PayWithCoinScratch {
	

		
	    private BigDecimal totalDue;
	    private float totalPaid;

	    public PayWithCoinScratch(BigDecimal totalDue) {
	    	
	        this.totalDue = totalDue;
	        this.totalPaid = 0;
	    }

	    
	    public void insertCoin(Coin testCoin) {
	        float coinTempValue = testCoin.getValue().floatValue();
	        totalPaid = totalPaid + coinTempValue;
	    }
	}


