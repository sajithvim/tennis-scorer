package com.dius.tennisscorer.unittests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.dius.tennisscorer.constants.Status;
import com.dius.tennisscorer.model.Game;
import com.dius.tennisscorer.score.GameScorer;
import com.dius.tennisscorer.score.GenericGameScorer;

public class TestGameScorer {

	private GameScorer scorer;

	@Before
	public void setup() {
		scorer = new GenericGameScorer();
	}

	@Test
	public void testGameRegularScore() {
		// Scenario
		Game game = new Game();
		game.setPlayer1Score(1);
		game.setPlayer2Score(2);
		// Test
		String gameScore = scorer.scoreGame(game);
		// Validation
		assertEquals("15-30", gameScore);
	}

	@Test
	public void testGameDeduce() {
		// Scenario
		Game game = new Game();
		game.setPlayer1Score(3);
		game.setPlayer2Score(3);
		// Test
		String gameScore = scorer.scoreGame(game);
		// Validation
		assertEquals("Deduce", gameScore);
	}

	@Test
	public void testGameAdvantagePlayer2() {
		// Scenario
		Game game = new Game();
		game.setPlayer1Score(3);
		game.setPlayer2Score(4);
		// Test
		String gameScore = scorer.scoreGame(game);
		// Validation
		assertEquals("Advantage player 2", gameScore);

	}

	@Test
	public void testGameAdvantagePlayer1() {
		// Scenario
		Game game = new Game();
		game.setPlayer1Score(4);
		game.setPlayer2Score(3);
		// Test
		String gameScore = scorer.scoreGame(game);
		// Validation
		assertEquals("Advantage player 1", gameScore);

	}

	@Test
	public void testGameAdvantagePlayer1ContinuedGame() {
		// Scenario
		Game game = new Game();
		game.setPlayer1Score(6);
		game.setPlayer2Score(5);
		// Test
		String gameScore = scorer.scoreGame(game);
		// Validation
		assertEquals("Advantage player 1", gameScore);

	}

	@Test
	public void testGameWinPlayer1() {
		// Scenario
		Game game = new Game();
		game.setPlayer1Score(4);
		game.setPlayer2Score(2);
		// Test
		String gameScore = scorer.scoreGame(game);
		// Validation
		assertEquals("WON", gameScore);
		assertEquals("player1", game.getWinner());
		assertEquals(Status.WON, game.getGameStatus());
	}

	@Test
	public void testGameWinPlayer1Edge() {
		// Scenario
		Game game = new Game();
		game.setPlayer1Score(7);
		game.setPlayer2Score(5);
		// Test
		String gameScore = scorer.scoreGame(game);
		// Validation
		assertEquals("WON", gameScore);
		assertEquals("player1", game.getWinner());
		assertEquals(Status.WON, game.getGameStatus());
	}

	@Test
	public void testGameWinPlayer2() {
		// Scenario
		Game game = new Game();
		game.setPlayer1Score(3);
		game.setPlayer2Score(5);
		// Test
		String gameScore = scorer.scoreGame(game);
		// Validation
		assertEquals("WON", gameScore);
		assertEquals("player2", game.getWinner());
		assertEquals(Status.WON, game.getGameStatus());
	}

}
