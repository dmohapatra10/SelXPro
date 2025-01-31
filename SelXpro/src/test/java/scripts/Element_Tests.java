package scripts;

import basepack.BaseTest;
import pageobjects.Elements_Page;
import pageobjects.Home_Page;
import utils.group_annotations.Bug;
import utils.group_annotations.Regression;
import utils.group_annotations.Smoke;

import org.testng.annotations.Test;

public class Element_Tests extends BaseTest {

    @Test
    @Smoke
    public void testElements()
    {
        Home_Page homePage=I.visit(super.baseURL, Home_Page.class);
        I.scrollTo(homePage.elements,"Elements");
        I.click(homePage.elements, "Elements");
        Elements_Page elementsPage=I.navigatedTo("/elements",Elements_Page.class);
        I.click(elementsPage.textBox, "Text Box Lnk");
        I.verifyElementIsDisplayed(elementsPage.usernameField, "Username");
    }

    @Test
    @Bug
    public void testVerifyUsernameFieldDisplayed()
    {
        Home_Page homePage=I.visit(super.baseURL, Home_Page.class);
        I.scrollTo(homePage.elements,"Elements");
        I.click(homePage.elements, "Elements");
        Elements_Page elementsPage=I.navigatedTo("/elements",Elements_Page.class);
        I.click(elementsPage.textBox, "Text Box Lnk");
        I.verifyElementIsDisplayed(elementsPage.usernameField, "Username");
    }
}
