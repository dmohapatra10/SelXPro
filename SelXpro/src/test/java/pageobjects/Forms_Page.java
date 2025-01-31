package pageobjects;

import basepack.BasePage;
import basepack.BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Forms_Page extends BasePage {

    public Forms_Page(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//li//*[contains(text(),'Practice Form')]")
    public WebElement practiceForm;

    @FindBy(css = "#firstName")
    public WebElement firstName;

    @FindBy(css = "#lastName")
    public WebElement lastName;

    @FindBy(css = "#userEmail")
    public WebElement email;

    @FindBy(xpath = "//input[contains(@id,'gender-radio')][@value='Male']")
    public WebElement maleRadioBtn;

    @FindBy(xpath = "//input[contains(@id,'gender-radio')][@value='Female']")
    public WebElement femaleRadioBtn;

    @FindBy(xpath = "//input[contains(@id,'gender-radio')][@value='Other']")
    public WebElement otherRadioBtn;

    @FindBy(css = "input#userNumber")
    public WebElement mobileNumber;

    @FindBy(css = ".react-datepicker__month-select")
    public WebElement datePickerMonth;

    @FindBy(css = ".react-datepicker__year-select")
    public WebElement datePickerYear;

    @FindBy(css = "[class*='react-datepicker__day']")
    public WebElement datePickerDay;

}
