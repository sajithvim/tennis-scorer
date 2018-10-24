package com.dius.tennisscorer.model;

/**
 * 
 * @author sajith
 * This class simulates the match
 * Restrictions : This only considers single matches
 */
public class Match {
	
	private Set set;
	
	private String player1Name;
	
	private String player2Name;
	
	public Match(String player1, String player2) {
		this.player1Name = player1;
		this.player2Name = player2;
		this.set = new Set();
	}
	
	public void pointWonBy(String player) {
		//TODO
	}
	
	public void score() {
		// TODO
	}

	public Set getSet() {
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}
	
}
