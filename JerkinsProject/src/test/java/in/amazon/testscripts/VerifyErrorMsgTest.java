package in.amazon.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import in.amazon.pages.LandingPage;
import in.amazon.pages.SignIn;

public class VerifyErrorMsgTest extends BaseTest {

	@Test
	public void verifyErrorMsg() {
		LandingPage landingPage = new LandingPage(driver);
		landingPage.hoverOverHelloSignInMenu();
		// click on signin btn in menu

		landingPage.clickSignInBtn();
		SignIn signIn = new SignIn(driver);
		signIn.enterEmail("ani@gmail.com");
		signIn.clickContinueBtn();
		String expectedErrMsg = "We cannot find an account with that email address";
		String actualErrMsg = signIn.getErrMsg();
		Assert.assertEquals(actualErrMsg, expectedErrMsg);
	}

}
