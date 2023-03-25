package patanjaliTestCases;

import org.testng.annotations.Test;

import patanjaliPageObjects.KnowledgeBasePage;

public class KnowledgeBasePageTest extends BaseTest {

	@Test
	public void KnowledgeBaseLinkTest() throws InterruptedException {

		KnowledgeBasePage kbp = new KnowledgeBasePage(driver);
		kbp.knowledgeBaseLink();
	}
}
