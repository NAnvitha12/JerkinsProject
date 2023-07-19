package in.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllMobileBrands {
	private Actions actions;
	@FindBy(linkText = "Mobiles & Accessories")

	private WebElement mobileandAccessories;
	@FindBy(linkText = "Apple")

	private WebElement apple;

	public AllMobileBrands(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	public void hoverOverMobilesAndAccessories() {
		actions.moveToElement(mobileandAccessories).build().perform();
	}

	public void clickApple() {
		apple.click();
	}
}
