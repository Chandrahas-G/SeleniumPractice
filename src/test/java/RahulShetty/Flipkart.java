package RahulShetty;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipkart {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://flipkart.com");
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector("div[aria-label='Electronics']"))).build().perform();
		a.click(driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/object[1]/a[8]"))).build().perform();

		driver.findElement(By.xpath("//div[text()='Brand']")).click();
		WebElement Dell = driver.findElement(By.xpath("//div[text()='DELL']"));
		driver.findElement(with(By.tagName("div")).toLeftOf(Dell)).click();
		List<WebElement> laptops = driver.findElements(By.xpath("//a[starts-with(@class,'CGtC98 fs-link')]/div[@class='Otbq5D']/following-sibling::div[@class='yKfJKb row']/div/div[@class='KzDlHZ']"));
		
		for(int i=0; i<laptops.size();i++) {
			System.out.println(laptops.get(i).getText());
		}
		
		
		driver.close();

	}
}
