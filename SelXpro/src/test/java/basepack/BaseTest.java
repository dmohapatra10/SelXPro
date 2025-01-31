package basepack;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.PropertyManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    private static final ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    public static String baseURL = PropertyManager.getApplicationData("baseURL");
    protected I I;

    public WebDriver getWebDriver() {
        return drivers.get();
    }

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {

        WebDriver webDriver = createDriverInstance(browser);
        drivers.set(webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        webDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
        I = new I(webDriver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriver webDriver = drivers.get();
        if (webDriver != null) {
            try {
                System.out.println("Closing WebDriver instance.");
                webDriver.quit();
            } catch (Exception e) {
                System.err.println("Error occurred while quitting the WebDriver: " + e.getMessage());
            } finally {
                drivers.remove();
            }
        } else {
            System.out.println("No WebDriver instance to close.");
        }
        this.I = null;
    }

    private WebDriver createDriverInstance(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().clearDriverCache().setup();
                WebDriverManager.chromedriver().clearResolutionCache().setup();
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" not supported.");
        }
    }
}