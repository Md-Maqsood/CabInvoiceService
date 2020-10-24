package com.bridgelabs.cabpayrollservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CabInvoice {
	private static final Logger logger = LogManager.getLogger(CabInvoice.class);
	public static final int MINIMUM_COST_PER_KILOMETER =10;
	public static final int COST_PER_TIME=1;

	public static void main(String[] args) {
		logger.info("Welcome to cab payroll service program");
	}

	public double calculateFare(double distance, int time) {
		return distance*MINIMUM_COST_PER_KILOMETER + time*COST_PER_TIME;
	}
}
