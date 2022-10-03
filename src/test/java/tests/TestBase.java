package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Helper;

public class TestBase {
	
	String os=System.getProperty("os.name").toLowerCase();
	
	public static WebDriver driver;
	@BeforeSuite(groups = "regression")
	@Parameters({"browser"})
	public void StartDriver(@Optional("chrome") String browsername)
	{
		if(browsername.equalsIgnoreCase(os))
		{
			WebDriverManager.chromedriver().setup();
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (browsername.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		String AUT_URL="";
		driver.navigate().to(AUT_URL);
		driver.manage().window().maximize();
	}
	
	@AfterSuite(groups = "regression")
	public void CloseDriver()
	{
		//driver.quit();
	}

	public void ScreenshotonFailure(ITestResult results)
	{

		if (results.getStatus()==ITestResult.FAILURE)
		{

			System.out.println("Failed");
			System.out.println("Taking Screenshot.............");
			Helper.captureScreenshots(driver, results.getName());

		}

	}

}
