import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxPage extends Page{

	By cbHomeCheckBox = By.xpath("//label[@for='tree-node-home']/span[1]/*[name()='svg']");
	By lbHomes = By.xpath("//div[@id='result']/span");
	By btnIconExpand = By.xpath("//button[@class='rct-collapse rct-collapse-btn']");

	public CheckBoxPage(WebDriver dr) {
		driver = dr;
	}
	
	public Boolean isCheckBoxUnchecked(By locator) {
		boolean result = true;
		String cssClassValue = driver.findElement(locator).getAttribute("class");
		if(!cssClassValue.contains("uncheck")) {
			result = false;
		}
		return result;
	}
	
	public void clickOnHomeCheckBox() {
		driver.findElement(cbHomeCheckBox).click();
	}
	
	public String getHomeStr() {
		String result = "";
		List<WebElement> lbHomeElements = driver.findElements(lbHomes);
		for(WebElement e :lbHomeElements) {
			result = result + e.getText() + " "; //Nối các result lại
		}
		return result.trim(); //Cắt space ở 2 đầu
	}
	
	public void clickOnIconExpand() {
		driver.findElement(btnIconExpand).click();
	}

}
