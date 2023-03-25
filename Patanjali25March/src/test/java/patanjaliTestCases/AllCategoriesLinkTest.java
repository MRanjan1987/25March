package patanjaliTestCases;

import org.testng.annotations.Test;

import patanjaliPageObjects.AllCategories;

public class AllCategoriesLinkTest extends BaseTest {

	@Test()
	public void AllCategoryLinksTest() throws InterruptedException {

		AllCategories ac = new AllCategories(driver);

		ac.NaturalHealth();
		ac.NatualFoodProducts();
		ac.AyurvedicMedicine();
		ac.HerbalHomeCare();
		ac.NaturalPersonalCare();
		ac.PatanjaliPublication();

	}
		
}
