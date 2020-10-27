package com.bridgelabs.cabinvoiceservice;

public class CabInvoiceService {
	private RideRepository rideRepository;

	public void setRideRepository(RideRepository rideRepository) {
		 this.rideRepository=rideRepository;
	}

	

	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += ride.cabRide.calculateRideCost(ride);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}

	public void addRides(String userId, Ride[] rides) {
		rideRepository.addRide(userId, rides);
	}

	public InvoiceSummary getInvoiceSummary(String userId) {
		return this.calculateFare(rideRepository.getRides(userId));
	}

	
}
