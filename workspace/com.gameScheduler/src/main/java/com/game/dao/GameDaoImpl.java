package com.game.dao;

import java.util.*;

import com.game.bean.*;
import com.game.util.GameSchedulerUtil;

public class GameDaoImpl implements GameDaoInterface{
	private GameSchedulerUtil gameSchedulerUtil;
	public GameDaoImpl() {
		gameSchedulerUtil =new GameSchedulerUtil();
	}
}
