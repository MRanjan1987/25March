package patanjaliPageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KnowledgeBasePage extends BasePage {

	public KnowledgeBasePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[contains(text(),'Knowledge Base')]")
	public WebElement knowledgeBase;

	@FindBy(xpath = "//ul[@class='dropdown-menu list-unstyled  fadeInUp animated']/li/a")
	List<WebElement> knowledgeBaseSubMenuLinks;

	public void knowledgeBaseLink() throws InterruptedException {

		OneTierSubMenue(knowledgeBase, knowledgeBaseSubMenuLinks);
		
	}
}
