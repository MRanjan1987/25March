package patanjaliPageObjects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import patanjaliTestCases.BaseTest;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import utility.TestUtil;
import utility.VerifyLinkUrl;

public class BasePage extends BaseTest {

	public WebDriver driver;

	public BasePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		// PropertyConfigurator.configure("log4j.properties");

	}

	public void click(WebElement locator, String infoText) {

		locator.click();
		test.log(LogStatus.INFO, "click on :" + infoText);
		Reporter.log("click on :" + infoText);
	}

	public void type(WebElement locator, String testData, String infoText) {

		locator.clear();
		locator.sendKeys(testData);
		test.log(LogStatus.INFO, "type : " + infoText);
		Reporter.log("type in : " + infoText);
	}

	public void clear(WebElement locator, String infoText) {

		locator.clear();
		test.log(LogStatus.INFO, "clear the : " + infoText);
		Reporter.log("clear the : " + infoText);
	}

	public void select(WebElement locator, String visibleText, String infoText) {

		Select s = new Select(locator);
		s.selectByVisibleText(visibleText);

		test.log(LogStatus.INFO, "select from dropdown by click on : " + infoText);
		Reporter.log("select from dropdown by click on : " + infoText);
	}

	public String getPageTitle() {

		String pageTitle = driver.getTitle();

		test.log(LogStatus.INFO, "page title is : " + pageTitle);
		// System.out.println("Page title is: " + pageTitle);
		return pageTitle;
	}

	public void printText(String textLocator) {

		test.log(LogStatus.INFO, "Text present on page : " + textLocator);

	}

	public void capturescreenshot() {
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Reporter.log("Click to see screenshot");
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotname + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotname + "><img src=" + TestUtil.screenshotname
				+ " height=300 width=400></img></a>");

		test.log(LogStatus.PASS, test.addScreenCapture(TestUtil.screenshotname));

		extent.endTest(test);
		extent.flush();
	}

	public void TakeScreenShotTargetElement(WebElement locator, String infoText) throws IOException {

		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver, locator);
		ImageIO.write(screenshot.getImage(), "jpg",
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\ashotimgelement.jpg"));

		// ReportNG
		Reporter.log("<br>" + "Verification failure : <br>");
		Reporter.log(
				"<a target=\"_blank\" href=\"ashotimgelement.jpg\"><img src= ashotimgelement.jpg  height=300 width=400></img></a>");
		Reporter.log("<br>");
		Reporter.log("<br>");

		// Extent Report

		test.log(LogStatus.PASS, infoText);
		test.log(LogStatus.PASS, test.addScreenCapture("ashotimgelement.jpg"));
	}

	public void verifyEquals(String actual, String expected) throws IOException {

		try {

			Assert.assertEquals(actual, expected);
		} catch (Throwable t) {

			TestUtil.captureScreenshot();

			// ReportNG
			Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotname + "><img src=" + TestUtil.screenshotname
					+ " height=300 width=400></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");

			// Extent Report

			test.log(LogStatus.FAIL, "Verification Failed With Exception" + t.getMessage());
			test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotname));

		}
	}

	public void downloadFile(WebElement locateDownloadButton) throws IOException, InterruptedException {

		String sourceLocation = locateDownloadButton.getAttribute("href");
		String wget_command = "cmd /c E:\\Eclipse2020-03\\cucumberWorkspace\\RahulArora\\Ecommerce_By_Madhuranjan\\src\\test\\resources\\wgetToolForDownload\\wget.exe -P E:\\Eclipse2020-03\\cucumberWorkspace\\RahulArora\\Ecommerce_By_Madhuranjan\\target\\surefire-reports\\downloadedFile --no-check-certificate "
				+ sourceLocation;

		Process exec = Runtime.getRuntime().exec(wget_command);
		int exitVal = exec.waitFor();
		System.out.println("Exit value: " + exitVal);
	}

	public void uploadFile(WebElement uploadByClickingBrowseLocator, String pathFromWhereYouWantToUpload,
			WebElement termsCheckBoxLocator, WebElement submitButtonLocator) {

		uploadByClickingBrowseLocator.sendKeys(pathFromWhereYouWantToUpload);

		termsCheckBoxLocator.click();

		submitButtonLocator.click();

	}

	public void getCurrentUrl() {

		String CurrentUrl = driver.getCurrentUrl();
		test.log(LogStatus.INFO, "Current Url Is : " + CurrentUrl);
	}

	public void dragAndDrop(WebElement source, WebElement destination) {

		Actions act = new Actions(driver);

		act.dragAndDrop(source, destination).build().perform();
	}

	public void moveToElementByMouse(WebElement locatorWhereYouWantToMove) {

		Actions a = new Actions(driver);
		a.moveToElement(locatorWhereYouWantToMove).build().perform();
	}

	public void CountOflinks(List<WebElement> list) {

		int a = list.size();

		test.log(LogStatus.INFO, "Total Links are : " + a);

	}

	public void ClickOnAllLinksByMouseHover(WebElement locatorWhereYouWantToMove, List<WebElement> listOfLinks,
			String info) {

		int sizeOflinks = listOfLinks.size();
		Actions action = new Actions(driver);

		for (int i = 0; i < sizeOflinks; i++) {

			action.moveToElement(locatorWhereYouWantToMove).build().perform();

			String linkName = listOfLinks.get(i).getText();
			test.log(LogStatus.INFO, "Click On : " + linkName + " Link ");
			listOfLinks.get(i).click();

			String CurrentUrl = driver.getCurrentUrl();
			test.log(LogStatus.INFO, "Current URL isFwebdr : " + CurrentUrl);

			try {
				TestUtil.captureScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Reporter.log("Click to see screenshot");
			Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotname + ">Screenshot</a>");
			Reporter.log("<br>");
			Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotname + "><img src=" + TestUtil.screenshotname
					+ " height=300 width=400></img></a>");

			test.log(LogStatus.PASS, test.addScreenCapture(TestUtil.screenshotname));

			extent.endTest(test);
			extent.flush();

		}

	}

	public void OneTierSubMenue(WebElement FirstHeaderLink, List<WebElement> SecondSubMenuList)
			throws InterruptedException {

		Actions action = new Actions(driver);

		int list3 = SecondSubMenuList.size();
		for (int i = 0; i <= list3 - 1; i++) {

			action.moveToElement(FirstHeaderLink).build().perform();

			String linkName = SecondSubMenuList.get(i).getText();
			test.log(LogStatus.INFO, "Click On : " + linkName + " Link ");

			action.moveToElement(SecondSubMenuList.get(i)).click().build().perform();
			String CurrentUrl = driver.getCurrentUrl();
			test.log(LogStatus.INFO, "Current URL isFwebdr : " + CurrentUrl);

			try {
				TestUtil.captureScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Reporter.log("Click to see screenshot");
			Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotname + ">Screenshot</a>");
			Reporter.log("<br>");
			Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotname + "><img src=" + TestUtil.screenshotname
					+ " height=300 width=400></img></a>");

			test.log(LogStatus.PASS, test.addScreenCapture(TestUtil.screenshotname));

			extent.endTest(test);
			extent.flush();

		}

	}

	public void ThreeTierSubMenue(WebElement FirstHeaderLink, WebElement SecondHeaderLink,
			List<WebElement> ThirdSubMenuList) throws InterruptedException {

		Actions action = new Actions(driver);

		int list3 = ThirdSubMenuList.size();
		for (int i = 0; i <= list3 - 1; i++) {

			action.moveToElement(FirstHeaderLink).build().perform();
			action.moveToElement(SecondHeaderLink).build().perform();

			String linkName = ThirdSubMenuList.get(i).getText();
			test.log(LogStatus.INFO, "Click On : " + linkName + " Link ");

			action.moveToElement(ThirdSubMenuList.get(i)).click().build().perform();
			String CurrentUrl = driver.getCurrentUrl();
			test.log(LogStatus.INFO, "Current URL is : " + CurrentUrl);

			try {
				TestUtil.captureScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Reporter.log("Click to see screenshot");
			Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotname + ">Screenshot</a>");
			Reporter.log("<br>");
			Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotname + "><img src=" + TestUtil.screenshotname
					+ " height=300 width=400></img></a>");

			test.log(LogStatus.PASS, test.addScreenCapture(TestUtil.screenshotname));

			extent.endTest(test);
			extent.flush();

		}

	}

	public void FourthTierSubMenue(WebElement FirstHeaderLink, WebElement SecondHeaderLink, WebElement ThirdHeaderLink,
			List<WebElement> FourthSubMenuList) throws InterruptedException {

		Actions action = new Actions(driver);

		int list = FourthSubMenuList.size();
		for (int i = 1; i <= list - 1; i++) {

			action.moveToElement(FirstHeaderLink).build().perform();
			action.moveToElement(SecondHeaderLink).build().perform();
			action.moveToElement(ThirdHeaderLink).build().perform();

			String linkName = FourthSubMenuList.get(i).getText();
			test.log(LogStatus.INFO, "Click On : " + linkName + " Link ");

			action.moveToElement(FourthSubMenuList.get(i)).click().build().perform();
			String CurrentUrl = driver.getCurrentUrl();
			test.log(LogStatus.INFO, "Current URL isFwebdr : " + CurrentUrl);

			try {
				TestUtil.captureScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Reporter.log("Click to see screenshot");
			Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotname + ">Screenshot</a>");
			Reporter.log("<br>");
			Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotname + "><img src=" + TestUtil.screenshotname
					+ " height=300 width=400></img></a>");

			test.log(LogStatus.PASS, test.addScreenCapture(TestUtil.screenshotname));

			extent.endTest(test);
			extent.flush();

		}

	}

	public void dragAndDropOnIframe(WebElement frameElementLocatorForSwitch, WebElement sourceLocator,
			WebElement destinationLocator) {

		driver.switchTo().frame(frameElementLocatorForSwitch);

		Actions a = new Actions(driver);

		a.dragAndDrop(sourceLocator, destinationLocator).build().perform();

	}

	public void scrollByVisibleElement(WebElement targetElementLocator) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", targetElementLocator);
	}

	public WebElement webDriverWait(WebElement locator, int timeInSeconds) {

		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);

		WebElement waitForElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
		return waitForElement;
	}

	public WebElement fluentWait(WebElement locator, int maxWaitTime, int pollingTime) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(maxWaitTime))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);

		WebElement waitForElement = wait.until(ExpectedConditions.visibilityOf(locator));

		return waitForElement;

	}

	public void HandleAlert() {

		String alerttext = driver.switchTo().alert().getText();
		System.out.println(alerttext);
		test.log(LogStatus.INFO, "Alert Text is :" + alerttext);
		Reporter.log("Alert Text is :" + alerttext);

		driver.switchTo().alert().accept();
	}

	public void brokenLink() {

		// Storing the links in a list and traversing through the links
		List<WebElement> links = driver.findElements(By.tagName("a"));

		// This line will print the number of links and the count of links.
		System.out.println("No of links are " + links.size());

		// checking the links fetched.
		for (int i = 0; i < links.size(); i++) {
			WebElement E1 = links.get(i);
			String url = E1.getAttribute("href");
			VerifyLinkUrl.verifyBrokenLinks(url);

		}

	}

	public void brokenImage() {

		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Total number of Images on the Page are " + images.size());

		// checking the links fetched.
		for (int index = 0; index < images.size(); index++) {
			WebElement image = images.get(index);
			String imageURL = image.getAttribute("src");
			System.out.println("URL of Image " + (index + 1) + " is: " + imageURL);

			VerifyLinkUrl.verifyBrokenLinks(imageURL);

			// Validate image display using JavaScript executor
			try {
				boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript(
						"return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);",
						image);
				if (imageDisplayed) {
					System.out.println("DISPLAY - OK");
				} else {
					System.out.println("DISPLAY - BROKEN");
				}
			} catch (Exception e) {
				System.out.println("Error Occured");
			}
		}

	}

}
