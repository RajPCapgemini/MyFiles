package com.game.bean;

import java.util.*;

public class Game {
	private String gameName;
	private ArrayList<Player> players;
	private ArrayList<Day> days;
	
	public Game() {
		super();
	}

	public Game(String gameName, ArrayList<Player> players, ArrayList<Day> days) {
		super();
		this.gameName = gameName;
		this.players = players;
		this.days = days;
	}
	
	
}
