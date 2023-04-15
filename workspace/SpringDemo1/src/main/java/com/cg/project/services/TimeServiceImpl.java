package com.cg.project.services;

import java.util.Date;

public class TimeServiceImpl implements TimeService{

	public int getCurrentTime() {
		Date d = new Date();
		return d.getHours();
	}

}
