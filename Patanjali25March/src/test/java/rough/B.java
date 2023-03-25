package rough;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import patanjaliTestCases.BaseTest;

public class B extends BaseTest {

	@Test
	public void BMethod() throws IOException {

		test.log(LogStatus.INFO, "B");
	}
}
