package com.jay.model;

public class Player {
	private String username;
	private String firstname;
	private String lastname;
	private int draws;
	private int wins;
	private int winStreaks;
	private int winStreakCounter;
	private int loses;
	private int lossStreaks;
	private int lossStreakCounter;
	private int gotFullBalled;
	private int fullBalledEnemy;

	public Player() {

	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getDraws() {
		return draws;
	}

	public int getWins() {
		return wins;
	}

	public int getWinStreaks() {
		return winStreaks;
	}

	public int getLoses() {
		return loses;
	}

	public void setLoses(int loses) {
		this.loses = loses;
	}

	public int getLossStreaks() {
		return lossStreaks;
	}
	
	public int getFullBalledEnemy() {
		return fullBalledEnemy;
	}

	public int getGotFullBalled() {
		return gotFullBalled;
	}

	public void addWin() {
		this.wins++;
		if (++this.winStreakCounter != 0) {
			this.winStreaks++;
			this.lossStreaks = 0;
			this.lossStreakCounter = 0;
		}
	}

	public void addLoss() {
		this.loses++;
		if (++this.lossStreakCounter != 0) {
			this.lossStreaks++;
			this.winStreaks = 0;
			this.winStreakCounter = 0;
		}
	}

	public void addDraw() { 
		this.draws++;
	}
	
	public void addFullBalledEnemy() {
		this.fullBalledEnemy++;
	}

	public void addGotFullBalled() {
		this.gotFullBalled++;
	}

}
