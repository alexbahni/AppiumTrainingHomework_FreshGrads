package tests;

import configs.BaseClass;
import configs.ScreenSizes;
import fragments.*;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class SignInPageTests extends BaseClass {
    WelcomeToFiverrPage welcomeToFiverrPage;
    OnBoardingPage onBoardingPage;
    SignInPage signInPage;
    ChooseAccountPage chooseAccountPage;
    ScreenSizes screenSizes;
    HomePage homePage;
    MenuPage menuPage;

    WebDriverWait wait;

    @Before
    public void setUpSignInPage() {
        welcomeToFiverrPage = new WelcomeToFiverrPage(driver);
        welcomeToFiverrPage.initElements();
        screenSizes = new ScreenSizes(driver);

        wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.invisibilityOf(welcomeToFiverrPage.getLogoFiver()));

        onBoardingPage = new OnBoardingPage(driver);
        onBoardingPage.initElements();
        onBoardingPage.getSkipButton().click();

        signInPage = new SignInPage(driver);
        signInPage.initElements();
    }

    @Test
    public void checkSignInPage() {
        Assert.assertTrue( signInPage.isElementClickable(signInPage.getGoBackButton()) );
        Assert.assertEquals("Go back", signInPage.getGoBackButton().getText() );

        Assert.assertTrue( signInPage.isElementClickable(signInPage.getFiverrLogo()) );

        Assert.assertTrue( signInPage.isElementClickable(signInPage.getContinueFacebook()) );
        Assert.assertEquals( "CONTINUE WITH FACEBOOK", signInPage.getContinueFacebook().getText() );

        Assert.assertTrue( signInPage.isElementClickable(signInPage.getContinueGoogle()) );
        Assert.assertEquals( "CONTINUE WITH GOOGLE", signInPage.getContinueGoogle().getText() );

        Assert.assertTrue( signInPage.isElementClickable(signInPage.getSignUpWithEmail()) );
        Assert.assertEquals( "SIGN UP WITH EMAIL", signInPage.getSignUpWithEmail().getText() );

        Assert.assertTrue( signInPage.isElementClickable(signInPage.getTermsOfService()) );
        Assert.assertEquals( "By joining, you agree to Fiverr’s  Terms of Service", signInPage.getTermsOfService().getText() );
    }

    @Test
    public void checkSignInProcess() {
        wait = new WebDriverWait(driver, 3000);
        homePage = new HomePage(driver);
        menuPage = new MenuPage(driver);

        signInPage.getContinueGoogle().click();

        chooseAccountPage = new ChooseAccountPage(driver);
        chooseAccountPage.initElements();
        chooseAccountPage.getSelectAccount().click();

        homePage.waitForHomepageToBeLoaded();

        TouchAction touch = new TouchAction(driver);
        touch.tap(PointOption.point(100,100))
                .perform();

        menuPage.initElementsFromMenu();
        wait.until(ExpectedConditions.visibilityOf(menuPage.getLoggedUsername()));

        Assert.assertTrue(menuPage.checkLoggedUsernameText("appiumtesting02"));

    }
}
