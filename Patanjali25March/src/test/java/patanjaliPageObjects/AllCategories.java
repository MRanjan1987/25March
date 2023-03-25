package patanjaliPageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllCategories extends BasePage {

	public AllCategories(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath = "//a[contains(text(),'All Categories')]")
	public WebElement AllCategoryLink;


	@FindBy(xpath = "//li[@class='dropdown-submenu']//a[contains(text(),'Natural Health Care')]")
	public WebElement NaturalHealth;
	@FindBy(xpath = "//ul[@class='dropdown-menu list-unstyled no-shadow img2 menu1']/li")
	List<WebElement> listNaturalHealthCareSubmenue;

	public void NaturalHealth() throws InterruptedException {

		ThreeTierSubMenue(AllCategoryLink, NaturalHealth, listNaturalHealthCareSubmenue);
	}

	
	@FindBy(xpath = "//li[@class='dropdown-submenu']//a[contains(text(),'Natural Food Products')]")
	public WebElement NaturalFoodProducts;
	@FindBy(xpath = "//ul[@class='dropdown-menu list-unstyled no-shadow img2 menu2']/li")
	List<WebElement> ListNaturalFoodProducts;

	public void NatualFoodProducts() throws InterruptedException {

		ThreeTierSubMenue(AllCategoryLink, NaturalFoodProducts, ListNaturalFoodProducts);

	}

	@FindBy(xpath = "//li[@class='dropdown-submenu']//a[contains(text(),'Ayurvedic Medicine')]")
	public WebElement AyurvedicMedicine;
	@FindBy(xpath = "//ul[@class='dropdown-menu list-unstyled no-shadow img2 menu3']/li")
	List<WebElement> ListAyurvedicMedicineLink;

	public void AyurvedicMedicine() throws InterruptedException {

		ThreeTierSubMenue(AllCategoryLink, AyurvedicMedicine, ListAyurvedicMedicineLink);
	}

	@FindBy(xpath = "//li[@class='dropdown-submenu']//a[contains(text(),'Herbal Home Care')]")
	public WebElement HerbalHomeCare;
	@FindBy(xpath = "//ul[@class='dropdown-menu list-unstyled no-shadow img2 menu4']/li")
	List<WebElement> ListHerbalHomeCareLink;

	public void HerbalHomeCare() throws InterruptedException {

		ThreeTierSubMenue(AllCategoryLink, HerbalHomeCare, ListHerbalHomeCareLink);
	}

	@FindBy(xpath = "//li[@class='dropdown-submenu']//a[contains(text(),'Natural Personal Care')]")
	public WebElement NaturalPersonalCare;
	@FindBy(xpath = "//ul[@class='dropdown-menu list-unstyled no-shadow img2 menu5']/li")
	List<WebElement> LinkNaturalPersonalCareLink;

	public void NaturalPersonalCare() throws InterruptedException {

		ThreeTierSubMenue(AllCategoryLink, NaturalPersonalCare, LinkNaturalPersonalCareLink);
	}

	@FindBy(xpath = "//li[@class='dropdown-submenu']//a[contains(text(),'Patanjali Publication')]")
	public WebElement PatanjaliPublication;
	@FindBy(xpath = "//ul[@class='dropdown-menu list-unstyled no-shadow img2 menu6']/li")
	List<WebElement> LinkPatanjaliPublication;

	public void PatanjaliPublication() throws InterruptedException {

		ThreeTierSubMenue(AllCategoryLink, PatanjaliPublication, LinkPatanjaliPublication);
	}

}
