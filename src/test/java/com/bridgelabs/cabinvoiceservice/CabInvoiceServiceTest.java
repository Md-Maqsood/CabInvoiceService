package com.bridgelabs.cabinvoiceservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bridgelabs.cabinvoiceservice.CabInvoiceService;
import com.bridgelabs.cabinvoiceservice.CabRide;
import com.bridgelabs.cabinvoiceservice.InvoiceSummary;
import com.bridgelabs.cabinvoiceservice.Ride;
import com.bridgelabs.cabinvoiceservice.RideRepository;

public class CabInvoiceServiceTest {

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
		Ride[] rides= {new Ride(CabRide.NORMAL,distance,time)};
		double fare = cabInvoice.calculateFare(rides).getTotalFare();
		Assert.assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenLessDistanceOrTimeShouldReturnMinFare() {
		double distance = 0.1;
		int time = 1;
		Ride[] rides= {new Ride(CabRide.NORMAL,distance,time)};
		double fare = cabInvoice.calculateFare(rides).getTotalFare();
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
