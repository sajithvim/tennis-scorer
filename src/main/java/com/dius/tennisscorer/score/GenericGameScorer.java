package com.dius.tennisscorer.score;

import java.util.HashMap;
import java.util.Map;

import com.dius.tennisscorer.constants.Status;
import com.dius.tennisscorer.model.Game;

public class GenericGameScorer implements GameScorer {

	private Map<String, String> scoreMapping;
	private String player1Name;
	private String player2Name;

	public GenericGameScorer(String player1, String player2) {
		this.player1Name = player1;
		this.player2Name = player2;
	}

	public GenericGameScorer() {
		scoreMapping = new HashMap<>();
		scoreMapping.put("0", "0");
		scoreMapping.put("1", "15");
		scoreMapping.put("2", "30");
		scoreMapping.put("3", "40");
	}

	public String scoreGame(Game game) {
		if (Status.TIE_BREAK.equals(game.getGameStatus())) {
			return formatGameScore(game);
		}
		if (game.getPlayer1Score() >= 3 && game.getPlayer2Score() >= 3
				&& Math.abs(game.getPlayer1Score() - game.getPlayer2Score()) <= 1) {
			if (game.getPlayer1Score() == game.getPlayer2Score()) {
				return "Deduce";
			} else if (game.getPlayer1Score() > game.getPlayer2Score()) {
				return "Advantage player 1";
			} else if (game.getPlayer1Score() < game.getPlayer2Score()) {
				return "Advantage player 2";
			}

		}
		// Analyze closure situation
		if (game.getPlayer1Score() >= 4 || game.getPlayer2Score() >= 4) {
			if (Math.abs(game.getPlayer1Score() - game.getPlayer2Score()) < 2) {
				return formatGameScore(game);
			} else {
				if (game.getPlayer1Score() > game.getPlayer2Score()) {
					game.setWinner("player1");
				} else {
					game.setWinner("player2");
				}
				game.setGameStatus(Status.WON);
				return "WON";
			}
		}
		return formatGameScore(game);
	}

	protected String formatGameScore(Game game) {
		String player1Score = Integer.toString(game.getPlayer1Score());
		String player2Score = Integer.toString(game.getPlayer2Score());
		player1Score = scoreMapping.get(player1Score) != null ? scoreMapping.get(player1Score) : player1Score;
		player2Score = scoreMapping.get(player2Score) != null ? scoreMapping.get(player2Score) : player2Score;
		return player1Score + "-" + player2Score;
	}

}
