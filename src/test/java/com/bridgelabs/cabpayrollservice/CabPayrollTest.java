package com.bridgelabs.cabpayrollservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabPayrollTest {

	private CabInvoiceService cabInvoice;

	@Before
	public void setUp() {
		this.cabInvoice = new CabInvoiceService();
	}

	@Test
	public void givenDistanceAndTimeShouldReturnTotalFare() {
		double distance = 2.0;
		int time = 5;
		double fare = cabInvoice.calculateFare(distance, time);
		Assert.assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenLessDistanceOrTimeShouldReturnMinFare() {
		double distance = 0.1;
		int time = 1;
		double fare = cabInvoice.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenMultipleRidesShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1), };
		InvoiceSummary summary = cabInvoice.calculateFare(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedSummary, summary);
	}
	
	@Test
	public void givenUserIdRidesShouldReturnInvoiceSummary() {
		String userId="a@b.com";
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1), };
		cabInvoice.addRides(userId, rides);
		InvoiceSummary summary=cabInvoice.getInvoiceSummary(userId);
		InvoiceSummary expectedSummary= new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedSummary, summary);
	}
}
