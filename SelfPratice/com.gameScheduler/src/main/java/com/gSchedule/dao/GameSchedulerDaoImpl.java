package com.gSchedule.dao;

import com.gSchedule.util.GameScheduleUtil;
import com.gSchedule.bean.*;
import java.util.*;

public class GameSchedulerDaoImpl implements GameSchedulerDaoInt{
	private GameScheduleUtil gameScheduleUtil;
	public GameSchedulerDaoImpl() {
		gameScheduleUtil = new GameScheduleUtil();
	}
	public Player getPlayerById(int playerId) {
		List<Day> days = gameScheduleUtil.getDays();
		for(Day d:days) {
			List<Game> games = d.getGames();
			for(Game g: games) {
				List<Player> players=g.getPlayers();
				for(Player p:players) {
					if(p.getPlayerId()==playerId) {
						return p;
					}
				}
			}
		}
		return null;
	}
}
