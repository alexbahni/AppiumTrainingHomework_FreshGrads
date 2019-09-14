package fragments;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ChooseAccountPage {
    AndroidDriver<MobileElement> driver;
    MobileElement selectAccount;

    public ChooseAccountPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void initElements() {
        selectAccount = driver.findElement(By.id("com.google.android.gms:id/account_particle_disc"));
    }

    public MobileElement getSelectAccount() {
        return selectAccount;
    }
}
