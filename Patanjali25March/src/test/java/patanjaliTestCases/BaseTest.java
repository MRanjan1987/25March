package patanjaliTestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExtentManager;


public class BaseTest {

	public static WebDriver driver;
	public FileInputStream fis;
	public Properties prop;
	public ExtentReports extent = ExtentManager.getInstance();
	public static ExtentTest test;

	@BeforeMethod
	public void setUp() throws IOException {

		fis = new FileInputStream(".\\src\\test\\resources\\properties\\configue.properties");

		prop = new Properties();
		prop.load(fis);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		if (driver == null) {

			if (prop.getProperty("browser").equals("chrome")) {

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);

			} else if (prop.getProperty("browser").equals("firefox")) {

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (prop.getProperty("browser").equals("internetExplorer")) {

				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			} else if (prop.getProperty("browser").equals("edge")) {

				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

	
}
