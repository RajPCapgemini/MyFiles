package com.gSchedule.util;

import com.gSchedule.bean.*;
import java.util.*;

public class GameScheduleUtil {
	private List<Day> days;
	private List<Player> players;
	private List<Game> games;
	public GameScheduleUtil() {
		days=new ArrayList<Day>();
		players = new ArrayList<Player>();
		games = new ArrayList<Game>();
		Player p1=new Player(001,"Michael");
		Player p2=new Player(002,"Adam");
		Player p3=new Player(003,"Neil");
		players.add(p1);
		players.add(p2);
		Game g1 = new Game("100 m",players);
		players.remove(p1);
		players.add(p3);
		Game g2 = new Game("200 m",players);
		players.add(p1);
		Game g3 = new Game("400 m",players);
		games.add(g1);
		games.add(g2);
		Day d1=new Day("Day 1",games);
		days.add(d1);
		games.remove(g1);
		games.add(g3);
		Day d2 = new Day("Day 2",games);
		days.add(d2);
		games.add(g1);
		Day d3 = new Day("Day 3",games);
		days.add(d3);
		
		
	}
	public List<Day> getDays(){
		return days;
	}
	
	
}
