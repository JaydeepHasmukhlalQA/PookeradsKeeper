package com.qa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jay.model.Player;

public class PlayerRepositoryDatabase implements PlayerRepository {

	private EntityManager entityManager;
	
	public Player createPlayer(Player player) {
		entityManager.persist(player);
		return player;
	}

	public Player updatePlayer(String username, Player updatedPlayer) {
		Player player = getPlayer(username);
		player = updatedPlayer;
		return player;
	}

	public Player getPlayer(String username) {
		Player player = entityManager.find(Player.class, username);
		return player;
	}

	public List<Player> getAllPlayers() {
		TypedQuery<Player> queryPlayer = entityManager.createQuery("Select player from Player player;", Player.class);
		List<Player> listOfPlayers = queryPlayer.getResultList();
		return listOfPlayers;
	}

	public void deletePlayer(String username) {
		entityManager.remove(username);
	}
	
}
