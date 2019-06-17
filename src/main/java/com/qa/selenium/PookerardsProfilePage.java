package com.qa.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PookerardsProfilePage {
	private static final String LOGIN_PAGE_URL = "http://35.234.137.70:8080/PookeradsKeeper-1.0/playerprofile.html";
	private static final int TIMEOUT = 5;
	
	@FindBy(xpath = "/html/body/div[3]/div[1]/div/h1")
	private WebElement loginPageHeader;
	
	@FindBy(xpath = "//*[@id=\"playerProfileContainer\"]/div[1]/div/span/img")
	private WebElement playerProfileImage;
	
	@FindBy(xpath = "//*[@id=\"firstnameInput\"]")
	private WebElement firstnameInput;
	
	@FindBy(xpath = "//*[@id=\"lastnameInput\"]")
	private WebElement lastnameInput;
	
	@FindBy(xpath = "//*[@id=\"winsLabel\"]")
	private WebElement winsLabel;
	
	@FindBy(xpath = "//*[@id=\"lossesLabel\"]")
	private WebElement lossLabel;
	
	@FindBy(xpath = "//*[@id=\"addWinButton\"]")
	private WebElement addWinButton;
	
	@FindBy(xpath = "//*[@id=\"addLossButton\"]")
	private WebElement addLossButton;

	@FindBy(xpath = "//*[@id=\"updateDetailsButton\"]")
	private WebElement editUpdateButton;
	
	@FindBy(xpath = "//*[@id=\"deleteMeButton\"]")
	private WebElement deleteButton;
	
	@FindBy(xpath = "//*[@id=\"confirmDelete\"]/div/div/div[3]/button[2]")
	private WebElement pleaseDeleteMyAccountButton;
	
	@FindBy(xpath = "//*[@id=\"confirmDelete\"]/div/div/div[3]/button[1]")
	private WebElement noIMadeAMistakeButton;
	
	@FindBy(xpath = "//*[@id=\"alertMessage\"]")
	private WebElement successAlert;
	
	@FindBy(xpath = "//*[@id=\"alertMessage\"]")
	private WebElement failAlert;
	
	private WebDriver webDriver;
	private WebDriverWait waitDriver;
	
	public PookerardsProfilePage(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.waitDriver = new WebDriverWait(webDriver, TIMEOUT);
		PageFactory .initElements(webDriver, this);
	}
	
	public void loadPlayerProfilePage() {
		webDriver.get(LOGIN_PAGE_URL);
	}
	
	public void enterFirstname(String firstname) {
		firstnameInput.clear();
		firstnameInput.sendKeys(firstname);
	}
	
	public void enterLastname(String lastname) {
		lastnameInput.clear();
		lastnameInput.sendKeys(lastname);
	}
	
	public void clickEditDetailsButton() {
		editUpdateButton.click();
	}
	
	public void clickAddWinButton() {
		addWinButton.click();
	}
	
	public void clickAddLossButton() {
		addLossButton.click();
	}
	
	public void clickUpdateDetailsButton() {
		editUpdateButton.click();
	}
	
	public void clickDeleteDetailsButton() {
		deleteButton.click();
	}
	
	public void clickPleaseDeleteMyAccountButton() {
		WebElement foundPleaseDeleteMyAccountButton = waitDriver.until(ExpectedConditions.visibilityOf(pleaseDeleteMyAccountButton));
		foundPleaseDeleteMyAccountButton.click();
	}
	
	public void clickNoIMadeAMistakeButton() {
		WebElement foundNoIMadeAMistakeButton = waitDriver.until((ExpectedConditions.visibilityOf(noIMadeAMistakeButton)));
		foundNoIMadeAMistakeButton.click();
	}
	
	public boolean isPlayerProfilePageOpen() {
		WebElement foundPlayerProfileName = waitDriver.until(ExpectedConditions.visibilityOf(playerProfileImage));
		return foundPlayerProfileName.isDisplayed();
	}
	
	public boolean didSuccessfullyAddWins(String wins) {
		return waitDriver.until(ExpectedConditions.textToBePresentInElement(winsLabel, wins));
	}
	
	public boolean didSuccessfullyAddLoss(String loss) {
		return waitDriver.until(ExpectedConditions.textToBePresentInElement(lossLabel, loss));
	}
	
	public boolean didSuccessfullyUpdateAccount(String firstname) {
		String updateSuccessText = "Successfully updated " + firstname + "'s account.";
		return waitDriver.until(ExpectedConditions.textToBePresentInElement(successAlert, updateSuccessText));
	}
	
	public boolean didFailToUpdateAccount() {
		String failUpdateText = "Error: Could not update account. Please try again later.";
		return waitDriver.until(ExpectedConditions.textToBePresentInElement(failAlert, failUpdateText));
	}
	
	public boolean didSuccessfullyDeleteAccount(String firstname) {
		String deleteSuccessText = "Successfully deleted " + firstname + "'s account.";
		return waitDriver.until(ExpectedConditions.textToBePresentInElement(failAlert, deleteSuccessText));
	}
	
	public boolean didFailToDeleteAccount() {
		String failDeletText = "Error: Could not delete account. Please try again later.";
		return waitDriver.until(ExpectedConditions.textToBePresentInElement(failAlert, failDeletText));
	}
	
	public boolean redirectedToLoginPage() {
		String loginHeaderText = "Pookerards Login";
		return waitDriver.until(ExpectedConditions.textToBePresentInElement(loginPageHeader, loginHeaderText));
	}
	
}
