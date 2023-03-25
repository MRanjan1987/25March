package rough;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import patanjaliTestCases.BaseTest;

public class A extends BaseTest {

	@Test
	public void AMethod() {

		test.log(LogStatus.INFO, "A");

	}
}
