package com.dius.tennisscorer.model;

import java.util.List;

import com.dius.tennisscorer.constants.Status;

public class Set {
	
	private List<Game> finishedGames;
	
	private Status setStatus;

	public List<Game> getFinishedGames() {
		return finishedGames;
	}

	public void setFinishedGames(List<Game> finishedGames) {
		this.finishedGames = finishedGames;
	}

	public Status getSetStatus() {
		return setStatus;
	}

	public void setSetStatus(Status setStatus) {
		this.setStatus = setStatus;
	}
	

}
