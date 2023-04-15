package com.gSchedule.bean;

import java.util.List;

public class Day {
	private String dayNo;
	private List<Game> games;
	public Day() {
		
	}
	public Day(String dayNo, List<Game> games) {
		super();
		this.dayNo = dayNo;
		this.games = games;
	}
	public String getDayNo() {
		return dayNo;
	}
	public void setDayNo(String dayNo) {
		this.dayNo = dayNo;
	}
	public List<Game> getGames() {
		return games;
	}
	public void setGames(List<Game> games) {
		this.games = games;
	}
	@Override
	public String toString() {
		return "Day [dayNo=" + dayNo + ", games=" + games + "]";
	}
	
}
