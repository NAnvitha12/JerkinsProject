package in.amazon.testscripts;

import java.util.ArrayList;

import org.testng.Assert;

import org.testng.annotations.Test;

import in.amazon.pages.AllMobileBrands;
import in.amazon.pages.ApplePhones;
import in.amazon.pages.BuyPhone;
import in.amazon.pages.LandingPage;
import in.amazon.pages.SignIn;

public class BuyMobilePhoneTest extends BaseTest {

	@Test
	public void buyMobile() {
		// click on mobiles in navigation bar
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickMobiles();
		// hover the pointer over mobiles and accessories
		AllMobileBrands allMobileBrands = new AllMobileBrands(driver);
		allMobileBrands.hoverOverMobilesAndAccessories();
		// click on apple in the sub menu
		allMobileBrands.clickApple();
		// click on first available phone
		ApplePhones applePhones = new ApplePhones(driver);
		applePhones.clickFirstMobile();
		// switch focus on new tab
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		// click on buy now button
		BuyPhone buyPhone = new BuyPhone(driver);
		buyPhone.clickBuyNowBtn();
		// verify user text sign in last page
		SignIn signIn = new SignIn(driver);
		String expectedText = "Sign in";
		String actualText = signIn.getSignInText();
		Assert.assertEquals(actualText, expectedText);
	}

}
