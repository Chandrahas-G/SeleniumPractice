package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageObjects {
	
	WebDriver driver;
	
	public HomePageObjects(WebDriver driver) {
	this.driver = driver;
	}

		By Menu = By.xpath("//button[@id='react-burger-menu-btn']");
		By CloseMenu = By.id("react-burger-cross-btn");
		By About = By.id("about_sidebar_link");
		By Checkout = By.xpath("//button[@id = 'checkout']");
		By Products = By.xpath("//span [contains(text(),Products) and @class = 'title']");
		By ShoppingCart = By.className("shopping_cart_link");
		By Backpack = By.id("add-to-cart-sauce-labs-backpack");
		By FirstName = By.name("firstName");
		By LastName = By.id("last-name");
		By PostalCode = By.xpath("//input[@name='postalCode']");
		By Continue = By.id("continue");
		By ItemName = By.className("inventory_item_name");
		By Finish = By.name("finish");
		By Thankyou = By.xpath("//h2[contains(text(),'Thank you for your order!')]");
		
		
		public void ClickMenu() {
			driver.findElement(Menu).click();
		}
		public void ClickCloseMenu() {
			driver.findElement(CloseMenu).click();
		}
		public void ClickAbout() {
			driver.findElement(About).click();
		}
		public void ClickCheckout() {
			driver.findElement(Checkout).click();
		}
		public void ProductsisVisible() {
			driver.findElement(Products).isDisplayed();
		}
		public void ClickShoppingCart() {
			driver.findElement(ShoppingCart).click();
		}
		public void AddBackpackToCart() {
			driver.findElement(Backpack).click();
		}
		public void EnterFirstName(String text) {
			driver.findElement(FirstName).sendKeys(text);
		}
		public void EnterLastName(String text) {
			driver.findElement(LastName).sendKeys(text);
		}
		public void EnterPostalCode(String text) {
			driver.findElement(PostalCode).sendKeys(text);
		}
		public void ClickContinue() {
			driver.findElement(Continue).click();
		}
		public void VerifyItemName() {
			driver.findElement(ItemName).isDisplayed();
		}
		public void ClickFinish() {
			driver.findElement(Finish).click();
		}
		public void VerifyThankyou() {
			driver.findElement(Thankyou).isDisplayed();
		}
}
