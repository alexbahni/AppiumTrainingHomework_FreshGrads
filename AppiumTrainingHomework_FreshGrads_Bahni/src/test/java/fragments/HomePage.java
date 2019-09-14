package fragments;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    AndroidDriver<MobileElement> driver;
    private MobileElement searchField;

    WebDriverWait wait;


    public HomePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void waitForHomepageToBeLoaded() {
        wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.fiverr.fiverr:id/search_box_layout")));
    }

    public MobileElement getSearchField() {
        return searchField;
    }
}
