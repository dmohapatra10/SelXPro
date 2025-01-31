package scripts;

import basepack.BaseTest;
import pageobjects.Forms_Page;
import pageobjects.Home_Page;
import utils.group_annotations.Summary;
import utils.group_annotations.Regression;

import org.testng.annotations.Test;

public class Forms_Tests extends BaseTest {

    @Test
    @Regression
    @Summary("Verifying form elements like firstName and Last Name, Enter values in both the fields and verify the values")
    public void formsPageTest() {
        Home_Page homePage = I.visit(super.baseURL, Home_Page.class);
        I.scrollTo(homePage.forms, "Forms Link");
        I.click(homePage.forms, "Forms Link");
        Forms_Page formsPage = I.navigatedTo("/forms", Forms_Page.class);
        I.click(formsPage.practiceForm, "Practice Form Link");
        I.sendKeys(formsPage.firstName, "Debashish", "First Name");
    }

}
