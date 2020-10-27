package com.bridgelabs.cabpayrollservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabPayrollTest {

	private CabInvoiceService cabInvoice;
	private RideRepository rideRepository = null;
	InvoiceSummary expectedInvoiceSummary = null;
	Ride[] rides = null;

	@Before
	public void setUp() throws Exception {
		this.cabInvoice = new CabInvoiceService();
		rideRepository = new RideRepository();
		cabInvoice.setRideRepository(rideRepository);
		rides = new Ride[] { new Ride(CabRide.NORMAL, 2.0, 5), new Ride(CabRide.PREMIUM, 0.1, 1) };
		expectedInvoiceSummary = new InvoiceSummary(2, 45.0);

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
		InvoiceSummary summary = cabInvoice.calculateFare(rides);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}

	@Test
	public void givenUserIdRidesShouldReturnInvoiceSummary() {
		String userId = "a@b.com";
		cabInvoice.addRides(userId, rides);
		InvoiceSummary summary = cabInvoice.getInvoiceSummary(userId);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}
}
