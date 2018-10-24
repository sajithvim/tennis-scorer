package com.dius.tennisscorer.unittests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.dius.tennisscorer.constants.Status;
import com.dius.tennisscorer.errors.TennisScorerException;
import com.dius.tennisscorer.model.Game;
import com.dius.tennisscorer.model.Set;

public class TestModel {

	@Test(expected = TennisScorerException.class)
	public void testAddingNewPointToWonSet() throws TennisScorerException {
		// Set variables
		Set set = new Set();
		set.setSetStatus(Status.WON);

		// Scenario
		set.pointsWonBy("player1");
	}

	@Test
	public void testAddingNewPointToPlayer() throws TennisScorerException {
		// Set variables
		Set set = new Set();

		// Scenario
		set.pointsWonBy("player1");
		assertEquals(15, set.getCurrentGame().getPlayer1Score());
		assertEquals(0, set.getCurrentGame().getPlayer2Score());
	}

	@Test
	public void testAddingNewPointToPlayerWith15Points() throws TennisScorerException {
		// Set variables
		Set set = new Set();
		Game game = new Game();
		game.setPlayer1Score(15);
		set.setCurrentGame(game);

		// Scenario
		set.pointsWonBy("player1");
		assertEquals(30, set.getCurrentGame().getPlayer1Score());
		assertEquals(0, set.getCurrentGame().getPlayer2Score());
	}

	@Test
	public void testAddingNewPointToPlayerWith40Points() throws TennisScorerException {
		// Set variables
		Set set = new Set();
		Game game = new Game();
		game.setPlayer1Score(40);
		set.setCurrentGame(game);

		// Scenario
		set.pointsWonBy("player1");
		assertEquals(4, set.getCurrentGame().getPlayer1Score());
		assertEquals(0, set.getCurrentGame().getPlayer2Score());
	}

	@Test
	public void testAddingNewPointToPlayerWithMoreThan4Points() throws TennisScorerException {
		// Set variables
		Set set = new Set();
		Game game = new Game();
		game.setPlayer1Score(4);
		set.setCurrentGame(game);

		// Scenario
		set.pointsWonBy("player1");
		assertEquals(5, set.getCurrentGame().getPlayer1Score());
		assertEquals(0, set.getCurrentGame().getPlayer2Score());
	}

}
