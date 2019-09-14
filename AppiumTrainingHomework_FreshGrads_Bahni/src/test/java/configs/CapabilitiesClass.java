package configs;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CapabilitiesClass {
    public AndroidDriver getLocalDriver() throws MalformedURLException {
        DesiredCapabilities capabilites = new DesiredCapabilities();

        capabilites.setCapability("deviceName", "HUAWEI P20 PRO");
        capabilites.setCapability("udid", "WCR0218716000914");
        capabilites.setCapability("app", "C:\\Users\\abahnean\\IdeaProjects\\AppiumTrainingHomework_FreshGrads_Bahni\\apksInbox\\com.fiverr_APK.apk");
        capabilites.setCapability("appPackage", "com.fiverr.fiverr");
        capabilites.setCapability("appActivity", "com.fiverr.fiverr.activityandfragments.entrypoints.FVREntryPoint");
        capabilites.setCapability("platformName", "Android");
        capabilites.setCapability("automationName", "Appium");

        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, capabilites);

        return driver;
    }
}