package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private static WebElement element = null;
	
	public static WebElement username(WebDriver driver) {
		element = driver.findElement(By.name("user-name"));
		return element;
	}
	public static WebElement password(WebDriver driver) {
		element = driver.findElement(By.id("password"));
		return element;
	}
	public static WebElement LoginButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@type='submit']"));
		return element;
	}
}
