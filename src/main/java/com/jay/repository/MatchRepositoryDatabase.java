package com.jay.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.jay.model.Match;
import com.jay.model.Player;

public class MatchRepositoryDatabase implements MatchRepository {

	@PersistenceContext(unitName = "myPU")
	private EntityManager entityManager;
	
	@Transactional(value = TxType.REQUIRED)
	public Match addMatch(Match match) {
		entityManager.persist(match);
		return match;
	}

	@Transactional(value = TxType.REQUIRED)
	public Match updateMatch(int id, Match updatedMatch) {
		Match match = this.getMatchById(id);
		match.setMatchName(updatedMatch.getMatchName());
		return match;
	}

	public Match getMatchById(int id) {
		Match match = entityManager.find(Match.class, id);
		return match;
	}

	public Match getMatchByName(String matchName) {
		TypedQuery<Match> queryMatchByName = entityManager.createQuery("SELECT match from Match match WHERE match.name = :name", Match.class);
		queryMatchByName.setParameter("name", matchName);
		return queryMatchByName.getSingleResult();
	}
	
	public List<Match> getAllMatches() {
		TypedQuery<Match> queryMatchByName = entityManager.createQuery("SELECT match from Match match", Match.class);
		return queryMatchByName.getResultList();
	}

	@Transactional(value = TxType.REQUIRED)
	public void deleteMatch(int id) {
		entityManager.remove(id);
	}

	public Match updatePlayer(int matchId, Player player) {
		Match match = this.getMatchById(matchId);
		match.addPlayer(player);
		return match;
	}

	public Match removePlayer(int matchId, Player player) {
		Match match = this.getMatchById(matchId);
		match.removePlayer(player);
		return match;
	}
	
}
