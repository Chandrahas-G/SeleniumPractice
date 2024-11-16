package RahulShetty;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowPopup {

	public static void main(String[] args) {

		// https://the-internet.herokuapp.com
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// providing credentials in the URL for window authentication pop-up
		driver.get("https://admin:admin@the-internet.herokuapp.com");
		driver.findElement(By.linkText("Basic Auth")).click();
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'Congratulations!')]")).getText());
		driver.close();
	}
}
