package saucedemo;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.LoginPage;

public class Checkout {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 

		driver.get("https://www.saucedemo.com/");

		LoginPage.username(driver).sendKeys("problem_user");
		LoginPage.password(driver).sendKeys("secret_sauce");
		LoginPage.LoginButton(driver).click();

		WebElement Products = driver.findElement(By.xpath("//span [contains(text(),Products) and @class = 'title']"));

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOf(Products));

		driver.findElement(By.xpath("//button[contains(text(),'Add to cart') and @id = 'add-to-cart-sauce-labs-backpack']")).click();
		driver.findElement(By.xpath("//a[@class = 'shopping_cart_link']")).click();
		//Above class x-path can be written as below as well.
		//driver.findElement(By.className("shopping_cart_link")).click();
		driver.findElement(By.xpath("//button[@id = 'checkout']")).click();
		driver.findElement(By.name("firstName")).sendKeys("Chandu");
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("500092");
		driver.findElement(By.id("continue")).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='error-message-container error']"))));

		System.out.println("Error");

		//String mainWindow = driver.getWindowHandle();
		//System.out.println(mainWindow);	
		driver.close();
		driver.quit();
	}

}