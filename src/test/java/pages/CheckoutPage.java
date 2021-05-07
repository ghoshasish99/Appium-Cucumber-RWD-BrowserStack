package pages;


import io.appium.java_client.AppiumDriver;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Checkout page
 */
public class CheckoutPage extends BasePage {

    /**
     * First Name
     */
    @FindBy(id = "first-name")
    private WebElement FirstName;
    
    /**
     * Last Name
     */
    @FindBy(id = "last-name")
    private WebElement LastName;

    /**
     * Postal Code
     */
    @FindBy(id = "postal-code")
    private WebElement PostalCode;

    /**
     * Continue Button
     */
    @FindBy(id = "continue")
    private WebElement Continue;
    
    /**
     * Finish Button
     */
    @FindBy(id = "finish")
    private WebElement Finish;
    
    /**
     * Success Message
     */
    @FindBy(xpath = "//h2[text()='THANK YOU FOR YOUR ORDER']")
    private WebElement successMessage;

    
    public CheckoutPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

 
    public void fillCheckoutDetails(String firstname, String lastname, String postcode) {
        
    	FirstName.sendKeys(firstname);
    	LastName.sendKeys(lastname);
    	PostalCode.sendKeys(postcode);
    
    }
    
    public void completeCheckout() {
    	Continue.click();
    	Finish.click();
    }

    public void checkoutSuccessful() {
        Assert.assertTrue(successMessage.isDisplayed());
    }
}
