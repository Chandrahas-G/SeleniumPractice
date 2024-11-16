package saucedemo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;

public class SDOrderItem {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// created object as "Item"
		SDOrderItem Item = new SDOrderItem();
		Item.SauceDemoLogIn();
		SauceDemoCheckout();
		CloseBrowser();
	}

	// below method doesn't have static type, so need to create an object in main method to call this method
	public void SauceDemoLogIn() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");

		LoginPageObjects LoginPage = new LoginPageObjects(driver);

		LoginPage.EnterUserName("standard_user");
		LoginPage.EnterPassword("secret_sauce");
		LoginPage.ClickLoginButton();
		Thread.sleep(1000);
	}

	public static void SauceDemoCheckout() throws InterruptedException {

		HomePageObjects HomePage = new HomePageObjects(driver);

		HomePage.ClickMenu();
		Thread.sleep(500);
		HomePage.ClickCloseMenu();
		HomePage.ProductsisVisible();
		HomePage.AddBackpackToCart();
		HomePage.ClickShoppingCart();
		HomePage.ClickCheckout();
		HomePage.EnterFirstName("Chandrahas");
		HomePage.EnterLastName("G");
		HomePage.EnterPostalCode("500092");
		HomePage.ClickContinue();
		HomePage.VerifyItemName();
		HomePage.ClickFinish();
		HomePage.VerifyThankyou();
	}

	public static void CloseBrowser() {

		driver.close();
		driver.quit();
	}
}