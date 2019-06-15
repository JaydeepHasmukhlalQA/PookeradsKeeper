package com.jay.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Player")
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "player_id")
	private int id;
	@NotNull
	@Column(unique = true)
	private String username;
	@NotNull
	private String firstname;
	@NotNull
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
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable
			(
			name = "player_match",
			joinColumns = @JoinColumn(name = "player_id", referencedColumnName = "player_id"),
			inverseJoinColumns = @JoinColumn(name = "match_id", referencedColumnName = "match_id")
			)
	private Set<Match> matches;

	public Player() {
		
	}

	public String getUsername() {
		return username;
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
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getDraws() {
		return draws;
	}

	public void setDraws(int draws) {
		this.draws = draws;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getWinStreaks() {
		return winStreaks;
	}

	public void setWinStreaks(int winStreaks) {
		this.winStreaks = winStreaks;
	}

	public int getWinStreakCounter() {
		return winStreakCounter;
	}

	public void setWinStreakCounter(int winStreakCounter) {
		this.winStreakCounter = winStreakCounter;
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

	public void setLossStreaks(int lossStreaks) {
		this.lossStreaks = lossStreaks;
	}

	public int getLossStreakCounter() {
		return lossStreakCounter;
	}

	public void setLossStreakCounter(int lossStreakCounter) {
		this.lossStreakCounter = lossStreakCounter;
	}

	public int getGotFullBalled() {
		return gotFullBalled;
	}

	public void setGotFullBalled(int gotFullBalled) {
		this.gotFullBalled = gotFullBalled;
	}

	public int getFullBalledEnemy() {
		return fullBalledEnemy;
	}

	public void setFullBalledEnemy(int fullBalledEnemy) {
		this.fullBalledEnemy = fullBalledEnemy;
	}

	public int getId() {
		return id;
	}
	
	public Set<Match> addMatch(Match match) {
		matches.add(match);
		return matches;
	}
	
	public Set<Match> removeMatch(Match match) {
		matches.remove(match);
		return matches;
	}
	

}
