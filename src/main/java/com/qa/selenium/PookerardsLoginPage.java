package com.qa.selenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PookerardsLoginPage {

	private static final String LOGIN_PAGE_URL = "http://35.234.137.70:8080/PookeradsKeeper-1.0/index.html";
	private static final int TIMEOUT = 5;
	
	@FindBy(xpath = "/html/body/div[3]/div[1]/div/h1")
	WebElement loginPageHeader;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/h1")
	private WebElement registerPageHeader;
	
	@FindBy(xpath = "//*[@id=\"loginForm\"]/div/input")
	WebElement usernameInput;
	
	@FindBy(xpath = "//*[@id=\"loginForm\"]/button[1]")
	WebElement loginButton;
	
	@FindBy(xpath = "//*[@id=\"loginForm\"]/button[2]")
	WebElement registerButton;
	
	@FindBy(xpath = "//*[@id=\"usernameLabel\"]")
	WebElement profilePageUsername;
	
	private WebDriver webDriver;
	private WebDriverWait waitDriver;
	
	public PookerardsLoginPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.waitDriver = new WebDriverWait(webDriver, TIMEOUT);
		PageFactory .initElements(webDriver, this);
	}
	
	public void enterUsername(String username) {
		usernameInput.sendKeys(username);
	}
	
	public void pressLoginButton() {
		loginButton.click();
	}
	
	public void loadLoginPage() {
		webDriver.get(LOGIN_PAGE_URL);
	}
	
	public boolean isLoginPageOpen() {
		String loginPageHeaderText = "Pookerards Login";
		return loginPageHeader.getText().contains(loginPageHeaderText);
	}
	
	public boolean redirectedToProfilePage(String profilePageFullnameHeaderText) {
		return waitDriver.until(ExpectedConditions.textToBePresentInElement(profilePageUsername, profilePageFullnameHeaderText));
	}
	
	public boolean redirectedToRegisterPage() {
		String registerPageHeaderText = "Pookerards Register";
		return waitDriver.until(ExpectedConditions.textToBePresentInElement(registerPageHeader, registerPageHeaderText));
	}
	
	
}
