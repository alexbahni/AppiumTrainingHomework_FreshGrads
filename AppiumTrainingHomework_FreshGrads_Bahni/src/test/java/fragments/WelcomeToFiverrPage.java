package fragments;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class WelcomeToFiverrPage {
    AndroidDriver<MobileElement> driver;
    private MobileElement logoFiverr;


    public WelcomeToFiverrPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void initElements() {
        logoFiverr = driver.findElement(By.className("android.widget.ImageView"));
    }

    public boolean checkWelcomeToFiverrPage() {
        if (logoFiverr.isDisplayed()) {
            return true;
        }
        return false;
    }

    public MobileElement getLogoFiver() {
        return logoFiverr;
    }
}
