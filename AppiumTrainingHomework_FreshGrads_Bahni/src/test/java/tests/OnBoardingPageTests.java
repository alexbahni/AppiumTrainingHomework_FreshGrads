package tests;

import configs.BaseClass;
import fragments.OnBoardingPage;
import fragments.WelcomeToFiverrPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnBoardingPageTests extends BaseClass {

    @Test
    public void isOnBoardingPageDisplayed() throws InterruptedException {
        WelcomeToFiverrPage welcomeToFiverrPage = new WelcomeToFiverrPage(driver);
        welcomeToFiverrPage.initElements();
        Assert.assertTrue(welcomeToFiverrPage.checkWelcomeToFiverrPage());


        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.invisibilityOf(welcomeToFiverrPage.getLogoFiver()));

        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
        onBoardingPage.initElements();

        Assert.assertEquals("SKIP", onBoardingPage.getSkipButtonText());
    }

}
