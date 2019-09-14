package fragments;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
    AndroidDriver<MobileElement> driver;
    private MobileElement goBackButton;
    private MobileElement fiverrLogo;
    private MobileElement continueFacebook;
    private MobileElement continueGoogle;
    private MobileElement signUpWithEmail;
    private MobileElement termsOfService;

    public SignInPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void initElements() {
        goBackButton = driver.findElement(By.id("com.fiverr.fiverr:id/back"));
        fiverrLogo = driver.findElement(By.className("android.widget.ImageView"));
        continueFacebook = driver.findElement(By.id("com.fiverr.fiverr:id/facebook_connect_button"));
        continueGoogle = driver.findElement(By.id("com.fiverr.fiverr:id/google_connect_button"));
        signUpWithEmail = driver.findElement(By.id("com.fiverr.fiverr:id/signUpWithEmailBtn"));
        termsOfService = driver.findElement(By.id("com.fiverr.fiverr:id/terms_of_service_text"));
    }

    public MobileElement getGoBackButton() {
        return goBackButton;
    }

    public MobileElement getFiverrLogo() {
        return fiverrLogo;
    }

    public MobileElement getContinueFacebook() {
        return continueFacebook;
    }

    public MobileElement getContinueGoogle() {
        return continueGoogle;
    }

    public MobileElement getSignUpWithEmail() {
        return signUpWithEmail;
    }

    public MobileElement getTermsOfService() {
        return termsOfService;
    }

    public boolean isElementClickable(MobileElement mobileElement){
        if ( mobileElement.isEnabled() ){
            return true;
        }
        return false;
    }




}
