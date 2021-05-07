package pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * A base for all the pages within the suite
 */
public abstract class BasePage {
   
    /**
     * The driver
     */
	AppiumDriver<WebElement> driver;

    protected BasePage(AppiumDriver<WebElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
}