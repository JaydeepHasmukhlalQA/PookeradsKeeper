package com.jay.testModel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestModel {

	Player player;

	@Before
	public void setupBefore() {
		player = new Player();
	}

	@Test
	public void testPlayerHasFullName() {
		String firstname = "Jaydeep";
		String surname = "Hasmukhlal";
		String fullname = firstname + " " + surname;

		player.setFirstname(firstname);
		player.setSurname(surname);

		String retrievedFullName = player.getFirstname() + " " + player.setSurname();

		assertEquals("Wrong players full name", fullname, retrievedFullName);
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

		int retrievedHighestWinStreak = player.getHighestWinStreak();

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

		int retrievedHighestLossStreak = player.getHighestLossStreak();

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

		player.addPlayerFullBalledEnemy();
		player.addPlayerFullBalledEnemy();
		player.addWin();
		player.addPlayerFullBalledEnemy();

		int retrievedFullBalled = player.getPlayerFullBalledEnemy();

		assertEquals(unexpectedResult, expectedFullBalled, retrievedFullBalled);
	}

	@Test
	public void testNumberOfTimesPlayerGotFullBalled() {
		final String unexpectedResult = "Error: Unexpected number of full balled";
		int expectedFullBalled = 2;

		player.addPlayerGotFullBalled();
		player.addPlayerFullBalledEnemy();
		player.addWin();
		player.addPlayerGotFullBalled();

		int retrievedFullBalled = player.getPlayerGotFullBalled();

		assertEquals(unexpectedResult, expectedFullBalled, retrievedFullBalled);
	}

}
