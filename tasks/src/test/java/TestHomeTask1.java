import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ExecutionListener.class)
public class TestHomeTask1 {

    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(TestHomeTask1.class);
    private static ServerConfig config = ConfigFactory.create(ServerConfig.class);


    @BeforeTest
    public void setUp() {
        String browserType = System.getProperty("test.browser.type");
        if ("FF".equalsIgnoreCase(browserType)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }

    @Test
    public void openPage() {

        driver.get(config.testedResourceUrl());
        logger.info("Page is opened");
    }

    @AfterTest
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
        logger.info("Driver is down");
    }
}