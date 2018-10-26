package com.dius.tennisscorer.integration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.dius.tennisscorer.model.Match;

public class TestMatch {

	@Test
	public void testMatchGameLeadScenario() {
		Match match = new Match("player 1", "player 2");
		match.pointWonBy("player 1");
		match.pointWonBy("player 2");
		String score = match.score();
		assertEquals("0-0 , 15-15", score);

		match.pointWonBy("player 1");
		match.pointWonBy("player 1");
		score = match.score();
		assertEquals("0-0 , 40-15", score);

		match.pointWonBy("player 2");
		match.pointWonBy("player 2");
		score = match.score();
		assertEquals("0-0 , Deduce", score);

		match.pointWonBy("player 1");
		score = match.score();
		assertEquals("0-0 , Advantage player 1", score);

		match.pointWonBy("player 1");
		score = match.score();
		assertEquals("1-0", score);

	}

}
