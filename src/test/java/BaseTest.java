import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest extends Assert {
    private static String driverPath = "src\\main\\resources\\chromedriver.exe";
    public static WebDriver driver;
    protected WebDriverWait wait;
    final static Logger log = LogManager.getLogger(BaseTest.class);

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterSuite
    public void finishMessage() {
        if(driver!=null) {
            System.out.println("Closing chrome browser");
            driver.quit();
        }
        log.info("Finished tests");
    }
}
