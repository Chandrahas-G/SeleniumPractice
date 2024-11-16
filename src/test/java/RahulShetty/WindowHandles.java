package RahulShetty;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowHandles {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		// WindowHandle(driver);
		WindowHandle2(driver);
		// HerokuApp(driver);

		driver.close();
	}

	public static void WindowHandle(WebDriver driver) {

		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector(".blinkingText")).click();

		Set<String> windows = driver.getWindowHandles(); // [parentid,childid,subchildId]
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();

		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim()
				.split(" ")[0];
		System.out.println(emailId);

		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(emailId);

		driver.quit();
	}

	public static void WindowHandle2(WebDriver driver) {

		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector(".blinkingText")).click();

		Set<String> Windows = driver.getWindowHandles();

		List<String> WindowIDs = new ArrayList<String>(Windows);
		String ParentID = WindowIDs.get(0);
		String ChildID = WindowIDs.get(1);

		driver.switchTo().window(ChildID);
		String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim()
				.split(" ")[0];
		System.out.println(emailId);
		
		driver.switchTo().window(ParentID);
		driver.findElement(By.id("username")).sendKeys(emailId);

		driver.quit();
	}

	public static void HerokuApp(WebDriver driver) {

		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();

		// Actions class
		Actions a = new Actions(driver);

		a.moveToElement(driver.findElement(By.linkText("Multiple Windows"))).click().build().perform();
		a.click(driver.findElement(By.xpath("//a[text()='Click Here']"))).build().perform();

		// Window Handling
		Set<String> Windows = driver.getWindowHandles();
		Iterator<String> Iterate = Windows.iterator();
		String ParentWindow = Iterate.next();
		// String ChildWindow = Iterate.next();

		driver.switchTo().window(Iterate.next());
		System.out.println(driver.findElement(By.cssSelector("div h3")).getText());

		driver.switchTo().window(ParentWindow);
		System.out.println(driver.findElement(By.cssSelector("div h3")).getText());

		// driver.close();
		driver.quit();
	}
}