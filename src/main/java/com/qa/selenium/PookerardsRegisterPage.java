package com.qa.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PookerardsRegisterPage {
	
	private static final String REGISTER_PAGE_URL = "http://35.234.137.70:8080/PookeradsKeeper-1.0/register.html";
	private static final int TIMEOUT = 5;
	
	

	@FindBy(xpath = "/html/body/div[3]/div[1]/div/h1")
	private WebElement loginPageHeader;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/h1")
	private WebElement registerPageHeader;
	
	@FindBy(xpath = "//*[@id=\"registerForm\"]/div[1]/input")
	private WebElement usernameInput;
	
	@FindBy(xpath = "//*[@id=\"registerForm\"]/div[2]/input")
	private WebElement firstnameInput;
	
	@FindBy(xpath = "//*[@id=\"registerForm\"]/div[3]/input")
	private WebElement lastnameInput;
	
	@FindBy(xpath = "//*[@id=\"registerForm\"]/button")
	private WebElement registerButton;
	
	@FindBy(xpath = "//*[@id=\"alertMessage\"]")
	private WebElement successAlert;
	
	@FindBy(xpath = "//*[@id=\"infoMessage\"]")
	private WebElement failAlert;
	
	private WebDriver webDriver;
	private WebDriverWait waitDriver;
	
	public PookerardsRegisterPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.waitDriver = new WebDriverWait(webDriver, TIMEOUT);
		PageFactory .initElements(webDriver, this);
	}
	
	private void enterUsername(String username) {
		usernameInput.sendKeys(username);
	}
	
	private void enterFirstname(String firstname) {
		firstnameInput.sendKeys(firstname);
	}
	
	private void enterLastname(String lastname) {
		lastnameInput.sendKeys(lastname);
	}
	
	public void enterDetailsToRegister(String username, String firstname, String lastname) {
		enterUsername(username);
		enterFirstname(firstname);
		enterLastname(lastname);
	}
	
	public void clickRegisterButton() {
		registerButton.click();
	}
	
	public void loadRegisterPage() {
		webDriver.get(REGISTER_PAGE_URL);
	}
	
	public boolean isRegisterPageOpen() {
		return registerPageHeader.getText().contains("Pookerards Register");
	}
	
	public boolean didRegisterSuccessfully() {
		String registerSuccessText = "Successfully registered. Please login.";
		return waitDriver.until(ExpectedConditions.textToBePresentInElement(successAlert, registerSuccessText));
	}
	
	public boolean didFailToRegister() {
		String registerFailText = "Error: Could not create account. Try again.";
		return waitDriver.until(ExpectedConditions.textToBePresentInElement(failAlert, registerFailText));
	}
	
	public boolean redirectedToLoginPage() {
		String loginHeaderText = "Pookerards Login";
		return waitDriver.until(ExpectedConditions.textToBePresentInElement(loginPageHeader, loginHeaderText));
	}
	
}
