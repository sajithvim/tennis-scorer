package com.dius.tennisscorer.model;

import com.dius.tennisscorer.constants.Status;

public class Game {
	
	private int player1Score;
	
	private int player2Score;
	
	private String winner;
	
	private Status gameStatus;

	public int getPlayer1Score() {
		return player1Score;
	}

	public void setPlayer1Score(int player1Score) {
		this.player1Score = player1Score;
	}

	public int getPlayer2Score() {
		return player2Score;
	}

	public void setPlayer2Score(int player2Score) {
		this.player2Score = player2Score;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public Status getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(Status gameStatus) {
		this.gameStatus = gameStatus;
	}


}
