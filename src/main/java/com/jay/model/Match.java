package com.jay.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Matchs")
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "match_id")
	private int id;
	private String matchName;
	@ManyToMany(mappedBy = "matches")
	private Set<Player> players;
	
	public Match() {
		
	}

	public String getMatchName() {
		return matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

	public int getId() {
		return id;
	}

	public Set<Player> addPlayer(Player player) {
		players.add(player);
		return players;
	}
	
	public Set<Player> removePlayer(Player player) {
		players.remove(player);
		return players;
	}
}
