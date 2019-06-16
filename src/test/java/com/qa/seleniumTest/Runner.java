package com.qa.seleniumTest;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.selenium.PookerardsRegisterPage;

public class Runner {

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
	public void TestRegisterPlayer() {
		String username = "jaydeeph";
		String firstname = "Jaydeep";
		String lastname = "Hasmukhlal";
		
		PookerardsRegisterPage registerPage = new PookerardsRegisterPage(webDriver);
		
		registerPage.loadRegisterPage();
		
		assertTrue("Error: Register page not open.", registerPage.isRegisterPageOpen());
		
		registerPage.enterDetailsToRegister(username, firstname, lastname);
		registerPage.clickRegisterButton();
		
		assertTrue("Error: Did not register.", registerPage.didRegisterSuccessfully());
		assertTrue("Error: Did not re-direct to login page.", registerPage.redirectedToLoginPage());
		
	}
	
	
}
