package fragments;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostRequestPage {
    AndroidDriver<MobileElement> driver;
    private MobileElement emptyStateElement;
    private MobileElement postRequestButton;

    WebDriverWait wait;

    public PostRequestPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void initElements() {
//        wait = new WebDriverWait(driver, 3000);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.fiverr.fiverr:id/empty_state_icon")));

        emptyStateElement = driver.findElement(By.id("com.fiverr.fiverr:id/empty_state_title"));
        postRequestButton = driver.findElement(By.id("com.fiverr.fiverr:id/empty_list_button"));
    }

    public boolean checkRequestsNumber() {
        return emptyStateElement.isDisplayed();
    }

    public MobileElement getPostRequestButton() {
        return postRequestButton;
    }
}
