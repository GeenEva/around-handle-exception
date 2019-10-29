package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleExeptionDemoApp {
	
	//We're gonna print data to the logger output stream, the same Spring is using

	private static Logger myLogger =   Logger.getLogger(AroundHandleExeptionDemoApp.class.getName());
	
	public static void main(String[] args) {

	
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
	
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("\nMain Program: Around Demo App");
		myLogger.info("\n ... Calling getFortune()");
		
		boolean tripWire = true;
		String data = theFortuneService.getFortune(tripWire);
		
		myLogger.info("\nMy fortune is: " + data);
		myLogger.info("\nFinished");
		
		context.close();
	}

}
