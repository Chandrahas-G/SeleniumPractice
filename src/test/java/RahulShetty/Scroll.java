package RahulShetty;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scroll {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scroll(0,500)");
		Thread.sleep(1000);
		js.executeScript("document.querySelector('.tableFixHead').scroll(0,500)");
		
		List<WebElement> Values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int Sum = 0;
		for(int i=0; i<Values.size(); i++) {
			Sum = Sum+Integer.parseInt(Values.get(i).getText());
		}
		System.out.println(Sum); 
		
		int Total = Integer.parseInt(driver.findElement(By.cssSelector("div.totalAmount")).getText().split(":")[1].trim());
		
		Assert.assertEquals(Sum, Total);
		
		driver.close();
	}
}
