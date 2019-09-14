package tests;

import configs.BaseClass;
import fragments.WelcomeToFiverrPage;
import org.junit.Assert;
import org.junit.Test;

public class WelcomeToFiverrTest extends BaseClass {
    @Test
    public void checkWelcomeToFiverrPage() {
        WelcomeToFiverrPage welcomeToFiverrPage = new WelcomeToFiverrPage(driver);
        welcomeToFiverrPage.initElements();
        Assert.assertTrue(welcomeToFiverrPage.checkWelcomeToFiverrPage());
    }
}
