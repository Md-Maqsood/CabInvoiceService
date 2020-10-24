package com.bridgelabs.cabpayrollservice;

import org.junit.Assert;
import org.junit.Test;

public class CabPayrollTest {

	@Test
	public void givenDistanceAndTimeShouldReturnTotalFare() {
		CabInvoice cabInvoice=new CabInvoice();
		double distance=2.0;
		int time=5;
		double fare=cabInvoice.calculateFare(distance,time);
		Assert.assertEquals(25, fare, 0.0);
	}
}
