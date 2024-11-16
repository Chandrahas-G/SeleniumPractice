package saucedemo;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import pageObjects.LoginPageObjects;

public class SwitchWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// with enhanced for loop

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		LoginPageObjects LoginPage = new LoginPageObjects(driver);

		LoginPage.EnterUserName("problem_user");
		LoginPage.EnterPassword("secret_sauce");
		LoginPage.ClickLoginButton();

		String MainWindow = driver.getWindowHandle();

		// System.out.println(MainWindow);

		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		Thread.sleep(2000);

		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id("about_sidebar_link"))).keyDown(Keys.CONTROL).click().build().perform();

		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {
			// System.out.println("for "+window);
			if (window != MainWindow) {
				// System.out.println("if "+window);
				driver.switchTo().window(window);
			}
		}

		System.out.println(driver.findElement(By.cssSelector("h2.MuiTypography-h3")).getText());
		driver.switchTo().window(MainWindow);
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	}

}
