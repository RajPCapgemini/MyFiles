package com.gSchedule.bean;

import java.util.List;

public class Game {
	private String gameName;
	private List<Player> players;
	public Game() {
		
	}
	public Game(String gameName, List<Player> players) {
		super();
		this.gameName = gameName;
		this.players = players;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	@Override
	public String toString() {
		return "Game [gameName=" + gameName + ", players=" + players + "]";
	}
	
	
}
