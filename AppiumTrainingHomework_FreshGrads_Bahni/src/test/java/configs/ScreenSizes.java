package configs;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.awt.*;

public class ScreenSizes{
    AndroidDriver<MobileElement> driver;
//    private Dimension windowWidthSize;
//    private Dimension windowHeightSize;
    private int windowWidthSize;

    public ScreenSizes(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public int getWindowWidthSize() {
        windowWidthSize = driver.manage().window().getSize().getWidth();

        return windowWidthSize;
    }
}
