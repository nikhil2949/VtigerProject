package genericLibrary;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ListenerImplementationClassTTest implements ITestListener {
	javaUtility jutil = new javaUtility();
	ExtentReports reports;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = reports.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName + "Sucessfull");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, methodName + "Failed");
		test.log(Status.INFO, result.getThrowable());
		String screenShotName = jutil.handlingCalendar("dd-MM-YYYY hh-mm-ss");

		TakesScreenshot ts = (TakesScreenshot) BaseClasss.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\ScreenShots\\" + screenShotName + ".png");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"TestCaseskipped");
	}

	@Override
	public void onStart(ITestContext context) {
		String dateTimeStamp = jutil.handlingCalendar("dd-MM-YYYY hh-mm-ss");
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\" + dateTimeStamp + ".png");
		htmlReport.config().setDocumentTitle("VTiger application report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Nikhil.A");

		// Creating Reports
		reports = new ExtentReports();
		reports.attachReporter(htmlReport);
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("BaseURL", "https://localhost8888");
		reports.setSystemInfo("OS", "Windows");
		reports.setSystemInfo("Reporter", "Nikhil.A");
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}

}
