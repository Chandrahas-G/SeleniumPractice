package RahulShetty;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabSwitch {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		// Open new blank Tab
		driver.switchTo().newWindow(WindowType.TAB); // can open a New WINDOW as well.

		Set<String> Windows = driver.getWindowHandles();
		Iterator<String> it = Windows.iterator();
		String Window1 = it.next();
		String Window2 = it.next();

		driver.switchTo().window(Window2);
		driver.get("https://rahulshettyacademy.com/");
		String CourseName = driver.findElements(By.cssSelector("a[href*='rahulshettyacademy.com/p']")).get(3).getText();

		driver.switchTo().window(Window1);
		WebElement Name = driver.findElement(By.xpath("//input[@name='name']"));
		Name.sendKeys(CourseName);

		// Taking screenshot of a Web element.
		File file = Name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("Name.jpg"));

		// Get Height & Width
		System.out.println(Name.getRect().getHeight());
		System.out.println(Name.getRect().getWidth());

		driver.quit();

	}
}
