package extentUtil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class ReportManager {
    private static ExtentReports extent;
    private static final String FILE_SEPARATOR= FileSystems.getDefault().getSeparator();
    private static final String reportFilePath=System.getProperty("user.dir")+FILE_SEPARATOR+"Reports"+FILE_SEPARATOR+"Automation-Report.html";

    public static ExtentReports getInstance() {
        if (extent == null) createInstance();
        return extent;
    }

    private static void createInstance()
    {
        extent=new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(reportFilePath);
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setReportName("Debashish");
        spark.config().setEncoding("utf-8");
        spark.config().setDocumentTitle("Extent Report");
        extent.attachReporter(spark);
        extent.setSystemInfo("OS","Windows");
        extent.setSystemInfo("Browser","Chrome");
    }

}
