package configs;

import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;

import java.net.MalformedURLException;

public class BaseClass extends CapabilitiesClass {
    public AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        driver = getLocalDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
