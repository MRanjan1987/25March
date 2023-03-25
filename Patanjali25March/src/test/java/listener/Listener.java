package listener;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import patanjaliTestCases.BaseTest;
import utility.TestUtil;

public class Listener extends BaseTest implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		test = extent.startTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

		// System.setProperty("org.uncommons.reportng.escape-output", "false");

		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		test.log(LogStatus.PASS, result.getName() + "PASS");
		test.log(LogStatus.PASS, test.addScreenCapture(TestUtil.screenshotname));

		Reporter.log("Click to see screenshot");
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotname + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotname + "><img src=" + TestUtil.screenshotname
				+ " height=300 width=400></img></a>");

		extent.endTest(test);
		extent.flush();
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		// System.setProperty("org.uncommons.reportng.escape-output", "false");

		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		test.log(LogStatus.FAIL, result.getName() + "Failed With Exception: " + result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotname));

		Reporter.log("Click to see screenshot");
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotname + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotname + "><img src=" + TestUtil.screenshotname
				+ " height=300 width=400></img></a>");

		extent.endTest(test);
		extent.flush();
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		test.log(LogStatus.SKIP, result.getName() + "SKIP");
		test.log(LogStatus.SKIP, test.addScreenCapture(TestUtil.screenshotname));

		Reporter.log("Click to see screenshot");
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotname + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotname + "><img src=" + TestUtil.screenshotname
				+ " height=300 width=400></img></a>");

		extent.endTest(test);
		extent.flush();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
