package configs;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

public class AppTouchActions {
    AndroidDriver<MobileElement> driver;
    TouchAction touch;

    public AppTouchActions(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void scroolDownAction() {
        touch = new TouchAction(driver);
        touch.press(PointOption.point(990, 972))
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(990, 50))
                .release()
                .perform();
    }

    public void scroolDownInListAction() {
        touch = new TouchAction(driver);
        touch.press(PointOption.point(500, 1800))
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(500, 975))
                .release()
                .perform();
    }

}
