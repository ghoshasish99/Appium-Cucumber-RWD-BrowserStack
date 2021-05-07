package pages;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Login page
 */
public class LoginPage extends BasePage {
	/**
	 * Home Page Icon
	 */
	@FindBy(className =  "login_logo")
	private WebElement HomePageIcon;

	/**
	 * The login button
	 */
	@FindBy(id = "login-button")
	private WebElement loginButton;

	/**
	 * The user name input
	 */
	@FindBy(id = "user-name")
	private WebElement usernameField;

	/**
	 * The password input
	 */
	@FindBy(id = "password")
	private WebElement passwordField;

	/**
	 * Error Message
	 */
	@FindBy(xpath = "//h3[text()='Epic sadface: Sorry, this user has been locked out.']")
	private WebElement errorMessage;

	/**
	 * Menu Icon
	 */
	@FindBy(id = "react-burger-menu-btn")
	private WebElement menuIcon;

	/**
	 * Logout
	 */
	@FindBy(xpath = "//a[text()=\"Logout\"]")
	private WebElement Logout;

	public LoginPage(AppiumDriver<WebElement> driver) {
		super(driver);
	}

	public void login(String username, String password) {

		Assert.assertTrue(HomePageIcon.isDisplayed());
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();

	}

	public void loginFailed() {

		Assert.assertTrue(errorMessage.isDisplayed());

	}

	public void logout() {

		menuIcon.click();
		Logout.click();

	}

	public void logoutSuccessful() {
		Assert.assertTrue(HomePageIcon.isDisplayed());
	}

}
