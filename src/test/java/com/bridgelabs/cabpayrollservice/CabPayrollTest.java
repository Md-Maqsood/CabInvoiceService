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
	@Test
	public void givenLessDistanceOrTimeShouldReturnMinFare() {
		CabInvoice cabInvoice=new CabInvoice();
		double distance=0.1;
		int time=1;
		double fare=cabInvoice.calculateFare(distance,time);
		Assert.assertEquals(5, fare, 0.0);
	}
	
	@Test
	public void givenMultipleRidesShouldReturnTotalFare() {
		CabInvoice cabInvoice=new CabInvoice();
		Ride[] rides= {new Ride(2.0,5),
				new Ride(0.1, 1),
		};
		double fare=cabInvoice.calculateFare(rides);
		Assert.assertEquals(30.0, fare,0.0);
	}
}
