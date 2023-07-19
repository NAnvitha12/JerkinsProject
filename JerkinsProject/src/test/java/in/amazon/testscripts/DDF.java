package in.amazon.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import in.amazon.pages.LandingPage;
import in.amazon.pages.SignIn;
import utils.ReadExcel;

public class DDF extends BaseTest {

	@Test
	public void verifyErrorMsg() throws IOException {
		LandingPage landingPage = new LandingPage(driver);
		landingPage.hoverOverHelloSignInMenu();
		// click on signin btn in menu

		landingPage.clickSignInBtn();
		String[][] data=ReadExcel.getData("resources//TestData.xlsx", "Sheet1");
		for (int i = 1;i < 5; i++) {
		String username=data[i][1];
		SignIn signIn = new SignIn(driver);
		signIn.enterEmail(username);
		signIn.clickContinueBtn();
		String expectedErrMsg = "We cannot find an account with that email address";
		String actualErrMsg = signIn.getErrMsg();
		Assert.assertEquals(actualErrMsg, expectedErrMsg);
	}
	}
}
