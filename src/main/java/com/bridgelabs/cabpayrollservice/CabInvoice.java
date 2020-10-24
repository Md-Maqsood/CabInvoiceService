package com.bridgelabs.cabpayrollservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CabInvoice {
	private static final Logger logger = LogManager.getLogger(CabInvoice.class);

	public static void main(String[] args) {
		logger.info("Welcome to cab payroll service program");
	}

	public double calculateFare(double distance, int time) {
		return 0.0;
	}
}
