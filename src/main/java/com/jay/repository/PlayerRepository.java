package com.jay.repository;

import java.util.List;

import com.jay.model.Player;

public interface PlayerRepository {
	public Player addPlayer(Player player);
	public Player updatePlayer(int id, Player player);
	public Player getPlayerByID(int id);
	public Player getPlayerByName(String username);
	public List<Player> getAllPlayers();
	public void deletePlayer(int id);
	
}
