package basepack;

import org.openqa.selenium.WebDriver;

public class BasePage {

    private BaseTest baseTest=new BaseTest();
    protected WebDriver driver = baseTest.getWebDriver();
    protected I I =new I(driver);

}
