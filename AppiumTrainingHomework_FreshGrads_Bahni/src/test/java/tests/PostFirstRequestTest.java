package tests;

import configs.BaseClass;
import configs.ScreenSizes;
import fragments.*;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import models.RequestModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostFirstRequestTest extends BaseClass {
    WelcomeToFiverrPage welcomeToFiverrPage;
    OnBoardingPage onBoardingPage;
    SignInPage signInPage;
    ChooseAccountPage chooseAccountPage;
    ScreenSizes screenSizes;
    HomePage homePage;
    MenuPage menuPage;
    PostRequestPage postRequestPage;
    PostRequestFormPage postRequestFormPage;
    RequestModel requestModel;

    WebDriverWait wait;


    @Before
    public void setUpPostRequestPage() {
        welcomeToFiverrPage = new WelcomeToFiverrPage(driver);
        welcomeToFiverrPage.initElements();

        wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.invisibilityOf(welcomeToFiverrPage.getLogoFiver()));

        onBoardingPage = new OnBoardingPage(driver);
        onBoardingPage.initElements();
        onBoardingPage.getSkipButton().click();

        signInPage = new SignInPage(driver);
        signInPage.initElements();

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
    }

    @Test
    public void checkPostRequestProccess() {
        menuPage.getPostRequestMenuItem().click();

        postRequestPage = new PostRequestPage(driver);
        postRequestPage.initElements();

        if( postRequestPage.checkRequestsNumber() ){
            postRequestPage.getPostRequestButton().click();
        }

        requestModel = new RequestModel();
        requestModel.setRequestDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis ultricies egestas pretium.");
        requestModel.setRequestCategory("Programming & Tech");
        requestModel.setRequestSubcategory("Mobile Apps & Web");
        requestModel.setRequestPlatform("iPhone/iPad App");
        requestModel.setRequestExpertise("Design");
        requestModel.setRequestDeliveryTime("21 Days");
        requestModel.setRequestBudget("500");

        postRequestFormPage = new PostRequestFormPage(driver);

        postRequestFormPage.initElements();
        postRequestFormPage.createRequest(
                requestModel.getRequestDescription(),
                requestModel.getRequestCategory(),
                requestModel.getRequestSubcategory(),
                requestModel.getRequestPlatform(),
                requestModel.getRequestExpertise(),
                requestModel.getRequestDeliveryTime(),
                requestModel.getRequestBudget() );

        postRequestFormPage.initElementsAfterCreatingRequest();

        Assert.assertEquals("PENDING",postRequestFormPage.getRequestPendingStatus().getText());
        Assert.assertEquals(requestModel.getRequestDescription(), postRequestFormPage.getRequestDescriptionCheck().getText());
        Assert.assertEquals(requestModel.getRequestDeliveryTime(), postRequestFormPage.getRequestDurationCheck().getText());
        Assert.assertTrue(postRequestFormPage.checkIfContains(requestModel.getRequestBudget(), postRequestFormPage.getRequestBudgetCheck()));


        postRequestFormPage.getRequestDeleteRequestButton().click();
        postRequestFormPage.initConfirmDeleteRequest();
        postRequestFormPage.getConfirmDeleteRequest().click();

    }
}
