package com.dius.tennisscorer.score;

import com.dius.tennisscorer.constants.Status;
import com.dius.tennisscorer.model.Game;
import com.dius.tennisscorer.model.Set;

public class GenericSetScorer implements SetScorer {

	public GenericSetScorer(String player1, String player2) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String scoreSet(Set set) {
		int player1Wins = 0;
		int player2Wins = 0;
		for (Game g : set.getFinishedGames()) {
			if (Status.WON.equals(g.getGameStatus())) {
				if (g.getWinner() == "player1") {
					player1Wins++;
				} else if (g.getWinner() == "player2") {
					player2Wins++;
				}
			}
		}
		if (player1Wins >= 6 || player2Wins >= 6) {
			if (Math.abs(player1Wins - player2Wins) < 2) {
				return resolveTieBreak(set, player1Wins, player2Wins);
			}
			set.setSetStatus(Status.WON);
			if (player1Wins > player2Wins) {
				return "Player1 - WON";
			} else {
				return "Player2 - WON";
			}
		}
		return player1Wins + "-" + player2Wins;

	}

	private String resolveTieBreak(Set set, int player1Wins, int player2Wins) {
		if (set.getCurrentGame().getPlayer1Score() >= 7 || set.getCurrentGame().getPlayer2Score() >= 7
				&& Math.abs(set.getCurrentGame().getPlayer1Score() - set.getCurrentGame().getPlayer2Score()) >= 2) {
			if (set.getCurrentGame().getPlayer1Score() > set.getCurrentGame().getPlayer2Score()) {
				return "Player1 - WON";
			} else {
				return "Player2 - WON";
			}

		}
		set.getCurrentGame().setGameStatus(Status.TIE_BREAK);
		return player1Wins + "-" + player2Wins + "-(Tie Break)";
	}

}
