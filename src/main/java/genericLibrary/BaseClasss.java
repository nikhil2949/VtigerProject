package genericLibrary;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import pomClasses.HomePage;
import pomClasses.LoginPage;

public class BaseClasss {
	PropertiesUtility putil = new PropertiesUtility();
	public static WebDriver driver = null;

	@BeforeSuite(alwaysRun = true)
	public void createDbConnection() {
		System.out.println("DB Connection Successfull!!");
	}

//	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(/*String browser*/) throws Exception {
		String URL = putil.readDataFromProperties("url");
		
	//	if(browser.contains("chrome"))
	//	{
	//		driver=new ChromeDriver();
	//	}
	//	if(browser.contains("firefox"))
	//	{
	//		driver=new FirefoxDriver();
	//	}
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(URL);
		System.out.println("Launching Browser Done!!");
	}

	@BeforeMethod(alwaysRun = true)
	public void LoginOperation() throws Exception {
		String USERNAME = putil.readDataFromProperties("username");
		String PASSWORD = putil.readDataFromProperties("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);
		System.out.println("Login Successfull!!");
	}

	@AfterMethod(alwaysRun = true)
	public void logOutOperation() {
		HomePage hp = new HomePage(driver);
		hp.signOutOperation(driver);
		System.out.println("Logout Succesfull!!");
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
		System.out.println("Browser closed succesfully!!");
	}

	@AfterSuite(alwaysRun = true)
	public void closeDbConnection() {
		System.out.println("DB Connection Closed!!");
	}

}
