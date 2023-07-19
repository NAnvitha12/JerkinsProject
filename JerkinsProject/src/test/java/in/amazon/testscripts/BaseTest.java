package in.amazon.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	WebDriver driver;

	@BeforeTest
	public void launchApplication() {
		// open browser
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
