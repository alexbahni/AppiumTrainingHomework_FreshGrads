package fragments;

import configs.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class OnBoardingPage {
    AndroidDriver<MobileElement> driver;
    private MobileElement skipButton;

    public OnBoardingPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void initElements() {
        skipButton = driver.findElement(By.id("com.fiverr.fiverr:id/skip_button"));
    }

    public String getSkipButtonText() {
        return skipButton.getText();
    }

    public void goToSignPage() {
        skipButton.click();
    }

    public MobileElement getSkipButton() {
        return skipButton;
    }
}
