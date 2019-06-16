package com.qa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.model.Player;

@Transactional(value = TxType.SUPPORTS)
public class PlayerRepositoryDatabase implements PlayerRepository {

	@PersistenceContext(unitName = "myPU")
	private EntityManager entityManager;
	
	@Transactional(value = TxType.REQUIRED)
	public Player addPlayer(Player player) {
		entityManager.persist(player);
		return player;
	}

	@Transactional(value = TxType.REQUIRED)
	public Player updatePlayer(int id, Player updatedPlayer) {
		Player player = this.getPlayerByID(id);
		player.setFirstname(updatedPlayer.getFirstname());
		player.setLastname(updatedPlayer.getLastname());
		player.setWins(updatedPlayer.getWins());
		player.setWinStreaks(updatedPlayer.getWinStreaks());
		player.setWinStreakCounter(updatedPlayer.getWinStreakCounter());
		player.setLoses(updatedPlayer.getLoses());
		player.setLossStreaks(updatedPlayer.getLossStreaks());
		player.setLossStreakCounter(updatedPlayer.getLossStreakCounter());
		player.setDraws(updatedPlayer.getDraws());
		player.setFullBalledEnemy(updatedPlayer.getFullBalledEnemy());
		player.setGotFullBalled(updatedPlayer.getGotFullBalled());
		return player;
	}
	
	
	public Player getPlayerByID(int id) {
		Player player = entityManager.find(Player.class, id);
		return player;
	}

	public Player getPlayerByName(String username) {
		TypedQuery<Player> queryPlayerByUsername = entityManager.createQuery("Select player from Player player Where player.username = :username", Player.class);
		queryPlayerByUsername.setParameter("username", username);
		return queryPlayerByUsername.getSingleResult();
	}

	public List<Player> getAllPlayers() {
		TypedQuery<Player> queryPlayer = entityManager.createQuery("Select player from Player player", Player.class);
		List<Player> listOfPlayers = queryPlayer.getResultList();
		return listOfPlayers;
	}

	@Transactional(value = TxType.REQUIRED)
	public void deletePlayer(int id) {
		entityManager.remove(getPlayerByID(id));
	}
	
}
