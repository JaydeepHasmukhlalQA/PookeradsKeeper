package com.jay.testModel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.jay.model.Player;

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

		player.addWin();
		player.addWin();
		player.addWin();
		player.addLoss();
		player.addWin();

		int retrievedHighestWinStreak = player.getWinStreaks();

		assertEquals(unexpectedResult, expectedHighestStreak, retrievedHighestWinStreak);
	}

	@Test
	public void testAddLossAndHighestLossStreak() {
		final String unexpectedResult = "Error: Unexpected highest loss streak.";
		int expectedHighestLossStreak = 2;

		player.addLoss();
		player.addLoss();
		player.addWin();
		player.addLoss();

		int retrievedHighestLossStreak = player.getLossStreaks();
		System.out.println("retrievedHighestLossStreak" + retrievedHighestLossStreak);

		assertEquals(unexpectedResult, expectedHighestLossStreak, retrievedHighestLossStreak);
	}

	@Test
	public void testPlayerDraws() {
		final String unexpectedResult = "Error: Unexpected number of draws.";
		int expectedDraw = 4;

		player.addDraw();
		player.addDraw();
		player.addDraw();
		player.addDraw();

		int retrievedDraw = player.getDraws();

		assertEquals(unexpectedResult, expectedDraw, retrievedDraw);
	}

	@Test
	public void testNumberOfTimesPlayerFullBalledEnemy() {
		final String unexpectedResult = "Error: Unexpected number of full balled";
		int expectedFullBalled = 3;

		player.addFullBalledEnemy();
		player.addFullBalledEnemy();
		player.addWin();
		player.addFullBalledEnemy();

		int retrievedFullBalled = player.getFullBalledEnemy();

		assertEquals(unexpectedResult, expectedFullBalled, retrievedFullBalled);
	}

	@Test
	public void testNumberOfTimesPlayerGotFullBalled() {
		final String unexpectedResult = "Error: Unexpected number of full balled";
		int expectedFullBalled = 2;

		player.addGotFullBalled();
		player.addFullBalledEnemy();
		player.addWin();
		player.addGotFullBalled();

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
