import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
//import org.testng.asserts.*;

public class TextBoxTest extends Page {

	public static void main(String[] args) {
		TextBoxTest testCase = new TextBoxTest();
		testCase.doTC01();
	}

	/**
	 * TextBox - TC01
	 */

	@Test
	public void doTC01() {
		// Open HomePage
		System.setProperty("webdriver.chrome.driver", "D:\\AUTO_TEST\\V1.0\\03Tools\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/"); // Mở trang chủ
		driver.manage().window().maximize();

		// Click vào phần tử Element trên trang Home
		HomePage homePage = new HomePage(driver);
		
		// Click vào phần tử Textbox
		ElementsPage elementsPage = homePage.clickElements();
		elementsPage.clickTextBoxMenu();
		
		// Input data
		TextboxPage textBox = elementsPage.clickTextBoxMenu();
		String inputFullName = "KhongNga";
		String inputEmail = "KhongNga@gmail.com";
		String inputCurrentAddress = "Ha Noi";
		String inputPermanentAddress = "HaNoi";
		textBox.inputFullName(inputFullName);
		textBox.inputEmail(inputEmail);
		textBox.inputCurrentAddress(inputCurrentAddress);
		textBox.inputPermanentAddress(inputPermanentAddress);
		
		//Scroll đến cuối trang
		//textBox.scrollToEndPage(); 
		
		//Scroll đến một phần tử nào đó
		textBox.scrollToElement(textBox.findElementByLocator(textBox.btnSubmit));
		
		//Click button submit
		textBox.clickOnSubmit();

		//Assert.assertTrue(textBox.isCheckEmail(textBox.txtEmail));
		
		//So sánh kết quả
		String actualFullName = textBox.getTextResult(textBox.lbFullName);
		String actualEmail = textBox.getTextResult(textBox.lbEmail);
		String actualCurrentAddress = textBox.getTextResult(textBox.lbCurrentAddress);
		String actualPermanentAddress = textBox.getTextResult(textBox.lbPermanentAddress);

		Assert.assertEquals(actualFullName, inputFullName);
		Assert.assertEquals(actualEmail, inputEmail);
		Assert.assertEquals(actualCurrentAddress, inputCurrentAddress);
		Assert.assertEquals(actualPermanentAddress, inputPermanentAddress);
	}

}
