package pageobjects;

import basepack.BasePage;
import basepack.BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import basepack.I;

public class Elements_Page extends BasePage {

    @FindBy(xpath = "//div[@class='left-pannel']//*[contains(text(),'Text Box')]")
    public WebElement textBox;

    @FindBy(xpath = "//div[@class='left-pannel']//*[contains(text(),'Check Box')]")
    public WebElement checkbox;

    @FindBy(xpath = "//div[@class='left-pannel']//*[contains(text(),'Radio Button')]")
    public WebElement radioButtons;

    @FindBy(xpath = "//div[@class='left-pannel']//*[contains(text(),'Web Tables')]")
    public WebElement webTables;

    @FindBy(xpath = "//input[@id='userName']")
    public WebElement usernameField;

    public Elements_Page()
    {
        PageFactory.initElements(driver,this);
    }
}
