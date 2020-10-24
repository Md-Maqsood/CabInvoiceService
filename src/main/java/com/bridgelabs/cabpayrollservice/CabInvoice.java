package com.bridgelabs.cabpayrollservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CabInvoice {
	private static final Logger logger = LogManager.getLogger(CabInvoice.class);
	public static final double MINIMUM_COST_PER_KILOMETER = 10.0;
	public static final int COST_PER_TIME = 1;
	public static final double MINIMUM_FARE=5.0;
	public double calculateFare(double distance, int time) {
		double totalFare= distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
			if(totalFare<MINIMUM_FARE) {
				return MINIMUM_FARE;
			}else {
				return totalFare;
			}
	}
}
