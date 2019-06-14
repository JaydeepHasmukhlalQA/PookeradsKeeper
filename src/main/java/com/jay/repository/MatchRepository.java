package com.jay.repository;

import java.util.List;

import com.jay.model.Match;

public interface MatchRepository {
	public Match addMatch(Match match);
	public Match updateMatch(int id, Match match);
	public Match getMatchById(int id);
	public Match getMatchByName(String matchName);
	public List<Match> getAllMatches();
	public void deleteMatch(int id);
}
