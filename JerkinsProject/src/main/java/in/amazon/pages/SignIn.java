package in.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn {
	@FindBy(xpath = "//h1[contains(@class,'small')]")
	private WebElement signInText;

	@FindBy(id = "ap_email")
	private WebElement emailTextBox;
	@FindBy(id = "continue")
	private WebElement continueBtn;
	@FindBy(xpath = "//span[contains(@class,'a-list-item')]")
	private WebElement errMsg;

	public SignIn(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getSignInText() {
		String text = signInText.getText();
		return text;
	}
	public void enterEmail(String email) {
		emailTextBox.clear();
		emailTextBox.sendKeys(email);
		
	}
	public void clickContinueBtn() {
		continueBtn.click();
	}
	public String getErrMsg() {
		String message=errMsg.getText();
		return message;
		
	}
}
