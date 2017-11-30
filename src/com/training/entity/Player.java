package com.training.entity;

public class Player {

	private long jerseyNumber;
	private String playerName;
	private int matchesPlayed;
	private int wicketTaken;
	private int runsScored;
	private int rating;
	
	public Player() {
		super();
		}

	public Player(long jerseyNumber, String playerName, int matchesPlayed, int wicketTaken, int runsScored,
			int rating) {
		super();
		this.jerseyNumber = jerseyNumber;
		this.playerName = playerName;
		this.matchesPlayed = matchesPlayed;
		this.wicketTaken = wicketTaken;
		this.runsScored = runsScored;
		this.rating = rating;
	}

	public long getJerseyNumber() {
		return jerseyNumber;
	}

	public void setJerseyNumber(long jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getMatchesPlayed() {
		return matchesPlayed;
	}

	public void setMatchesPlayed(int matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}

	public int getWicketTaken() {
		return wicketTaken;
	}

	public void setWicketTaken(int wicketTaken) {
		this.wicketTaken = wicketTaken;
	}

	public int getRunsScored() {
		return runsScored;
	}

	public void setRunsScored(int runsScored) {
		this.runsScored = runsScored;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Player [jerseyNumber=" + jerseyNumber + ", playerName=" + playerName + ", matchesPlayed="
				+ matchesPlayed + ", wicketTaken=" + wicketTaken + ", runsScored=" + runsScored + ", rating=" + rating
				+ "]";
	}
	
	
}
