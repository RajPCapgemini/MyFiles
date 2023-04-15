package com.gSchedule.service;

public interface GameSchedulerServiceInt {
	public String playerWiseReport(int playerId);
	public String gameWiseReport(String gameName);
	public String dayWiseReport(String dayNo);
}
