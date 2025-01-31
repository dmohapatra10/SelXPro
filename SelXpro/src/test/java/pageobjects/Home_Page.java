package pageobjects;

import basepack.BasePage;
import basepack.BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page extends BasePage {

    @FindBy(xpath = "//div[@class='card-body']//*[contains(text(),'Elements')]")
    public WebElement elements;

    @FindBy(xpath = "//div[@class='card-body']//*[contains(text(),'Forms')]")
    public WebElement forms;

    @FindBy(xpath = "//div[@class='card-body']//*[contains(text(),'Alerts, Frame & Windows')]")
    public WebElement alertAndFrame;

    @FindBy(xpath = "//div[@class='card-body']//*[contains(text(),'Widgets')]")
    public WebElement widgets;

    @FindBy(xpath = "//div[@class='card-body']//*[contains(text(),'Interactions')]")
    public WebElement interactions;

    @FindBy(xpath = "//div[@class='card-body']//*[contains(text(),'Book Store Application')]")
    public WebElement bookStoreApp;

    public Home_Page()
    {
        PageFactory.initElements(driver,this);
    }
}
