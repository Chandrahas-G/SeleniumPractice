package RahulShetty;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Links {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		//GetTitles(driver);
		GetTitles2(driver);

	}

	public static void GetTitles(WebDriver driver) {

		// Total Number of Links present in Wesite
		System.out.println(driver.findElements(By.tagName("a")).size());

		WebElement footer = driver.findElement(By.cssSelector("div#gf-BIG"));
		// Total Number of Links Under footer section
		System.out.println(footer.findElements(By.tagName("a")).size());

		WebElement courses = footer.findElement(By.xpath("//td[1]/ul"));
		System.out.println(courses.findElements(By.tagName("a")).size());

		for (int i = 1; i < (courses.findElements(By.tagName("a")).size()); i++) {
			Actions a = new Actions(driver);
			a.moveToElement(courses.findElements(By.tagName("a")).get(i)).keyDown(Keys.CONTROL).click().build()
					.perform();
		}

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		// Moving to Next Window
		it.next();
		// Starts printing only child's Window titles
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

		driver.quit();
	}

	public static void GetTitles2(WebDriver driver) {
		
		WebElement footer = driver.findElement(By.cssSelector("div#gf-BIG"));
		WebElement courses = footer.findElement(By.xpath("//td[1]/ul"));
		List<WebElement> courseLinks = courses.findElements(By.tagName("a"));
		
		for(int i=0; i<courseLinks.size(); i++) {
			courseLinks.get(i).click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			wait.until(ExpectedConditions.titleIs(driver.getTitle()));
			
			System.out.println(driver.getTitle());
			driver.navigate().back();
			wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
			
			courseLinks = courses.findElements(By.tagName("a"));			
		}
	}
}
