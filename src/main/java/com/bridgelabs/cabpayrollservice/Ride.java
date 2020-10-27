package com.bridgelabs.cabpayrollservice;

public class Ride {
	public double distance;
	public int time;

	public Ride(CabRide ride, double distance, int time) {
		this.distance = distance;
		this.time = time;
	}
}
