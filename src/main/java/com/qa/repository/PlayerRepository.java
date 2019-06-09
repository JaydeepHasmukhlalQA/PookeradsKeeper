package com.qa.repository;

import java.util.List;

import com.jay.model.Player;

public interface PlayerRepository {
	public Player createPlayer(Player player);
	public Player updatePlayer(String username, Player player);
	public Player getPlayer(String username);
	public List<Player> getAllPlayers();
	public void deletePlayer(String username);
	
}
