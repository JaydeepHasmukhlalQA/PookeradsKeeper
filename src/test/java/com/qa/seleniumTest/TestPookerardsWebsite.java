package com.qa.seleniumTest;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.categories.Create;
import com.qa.categories.Fail;
import com.qa.categories.Read;
import com.qa.selenium.PookerardsLoginPage;
import com.qa.selenium.PookerardsRegisterPage;

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
	
	@Category(Create.class)
	@Test
	public void TestRegisterPlayer() {
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
	
	@Category(Fail.class)
	@Test
	public void TestFailToRegisterPlayer() {
		System.out.println("TEST FAIL REGISTER PLAYER");
		String username = "jaydeeph";
		String firstname = "Jaydeep";
		String lastname = "Hasmukhlal";
		String unexpectedResultLoadPage = "Error: Register page not open.";
		String unexpectedResultRegistered = "Error: Player was registered.";
		
		PookerardsRegisterPage registerPage = new PookerardsRegisterPage(webDriver);
		
		registerPage.loadRegisterPage();
		System.out.println("Assert Load Register Page");
		assertTrue(unexpectedResultLoadPage, registerPage.isRegisterPageOpen());
		
		registerPage.enterDetailsToRegister(username, firstname, lastname);
		registerPage.clickRegisterButton();
		
		System.out.println(registerPage.didFailToRegister());
		assertTrue(unexpectedResultRegistered, registerPage.didFailToRegister());
	}
	
	@Category(Read.class)
	@Test
	public void TestLoginPlayer() {
		System.out.println("TEST LOGIN PLAYER");
		String username = "jaydeeph";
		String unexpectedResultLoadPage = "Error: Could not load login page.";
		String unexpectedResultRedirectProfilePage = "Error: Did not redirect to profile page.";
		
		PookerardsLoginPage loginPage = new PookerardsLoginPage(webDriver);
		
		loginPage.loadLoginPage();
		assertTrue(unexpectedResultLoadPage, loginPage.isLoginPageOpen());
		
		loginPage.enterUsername(username);
		loginPage.pressLoginButton();
		
		assertTrue(unexpectedResultRedirectProfilePage, loginPage.redirectedToProfilePage());
		
	}
	
	
}
