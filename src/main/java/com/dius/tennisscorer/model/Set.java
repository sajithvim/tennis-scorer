package com.dius.tennisscorer.model;

import java.util.ArrayList;
import java.util.List;

import com.dius.tennisscorer.constants.Status;
import com.dius.tennisscorer.errors.TennisScorerException;

public class Set {
	
	private List<Game> finishedGames;
	
	private Status setStatus;
	
	private Game currentGame;
	
	public Set() {
		finishedGames = new ArrayList<>();
		setStatus = Status.IN_PROGRESS;
		currentGame = new Game();
	}
	
	public void pointsWonBy(String player) throws TennisScorerException {
		if(setStatus.equals(Status.WON) || setStatus.equals(Status.ABANDONED)) {
			throw new TennisScorerException("The set has already been " + setStatus.toString());
		}
		if("player1".equalsIgnoreCase(player)) {
			currentGame.addPlayerPoint("player1");
		} else if ("player2".equalsIgnoreCase(player)) {
			currentGame.addPlayerPoint("player2");
		}else {
			throw new TennisScorerException("Could not recognize the player " + player + " It should be either player1 or player2");
		}
	}

	public Game getCurrentGame() {
		return currentGame;
	}

	public void setCurrentGame(Game currentGame) {
		this.currentGame = currentGame;
	}

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
