package com.qa.repository;

import java.util.List;

import com.qa.model.Player;

public interface PlayerRepository {
	public Player addPlayer(Player player);
	public Player updatePlayer(int id, Player player);
	public Player getPlayerByID(int id);
	public Player getPlayerByName(String username);
	public List<Player> getAllPlayers();
	public void deletePlayer(int id);
	
}
