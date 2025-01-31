package extentUtil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {

    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports extent = ReportManager.getInstance();

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized void startTest(String testName, String description) {
        ExtentTest test = extent.createTest(testName).info(description);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
    }
}
