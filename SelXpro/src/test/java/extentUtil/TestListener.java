package extentUtil;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import basepack.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {

private ExtentTest test;
BaseTest baseTest=new BaseTest();
private static final String FILE_PATH=System.getProperty("user.dir")+"/screenshots/";

    public void onStart(ITestContext context) {

        System.out.println("*** Test Suite " + context.getName() + " started ***");
    }

    public void onFinish(ITestContext context) {
        System.out.println("*** Test Suite " + context.getName() + " ending ***");
        ReportManager.getInstance().flush();
    }

    public void onTestStart(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        ExtentTestManager.startTest(methodName);
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println(
            "*** Executed " + result.getMethod().getMethodName() + " test successfully...");
        test=ExtentTestManager.getTest();
        test.log(Status.PASS,"Test: "+result.getMethod().getMethodName()+" passed");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("*** Test " + result.getMethod().getMethodName() + " failed...");
        test=ExtentTestManager.getTest();
        test.log(
            Status.FAIL,
            "<details><summary><b><font color=red>"
            + " Exception Occurred, click To See Details:"
            + "</font></b></summary>"
            + result.getThrowable().getMessage()
            + "</details>\n");
        String fileName=FILE_PATH+result.getMethod().getMethodName()+".png";
        takeScreenshot(baseTest.getWebDriver(),fileName);
        test.addScreenCaptureFromPath(fileName);
    }
    public void onTestSkipped(ITestResult result) {
        System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
        test=ExtentTestManager.getTest();
        test.log(Status.SKIP, "Test skipped"+result.getThrowable().getMessage());
    }

    private void takeScreenshot(WebDriver driver,String destFilePath)
    {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File(destFilePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
