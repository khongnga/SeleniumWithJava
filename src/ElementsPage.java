import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsPage extends Page {
	By menuTextBox = By.xpath("//span[text()='Text Box']");
	By menuCheckBox = By.xpath("//span[text()='Check Box']");
	
	public TextboxPage clickTextBoxMenu() {
		driver.findElement(menuTextBox).click();
		return new TextboxPage(driver);
	}
	
	public CheckBoxPage clickCheckBoxMenu () {
		driver.findElement(menuCheckBox).click();
		return new CheckBoxPage(driver);
	}
	
	public ElementsPage(WebDriver dr) {
		driver = dr;
	}

}
