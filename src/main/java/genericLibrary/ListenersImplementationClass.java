package genericLibrary;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ListenersImplementationClass implements ITestListener {
	javaUtility jutil = new javaUtility();
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log("This" + methodName + "test case execution starts!!"); // Reporter.log method is used for normal
																			// TestNg report
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log("This" + methodName + "test case execution succeeded!!"); // Reporter.log method is used for normal
																				// TestNg report
		test.log(Status.PASS, methodName + "Successfull");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, methodName + "Failed");
		test.log(Status.INFO, result.getThrowable());
		String screenshotName = methodName + jutil.handlingCalendar("dd-MM-YYYY hh-mm-ss");

		TakesScreenshot ts = (TakesScreenshot) BaseClasss.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\ScreenShots\\" + screenshotName + ".png");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(dest.getAbsolutePath());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log("This" + methodName + "test case skipped!!!");
		test.log(Status.SKIP, methodName + "test case skipped!!!");
	}

	@Override
	public void onStart(ITestContext context) {
		String dateTimeStamp = jutil.handlingCalendar("dd-MM-YYYY hh-mm-ss");
		// Configuration of the test reports
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\" + dateTimeStamp + ".html");
		htmlReport.config().setDocumentTitle("Vtiger Application Execution");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Build 2 Vtiger Application");
		

		// Creating the report
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base URL", "https://localhost:8888");
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base OS", "Windows");
		report.setSystemInfo("Base Environment", "Testing_Env");
		report.setSystemInfo("Reporter Name", "Nikhil.A");

	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
