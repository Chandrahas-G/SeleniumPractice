package saucedemo;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicLogin {

	public static void main(String[] args) throws InterruptedException {

		//WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); 

		driver.get("https://www.saucedemo.com/");

		WebElement UserName = driver.findElement(By.name("user-name"));
		//WebElement Password = driver.findElement(By.id("password"));
		UserName.sendKeys("problem_user");

		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(1000);

		WebElement LoginButton = driver.findElement(By.xpath(("//input[@type='submit']")));
		LoginButton.sendKeys(Keys.ENTER);

		//driver.switchTo().frame("mainpanel");

		WebElement Menu = driver.findElement(By.xpath(("//button[@id='react-burger-menu-btn']")));
		//used CSS selector and regular expression(*) to specify only some part of the attribute's value
		WebElement About = driver.findElement(By.cssSelector("a[id*='about']"));
		//WebElement CloseMenu = driver.findElement(By.xpath(("//button[@id='react-burger-cross-btn']")));

		Menu.click();
		About.click();

		String URL = driver.getCurrentUrl();
		System.out.println(URL);
		
		//System.out.println(driver.getPageSource());

		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2));
		//wait.until(ExpectedConditions.visibilityOf(SearchBox));

		//String mainWindow = driver.getWindowHandle();
		//System.out.println(mainWindow);	
		driver.close();
		driver.quit();
	}
}
