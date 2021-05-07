package framework;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {
    
	protected static final Logger LOG = LoggerFactory.getLogger(DriverFactory.class);
    
	public static AppiumDriver<WebElement> createAppiumDriverInstance() {

		AppiumDriver<WebElement> driver = null;

        try {

        	DesiredCapabilities caps = new DesiredCapabilities();
            
        	URL url = null;
            String platformName = System.getProperty("platformName");
            String udid = System.getProperty("udid");
            String browserName = System.getProperty("browserName");
            String browserstackUserID = System.getProperty("browserstackUserID");
            String browserstackKey = System.getProperty("browserstackKey");
            String browserstackDevice = System.getProperty("browserstackDevice");
            String browserstackOS = System.getProperty("browserstackOS");
            String executionMode = System.getProperty("executionMode");
           
            caps.setCapability(MobileCapabilityType.BROWSER_NAME,browserName);
            
            switch (executionMode) {
                case "Local":
                	url = new URL(System.getProperty("appiumUrl"));
                	caps.setCapability(MobileCapabilityType.UDID,udid);
          		    caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60);          		    
          	        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
          	    
          		    driver = new AppiumDriver<WebElement>(url, caps);
                    break;
                    
                case "Remote":
                	  url = new URL(System.getProperty("browserstackUrl"));
                	  caps.setCapability("browserstack.user", browserstackUserID);
            	      caps.setCapability("browserstack.key", browserstackKey);
            	      caps.setCapability("device", browserstackDevice);
            	      caps.setCapability("os_version", browserstackOS);

                      driver = new AppiumDriver<WebElement>(url, caps);
                      break;

                default:
                     LOG.info("Execution Mode must be provided");
            }
            
               driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
               LOG.info(platformName + " Driver Creation Completed");
               
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return driver;
    }
}