import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page{
	
	By menuElementsXpath = By.xpath("//h5[text()='Elements']");
	
	public ElementsPage clickElements() {
		//Scroll down to endpage
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		//Click vào Element Item
		driver.findElement(menuElementsXpath).click();
		
		return new ElementsPage(driver);
	}

	//Dùng hàm khởi tạo (constructor) để truyền driver
	public HomePage(WebDriver dr) {
		driver = dr;
	}
}
