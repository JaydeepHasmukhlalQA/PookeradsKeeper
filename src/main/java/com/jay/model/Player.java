package com.jay.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.UniqueConstraint;

@Entity
//@Table(name="EMPLOYEE", uniqueConstraints= @UniqueConstraint(columnNames={"id", "username"}))
public class Player {
	@Id
	@GeneratedValue
	private int id;
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
		this.winStreakCounter++;
		if (this.winStreakCounter > this.winStreaks) {
			this.winStreaks++;
			this.lossStreakCounter = 0;
		}
	}

	public void addLoss() {
		this.loses++;
		this.lossStreakCounter++;
		if (this.lossStreakCounter > this.lossStreaks) {
			this.lossStreaks++;
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
