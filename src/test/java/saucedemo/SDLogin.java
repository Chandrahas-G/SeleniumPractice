package saucedemo;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPageObjects;

public class SDLogin {

	//	public static void main(String[] args) {
	//		SauceDemoLogin();
	//	}
	static WebDriver driver;
	@BeforeTest
	public static void SetUpTest() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void SauceDemoLogin() {

		driver.get("https://www.saucedemo.com/");

		LoginPageObjects LoginPage = new LoginPageObjects(driver);

		LoginPage.EnterUserName("problem_user");
		LoginPage.EnterPassword("secret_sauce");
		LoginPage.ClickLoginButton();
	}

	@AfterTest
	public void CloseBrowser() {
		
		driver.close();
		driver.quit();
		System.out.println("Test Completed");

	}

}
