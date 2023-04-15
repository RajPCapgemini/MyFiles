package com.gSchedule.service;

import com.gSchedule.dao.*;

public class GameSchedulerServiceImpl implements GameSchedulerServiceInt{
	private GameSchedulerDaoInt gameSchedulerDaoImpl;
	public GameSchedulerServiceImpl() {
		gameSchedulerDaoImpl=new GameSchedulerDaoImpl();
	}
	public String playerWiseReport(int playerId) {
		// TODO Auto-generated method stub
		
		return null;
	}

	public String gameWiseReport(String gameName) {
		// TODO Auto-generated method stub
		return null;
	}

	public String dayWiseReport(String dayNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
