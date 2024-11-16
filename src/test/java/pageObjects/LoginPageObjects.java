package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObjects {

	WebDriver driver;

	By UserName = By.name("user-name");
	By Password = By.id("password");

	public LoginPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void EnterUserName(String text) {
		driver.findElement(UserName).sendKeys(text);
	}
	public void EnterPassword(String text) {
		driver.findElement(Password).sendKeys(text);;
	}
	public void ClickLoginButton() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
}
