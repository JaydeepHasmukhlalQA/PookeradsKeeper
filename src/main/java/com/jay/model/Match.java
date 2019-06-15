package com.jay.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Matchs")
public class Match {

	@Id
	@GeneratedValue
	@Column(name = "match_id")
	private int id;
	private String matchName;
	@ManyToMany(mappedBy = "matches")
	private Set<Player> players;
	
	public Match() {
		
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return matchName;
	}

	public void setName(String name) {
		this.matchName = name;
	}

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
}
