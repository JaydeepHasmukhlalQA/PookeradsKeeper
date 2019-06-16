package com.qa.testModel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.qa.model.Player;

public class TestModel {

	Player player;

	@Before
	public void setupBefore() {
		player = new Player();
	}

	@Test
	public void testPlayerHasFullName() {
		final String unexpectedResult = "Wrong players full name";
		String firstname = "Jaydeep";
		String surname = "Hasmukhlal";
		String fullname = firstname + " " + surname;

		player.setFirstname(firstname);
		player.setLastname(surname);
		String retrievedFullName = player.getFirstname() + " " + player.getLastname();

		assertEquals(unexpectedResult, fullname, retrievedFullName);
	}

	@Test
	public void testPlayerAddWinAndHighestWinStreak() {
		final String unexpectedResult = "Error: Unexpected highest win streak.";
		int expectedHighestStreak = 3;

		player.setWinStreaks(expectedHighestStreak);
		int retrievedHighestWinStreak = player.getWinStreaks();

		assertEquals(unexpectedResult, expectedHighestStreak, retrievedHighestWinStreak);
	}

	@Test
	public void testAddLossAndHighestLossStreak() {
		final String unexpectedResult = "Error: Unexpected highest loss streak.";
		int expectedHighestLossStreak = 2;

		player.setLossStreaks(expectedHighestLossStreak);
		int retrievedHighestLossStreak = player.getLossStreaks();
		
		assertEquals(unexpectedResult, expectedHighestLossStreak, retrievedHighestLossStreak);
	}

	@Test
	public void testPlayerDraws() {
		final String unexpectedResult = "Error: Unexpected number of draws.";
		int expectedDraw = 4;

		player.setDraws(expectedDraw);

		int retrievedDraw = player.getDraws();
		assertEquals(unexpectedResult, expectedDraw, retrievedDraw);
	}

	@Test
	public void testNumberOfTimesPlayerFullBalledEnemy() {
		final String unexpectedResult = "Error: Unexpected number of full balled";
		int expectedFullBalled = 3;

		player.setFullBalledEnemy(expectedFullBalled);
		int retrievedFullBalled = player.getFullBalledEnemy();

		assertEquals(unexpectedResult, expectedFullBalled, retrievedFullBalled);
	}

	@Test
	public void testNumberOfTimesPlayerGotFullBalled() {
		final String unexpectedResult = "Error: Unexpected number of full balled";
		int expectedFullBalled = 2;

		player.setGotFullBalled(expectedFullBalled);
		int retrievedFullBalled = player.getGotFullBalled();

		assertEquals(unexpectedResult, expectedFullBalled, retrievedFullBalled);
	}
	
	@Test
	public void testPlayerUsername() {
		final String unexpectedResult = "Error: Unexpected username.";
		String expectedUsername = "jaydeeph";
		player.setUsername(expectedUsername);
		String retrievedUsername = player.getUsername();
		
		assertEquals(unexpectedResult, expectedUsername, retrievedUsername);
	}

}
