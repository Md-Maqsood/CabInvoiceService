package com.bridgelabs.cabpayrollservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
	Map<String, ArrayList<Ride>> userRides = null;

	public RideRepository() {
		this.userRides = new HashMap<>();
	}

	public void addRide(String userId, Ride[] rides) {
		// TODO Auto-generated method stub
		ArrayList<Ride> rideList = this.userRides.get(userId);
		if (rideList == null) {
			this.userRides.put(userId, new ArrayList<>(Arrays.asList(rides)));
		}

	}

	public Ride[] getRides(String userId) {
		// TODO Auto-generated method stub
		return this.userRides.get(userId).toArray(new Ride[0]);
	}

}
