package com.cg.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="greetingService")
public class GreetingServiceImpl implements GreetingService{
	@Autowired
	private TimeService timeService;
	
		
//	public GreetingServiceImpl(TimeService timeService) {
//		super();
//		this.timeService = timeService;
//	}


//	public void setTimeService(TimeService timeService) {
//		this.timeService = timeService;
//	}


	public void greet(String name) {
		int currHr = timeService.getCurrentTime();
		if(currHr<12) System.out.println("Good Morning "+name);
		else if(currHr<16) System.out.println("Good Afternoon "+name);
	}

}
