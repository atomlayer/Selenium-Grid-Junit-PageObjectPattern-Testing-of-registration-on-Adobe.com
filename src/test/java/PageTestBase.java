import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class PageTestBase {

    WebDriver driver;

  /* @BeforeClass
    public static void SetInitParametrs() {

    }
*/
    public void StartDriver() throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        driver = new RemoteWebDriver(new URL("http:/localhost:4444/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

}
