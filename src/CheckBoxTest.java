import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest extends Page{
	@Test
	public void doCB01() {
		// Open Homepage
		System.setProperty("webdriver.chrome.driver", "D:\\AUTO_TEST\\V1.0\\03Tools\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/");

		driver.manage().window().maximize();
		HomePage homePage = new HomePage(driver);
		// Click Element
		ElementsPage elementsPage = homePage.clickElements();
		// Click Checkbox menu
		elementsPage.clickCheckBoxMenu();
		
		CheckBoxPage checkBoxPage = elementsPage.clickCheckBoxMenu();
		Assert.assertTrue(checkBoxPage.isCheckBoxUnchecked(checkBoxPage.cbHomeCheckBox));
		
		checkBoxPage.clickOnHomeCheckBox();
		
		String expectedHomeStr = "You have selected : home desktop notes commands documents workspace react angular veu office public private classified general downloads wordFile excelFile";
		String actualHomeStr = checkBoxPage.getHomeStr();
		Assert.assertEquals(expectedHomeStr, actualHomeStr);
		checkBoxPage.clickOnIconExpand();
	}

}
