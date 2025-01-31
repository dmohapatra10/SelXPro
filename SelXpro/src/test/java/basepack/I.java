package basepack;

import com.aventstack.extentreports.Status;
import extentUtil.ExtentTestManager;
import utils.PropertyManager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class I {

    private WebDriver driver;

    public I(WebDriver driver)
    {
        this.driver=driver;
    }

    private WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

    public WebElement waitUntilClickable(WebElement locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitUntilElementIsVisible(WebElement locator) {
        return wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public WebElement waitUntilElementIsVisible(List<WebElement> locator) {
        return (WebElement) wait.until(ExpectedConditions.visibilityOfAllElements(locator));
    }

    public boolean waitUntilInvisible(WebElement locator) {
        return wait.until(ExpectedConditions.invisibilityOf(locator));
    }

    public WebElement scrollTo(WebElement locator, String locatorName) {
        logStep("I scroll to "+locatorName);
        waitUntilElementIsVisible(locator);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",locator);
        return locator;
    }
    public WebElement click(WebElement locator, String locatorName) {
        logStep("I click the "+locatorName);
        waitUntilClickable(locator).click();
        return locator;
    }

    public WebElement sendKeys(WebElement locator, String text, String locatorName) {
        logStep("I type "+text+ " into the text box "+locatorName);
        waitUntilElementIsVisible(locator).sendKeys(text, locatorName);
        return locator;
    }

    public void selectOptionByText(WebElement dropdownLocator, String option, String locatorName)
    {
        logStep("I select the option "+option+" from the dropdown "+locatorName);
        waitUntilElementIsVisible(dropdownLocator);
        Select select=new Select(dropdownLocator);
        select.selectByVisibleText(option);
    }
    public void selectOptionByIndex(WebElement dropdownLocator, int index, String locatorName)
    {
        logStep("I select the option at index "+index+" from the dropdown "+locatorName);
        waitUntilElementIsVisible(dropdownLocator);
        Select select=new Select(dropdownLocator);
        select.selectByIndex(index);
    }

    public void selectOptionByValue(WebElement dropdownLocator, String value, String locatorName)
    {
        logStep("I select the option with value "+value+" from the dropdown "+locatorName);
        waitUntilElementIsVisible(dropdownLocator);
        Select select=new Select(dropdownLocator);
        select.selectByValue(value);
    }

    public List<WebElement> getAllDropDownOptions(WebElement dropdownLocator, String dropdownLocatorName)
    {
        logStep("I get all the options from dropdown "+dropdownLocatorName);
        waitUntilElementIsVisible(dropdownLocator);
        Select select=new Select(dropdownLocator);
        return select.getOptions();
    }

    public List<WebElement> getAllSelectedDropDownOptions(WebElement dropdownLocator, String dropdownLocatorName)
    {
        logStep("I get all the selected options from the dropdown "+dropdownLocatorName);
        waitUntilElementIsVisible(dropdownLocator);
        Select select=new Select(dropdownLocator);
        return select.getAllSelectedOptions();
    }

    public WebElement dragAndDrop(WebElement source, WebElement destination, String elementName)
    {
        logStep("I drag and drop "+elementName);
        waitUntilElementIsVisible(source);
        Actions actions=new Actions(driver);
        actions.dragAndDrop(source,destination);
        return destination;
    }

    public WebElement moveMouseTo(WebElement locator, String elementName)
    {
        logStep("I mouse move to "+elementName);
        Actions actions=new Actions(driver);
        waitUntilElementIsVisible(locator);
        actions.moveToElement(locator);
        return locator;
    }

    public WebElement keyPress(WebElement locator, Keys key, String elementName)
    {
        logStep("I key press at "+elementName);
        Actions actions=new Actions(driver);
        waitUntilElementIsVisible(locator);
        actions.sendKeys(locator,key).perform();
        return locator;
    }

    public <T> T visit(String url, final Class<T> pageClass)
    {
        logStep("I navigated to "+url);
        driver.get(url);
        return PageFactory.initElements(driver,pageClass);
    }

    public <T> T navigateTo(String endPoint, final Class<T> pageClass)
    {
        String baseUrl=PropertyManager.getApplicationData("baseURL");
        String url=baseUrl+endPoint;
        driver.navigate().to(url);
        return PageFactory.initElements(driver,pageClass);
    }
    public <T> T navigatedTo(String endPoint, final Class<T> pageClass)
    {
        Assert.assertTrue(driver.getCurrentUrl().contains(endPoint),"End Point entered is incorrect");
        return PageFactory.initElements(driver,pageClass);
    }

    public void verifyElementIsDisplayed(WebElement element, String elementName)
    {
        logStep("the element "+elementName+ " should be displayed");
        waitUntilElementIsVisible(element);
        Assert.assertTrue(element.isDisplayed());
    }

    public void logStep(String logMessage)
    {
        ExtentTestManager.getTest().log(Status.INFO,logMessage);
    }
}
