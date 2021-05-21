# Appium with Cucumber - Mobile Web Testing

[![Appium-RWD-Cucumber](https://github.com/ghoshasish99/Appium-Cucumber-RWD-BrowserStack/actions/workflows/maven.yml/badge.svg)](https://github.com/ghoshasish99/Appium-Cucumber-RWD-BrowserStack/actions/workflows/maven.yml)

### Getting started:

# Set up your phone

* Launch the Settings application on your phone.
* Tap the About Phone option generally near the bottom of the list.
* Then tap the Build Number option 7 times to enable Developer Mode. You will see a toast message when it is done.
* Now go back to the main Settings screen and you should see a new Developer Options menu you can access.
* Go in there and enable the USB Debugging mode option.
* You are partially done with the phone setup process. Next up, you will need to scroll below and follow the rest of the instructions for your particular operating system.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# Set up Windows

* Install Android Studio
* Set `ANDROID_HOME` as your Environment variable. Follow [this](https://www.360logica.com/blog/how-to-set-path-environmental-variable-for-sdk-in-windows/) to get more details.
* Add to the Path variable the locations of the /emulators, /tools, and /platform-tools folders in your installation of the Android SDK. For example:
C:\Android\android-sdk\emulator; C:\Android\android-sdk\tools;C:\Android\android-sdk\platform-tools

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# Final Check

* Connect your smartphone or tablet to your computer with a USB cable. Change the USB mode to "file transfer (MTP)" mode. Some OEMs may or may not require this, but it’s best to just leave it in this mode for general compatibility.
* In the Command Prompt window on PowerShell, enter the following command to launch the ADB daemon: `adb devices`
* On your phone's screen, you should see a prompt to allow or deny USB Debugging access. Naturally, you will want to grant USB Debugging access when prompted (and tap the always allow check box if you never want to see that prompt again).
* Finally, re-enter the command `adb devices`. If everything was successful, you should now see your device's serial number in the command prompt or the PowerShell window.

```powershell
List of devices attached
ZZT063456FR     device
```
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# Appium and Cucumber

* Install Appium using `npm install -g appium` and run on Port 4723. I ran on 4724 in the above code.
* Install Appium for Desktop for UI inspection of Mobile Elements. Learn how to work with Appium for Desktop [here](https://github.com/appium/appium-desktop/)
* Now create a cucumber framework to orchestrate your tests.

2 main maven dependencies are as follows :

```xml
       <dependency>
            <groupId>io.appium</groupId>
            <artifactId>java-client</artifactId>
            <version>7.2.0</version>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>4.2.6</version>
            <scope>compile</scope>
        </dependency>
```
Setting the Desired Capabilities :

```java
DesiredCapabilities caps = new DesiredCapabilities();

caps.setCapability(MobileCapabilityType.UDID,udid); // udid is the ID of the device
caps.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
caps.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
```

Additional capabilities to be set for execution in BrowserStack :

```java
caps.setCapability("browserstack.user", browserstackUserID);
caps.setCapability("browserstack.key", browserstackKey);
caps.setCapability("device", browserstackDevice);
caps.setCapability("os_version", browserstackOS);
```

Working folder structure :
```
src
 |-- test
       |-- java
             |-- stepdefinitions
                   |-- steps.java (individual steps are captured)
			 |-- runner	   
                   |-- TestRunner.java
			 |-- pages
                   |-- <all pages>.java 
			 |-- framework
                   |-- Driverfactory.java			 
       |-- resources
             |-- features
                    |-- .feature (feature files)
             |-- payloads
                    |-- .json (request payloads)
  |-- pom.xml                  

```
The TestRunner file is simple :
```java
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true, monochrome = true,
        features = "src/test/resources/features/",
        glue = {"stepdefinitions"},
        plugin = {"pretty","junit:target/junitreport.xml","json:target/jsonreport.json","html:target/cucumber-reports"}
        
)
public class TestRunner {
}
```
You can study this repository for a detailed implementation

