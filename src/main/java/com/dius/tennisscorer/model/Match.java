package com.dius.tennisscorer.model;

import java.util.HashMap;
import java.util.Map;

import com.dius.tennisscorer.errors.TennisScorerException;
import com.dius.tennisscorer.score.GameScorer;
import com.dius.tennisscorer.score.GenericGameScorer;
import com.dius.tennisscorer.score.GenericSetScorer;
import com.dius.tennisscorer.score.SetScorer;

/**
 * 
 * @author sajith This class simulates the match Restrictions : This only
 *         considers single matches
 */
public class Match {

	private Set set;

	private GameScorer gameScorer;

	private SetScorer setScorer;

	private Map<String, String> playersMap;

	public Match(String player1, String player2) {
		this.set = new Set();
		playersMap = new HashMap<>();
		playersMap.put(player1, "player1");
		playersMap.put(player2, "player2");
		gameScorer = new GenericGameScorer(player1, player2);
		setScorer = new GenericSetScorer(player1, player2);
	}

	public void pointWonBy(String playerName) {
		try {
			String player = playersMap.get(playerName);
			if (player == null) {
				throw new TennisScorerException("Invalid player name " + playerName);
			}
			set.pointsWonBy(player);
		} catch (TennisScorerException e) {
			e.printStackTrace();
		}
	}

	public String score() {
		String gameScore = gameScorer.scoreGame(set.getCurrentGame());
		if ("WON".equals(gameScore)) {
			set.getFinishedGames().add(set.getCurrentGame());
			set.setCurrentGame(new Game());
			gameScore = "";
		}
		String setScore = setScorer.scoreSet(this.set);
		String score = setScore;
		if (gameScore != null && !gameScore.isEmpty()) {
			score = setScore + " , " + gameScore;
		}
		System.out.println(score);
		return score;
	}

	public Set getSet() {
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}

}
