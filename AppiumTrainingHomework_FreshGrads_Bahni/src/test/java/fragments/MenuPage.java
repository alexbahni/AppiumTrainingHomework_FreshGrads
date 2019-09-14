package fragments;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage {
    AndroidDriver<MobileElement> driver;
    private MobileElement loggedUsername;
    private MobileElement postRequestMenuItem;

    WebDriverWait wait;

    public MenuPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void initElementsFromMenu() {
        wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.fiverr.fiverr:id/profile_name")));

        loggedUsername = driver.findElement(By.id("com.fiverr.fiverr:id/profile_name"));
        postRequestMenuItem = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ListView/android.widget.LinearLayout[9]"));
    }

    public MobileElement getLoggedUsername() {
        return loggedUsername;
    }

    public String getLoggedUsernameText() {
        return loggedUsername.getText();
    }

    public boolean checkLoggedUsernameText(String expectedResult) {
        return getLoggedUsernameText().equals(expectedResult);
    }

    public MobileElement getPostRequestMenuItem() {
        return postRequestMenuItem;
    }
}
