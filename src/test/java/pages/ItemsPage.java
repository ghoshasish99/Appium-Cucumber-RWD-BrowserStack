package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Items page
 */
public class ItemsPage extends BasePage {

    /**
     * Product Top Bar
     */
    @FindBy(xpath = "//span[text()='Products']")
    private WebElement ProductsTopBar;
    
    /**
     * The cart icon
     */
    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    /**
     * Checkout
     */
    @FindBy(name = "checkout")
    private WebElement Checkout;

    public ItemsPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }


    public void loginSuccessful() {
        Assert.assertTrue(ProductsTopBar.isDisplayed());
    }
    
    public void orderProduct(String ProductName) {
    	driver.findElement(By.xpath("//div[text()='"+ProductName+"']/following::button[1]")).click();
    	cartIcon.click();
    	Assert.assertTrue(driver.findElement(By.xpath("//div[@class='inventory_item_name'][text()='"+ProductName+"']")).isDisplayed());
    	Checkout.click();
    }

}
