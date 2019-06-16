package com.qa.selenium;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.selenium.PookerardsLoginPage;
import com.qa.selenium.PookerardsProfilePage;
import com.qa.selenium.PookerardsRegisterPage;

@FixMethodOrder (MethodSorters.JVM)
public class TestPookerardsWebsite {

	WebDriver webDriver;
	
	@Before
	public void beforeSetup() {
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		webDriver = new ChromeDriver();
	}
	
	@After
	public void afterTeardown() {
		webDriver.quit();
	}
	
	@Test
	public void testRegisterPlayer() {
		System.out.println("TEST REGISTER PLAYER");
		String username = "jaydeeph";
		String firstname = "Jaydeep";
		String lastname = "Hasmukhlal";
		String unexpectedResultLoadPage = "Error: Register page not open.";
		String unexpectedResultRegister = "Error: Did not register.";
		String unexpectedResultRedirect = "Error: Did not re-direct to login page.";
		
		PookerardsRegisterPage registerPage = new PookerardsRegisterPage(webDriver);
		
		registerPage.loadRegisterPage();
		assertTrue(unexpectedResultLoadPage, registerPage.isRegisterPageOpen());
		
		registerPage.enterDetailsToRegister(username, firstname, lastname);
		registerPage.clickRegisterButton();
		
		assertTrue(unexpectedResultRegister, registerPage.didRegisterSuccessfully());
		assertTrue(unexpectedResultRedirect, registerPage.redirectedToLoginPage());
	}
	
	@Test
	public void testFailToRegisterPlayer() {
		System.out.println("TEST FAIL REGISTER PLAYER");
		String username = "jaydeeph";
		String firstname = "Jaydeep";
		String lastname = "Hasmukhlal";
		String unexpectedResultLoadPage = "Error: Register page not open.";
		String unexpectedResultRegistered = "Error: Player was registered.";
		
		PookerardsRegisterPage registerPage = new PookerardsRegisterPage(webDriver);
		
		registerPage.loadRegisterPage();
		assertTrue(unexpectedResultLoadPage, registerPage.isRegisterPageOpen());
		
		registerPage.enterDetailsToRegister(username, firstname, lastname);
		registerPage.clickRegisterButton();
		
		assertTrue(unexpectedResultRegistered, registerPage.didFailToRegister());
	}
	
	@Test
	public void testLoginPlayer() {
		System.out.println("TEST LOGIN PLAYER");
		String username = "jaydeeph";
		String unexpectedResultLoadPage = "Error: Could not load login page.";
		String unexpectedResultRedirectProfilePage = "Error: Did not redirect to profile page.";
		
		PookerardsLoginPage loginPage = new PookerardsLoginPage(webDriver);
		
		loginPage.loadLoginPage();
		assertTrue(unexpectedResultLoadPage, loginPage.isLoginPageOpen());
		
		loginPage.enterUsername(username);
		loginPage.pressLoginButton();
		
		assertTrue(unexpectedResultRedirectProfilePage, loginPage.redirectedToProfilePage(username));
		
	}
	
	@Test
	public void testUpdatePlayerDetails() {
		System.out.println("TEST UPDATE DETAILS");
		
		String username = "jaydeeph";
		String unexpectedResultLoadLoginPage = "Error: Could not load login page.";
		String unexpectedResultRedirectProfilePage = "Error: Did not redirect to profile page.";
		
		PookerardsLoginPage loginPage = new PookerardsLoginPage(webDriver);
		
		loginPage.loadLoginPage();
		assertTrue(unexpectedResultLoadLoginPage, loginPage.isLoginPageOpen());
		
		loginPage.enterUsername(username);
		loginPage.pressLoginButton();
		
		assertTrue(unexpectedResultRedirectProfilePage, loginPage.redirectedToProfilePage(username));
		

		String firstname = "Allan";
		String lastname = "Charles";
		String unexpectedResultLoadProfilePage = "Error: Could not load profile page";
		String unexpectedResultUpdate = "Error: Could not update account.";
		
		PookerardsProfilePage profilePage = new PookerardsProfilePage(webDriver);
		
		profilePage.loadPlayerProfilePage();
		assertTrue(unexpectedResultLoadProfilePage, profilePage.isPlayerProfilePageOpen());
		
		profilePage.clickUpdateDetailsButton();
		profilePage.enterFirstname(firstname);
		profilePage.enterLastname(lastname);
		profilePage.clickUpdateDetailsButton();
		
		assertTrue(unexpectedResultUpdate, profilePage.didSuccessfullyUpdateAccount(firstname));
	}
	
	@Test
	public void testCancelDeletePlayerAccount() {
		System.out.println("TEST DELETE PLAYER ACCOUNT");
		
		String username = "jaydeeph";
		String unexpectedResultLoadLoginPage = "Error: Could not load login page.";
		String unexpectedResultRedirectProfilePage = "Error: Did not redirect to profile page.";
		
		PookerardsLoginPage loginPage = new PookerardsLoginPage(webDriver);
		
		loginPage.loadLoginPage();
		assertTrue(unexpectedResultLoadLoginPage, loginPage.isLoginPageOpen());
		
		loginPage.enterUsername(username);
		loginPage.pressLoginButton();
		
		assertTrue(unexpectedResultRedirectProfilePage, loginPage.redirectedToProfilePage(username));
	
		
		String unexpectedResultLoadProfilePage = "Error: Could not load profile page";
		String unexpectedResultDeletedAccount = "Error: Deleted account.";
		
		PookerardsProfilePage profilePage = new PookerardsProfilePage(webDriver);
		
		profilePage.loadPlayerProfilePage();
		assertTrue(unexpectedResultLoadProfilePage, profilePage.isPlayerProfilePageOpen());
		
		profilePage.clickEditDetailsButton();
		profilePage.clickDeleteDetailsButton();
		profilePage.clickNoIMadeAMistakeButton();
		
		assertTrue(unexpectedResultDeletedAccount, profilePage.isPlayerProfilePageOpen());
	}
	
	@Test
	public void testDeletePlayerAccount() {
		System.out.println("TEST DELETE PLAYER ACCOUNT");
		
		String username = "jaydeeph";
		String firstname = "Allan";
		String unexpectedResultLoadLoginPage = "Error: Could not load login page.";
		String unexpectedResultRedirectProfilePage = "Error: Did not redirect to profile page.";
		
		PookerardsLoginPage loginPage = new PookerardsLoginPage(webDriver);
		
		loginPage.loadLoginPage();
		assertTrue(unexpectedResultLoadLoginPage, loginPage.isLoginPageOpen());
		
		loginPage.enterUsername(username);
		loginPage.pressLoginButton();
		
		assertTrue(unexpectedResultRedirectProfilePage, loginPage.redirectedToProfilePage(username));
	
		
		String unexpectedResultLoadProfilePage = "Error: Could not load profile page";
		String unexpectedResultDeleteAccount = "Error: Could not delete account.";
		
		PookerardsProfilePage profilePage = new PookerardsProfilePage(webDriver);
		
		profilePage.loadPlayerProfilePage();
		assertTrue(unexpectedResultLoadProfilePage, profilePage.isPlayerProfilePageOpen());
		
		profilePage.clickEditDetailsButton();
		profilePage.clickDeleteDetailsButton();
		profilePage.clickPleaseDeleteMyAccountButton();
		
		assertTrue(unexpectedResultDeleteAccount, profilePage.didSuccessfullyDeleteAccount(firstname));
	}
	
	
	
	
}
