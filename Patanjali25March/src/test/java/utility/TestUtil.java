package utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import patanjaliTestCases.BaseTest;

public class TestUtil extends BaseTest {

	public static String screenshotPath;
	public static String screenshotname;

	public static void captureScreenshot() throws IOException {

		Date d = new Date();

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		screenshotname = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\" + screenshotname));

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotname));

		// FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") +
		// "\\test-output\\" + screenshotname));
	}

}
