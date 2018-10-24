package com.dius.tennisscorer.unittests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.dius.tennisscorer.constants.Status;
import com.dius.tennisscorer.model.Game;
import com.dius.tennisscorer.model.Set;
import com.dius.tennisscorer.score.GenericSetScorer;
import com.dius.tennisscorer.score.SetScorer;

public class TestSetScorer {

	private SetScorer setScorer;

	@Before
	public void setup() {
		this.setScorer = new GenericSetScorer("player 1 ", "player 2");
	}

	@Test
	public void testSetScore() {
		// Data
		Set set = new Set();
		Game game1 = new Game();
		game1.setGameStatus(Status.WON);
		game1.setWinner("player1");

		Game game2 = new Game();
		game2.setGameStatus(Status.WON);
		game2.setWinner("player2");

		Game game3 = new Game();
		game3.setGameStatus(Status.WON);
		game3.setWinner("player1");

		set.getFinishedGames().add(game1);
		set.getFinishedGames().add(game2);
		set.getFinishedGames().add(game3);

		String setScore = setScorer.scoreSet(set);
		assertEquals("2-1", setScore);

	}

	@Test
	public void testSetScoreWonPlayer1() {
		// Data
		Set set = new Set();
		Game game1 = new Game();
		game1.setGameStatus(Status.WON);
		game1.setWinner("player1");

		Game game2 = new Game();
		game2.setGameStatus(Status.WON);
		game2.setWinner("player1");

		Game game3 = new Game();
		game3.setGameStatus(Status.WON);
		game3.setWinner("player1");

		Game game4 = new Game();
		game4.setGameStatus(Status.WON);
		game4.setWinner("player1");

		Game game5 = new Game();
		game5.setGameStatus(Status.WON);
		game5.setWinner("player1");

		Game game6 = new Game();
		game6.setGameStatus(Status.WON);
		game6.setWinner("player1");

		Game game7 = new Game();
		game7.setGameStatus(Status.WON);
		game7.setWinner("player2");

		set.getFinishedGames().add(game1);
		set.getFinishedGames().add(game2);
		set.getFinishedGames().add(game3);
		set.getFinishedGames().add(game4);
		set.getFinishedGames().add(game5);
		set.getFinishedGames().add(game6);
		set.getFinishedGames().add(game7);

		// Scenario
		String setScore = setScorer.scoreSet(set);
		// Validation
		assertEquals("Player1 - WON", setScore);

	}

	@Test
	public void testTieBreakUnresolved() {
		// Data
		Set set = new Set();
		Game game1 = new Game();
		game1.setGameStatus(Status.WON);
		game1.setWinner("player1");

		Game game2 = new Game();
		game2.setGameStatus(Status.WON);
		game2.setWinner("player1");

		Game game3 = new Game();
		game3.setGameStatus(Status.WON);
		game3.setWinner("player1");

		Game game4 = new Game();
		game4.setGameStatus(Status.WON);
		game4.setWinner("player1");

		Game game5 = new Game();
		game5.setGameStatus(Status.WON);
		game5.setWinner("player1");

		Game game6 = new Game();
		game6.setGameStatus(Status.WON);
		game6.setWinner("player1");

		Game game7 = new Game();
		game7.setGameStatus(Status.WON);
		game7.setWinner("player2");

		Game game8 = new Game();
		game8.setGameStatus(Status.WON);
		game8.setWinner("player2");

		Game game9 = new Game();
		game9.setGameStatus(Status.WON);
		game9.setWinner("player2");

		Game game10 = new Game();
		game10.setGameStatus(Status.WON);
		game10.setWinner("player2");

		Game game11 = new Game();
		game11.setGameStatus(Status.WON);
		game11.setWinner("player2");

		set.getFinishedGames().add(game1);
		set.getFinishedGames().add(game2);
		set.getFinishedGames().add(game3);
		set.getFinishedGames().add(game4);
		set.getFinishedGames().add(game5);
		set.getFinishedGames().add(game6);
		set.getFinishedGames().add(game7);
		set.getFinishedGames().add(game8);
		set.getFinishedGames().add(game9);
		set.getFinishedGames().add(game10);
		set.getFinishedGames().add(game11);

		// Scenario
		String setScore = setScorer.scoreSet(set);
		// Validation
		assertEquals("6-5-(Tie Break)", setScore);
	}

	@Test
	public void testTieBreakResolved() {
		// Data
		Set set = new Set();
		Game game1 = new Game();
		game1.setGameStatus(Status.WON);
		game1.setWinner("player1");

		Game game2 = new Game();
		game2.setGameStatus(Status.WON);
		game2.setWinner("player1");

		Game game3 = new Game();
		game3.setGameStatus(Status.WON);
		game3.setWinner("player1");

		Game game4 = new Game();
		game4.setGameStatus(Status.WON);
		game4.setWinner("player1");

		Game game5 = new Game();
		game5.setGameStatus(Status.WON);
		game5.setWinner("player1");

		Game game6 = new Game();
		game6.setGameStatus(Status.WON);
		game6.setWinner("player1");

		Game game7 = new Game();
		game7.setGameStatus(Status.WON);
		game7.setWinner("player2");

		Game game8 = new Game();
		game8.setGameStatus(Status.WON);
		game8.setWinner("player2");

		Game game9 = new Game();
		game9.setGameStatus(Status.WON);
		game9.setWinner("player2");

		Game game10 = new Game();
		game10.setGameStatus(Status.WON);
		game10.setWinner("player2");

		Game game11 = new Game();
		game11.setGameStatus(Status.WON);
		game11.setWinner("player2");

		Game currentGame = new Game();
		currentGame.setPlayer1Score(7);
		currentGame.setPlayer2Score(5);

		set.getFinishedGames().add(game1);
		set.getFinishedGames().add(game2);
		set.getFinishedGames().add(game3);
		set.getFinishedGames().add(game4);
		set.getFinishedGames().add(game5);
		set.getFinishedGames().add(game6);
		set.getFinishedGames().add(game7);
		set.getFinishedGames().add(game8);
		set.getFinishedGames().add(game9);
		set.getFinishedGames().add(game10);
		set.getFinishedGames().add(game11);

		set.setCurrentGame(currentGame);

		// Scenario
		String setScore = setScorer.scoreSet(set);
		// Validation
		assertEquals("Player1 - WON", setScore);
	}

}
