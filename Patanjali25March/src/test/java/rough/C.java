package rough;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import patanjaliTestCases.BaseTest;

public class C extends BaseTest {

	@Test
	public void CMethod() {

		test.log(LogStatus.INFO, "C");
	}

}
