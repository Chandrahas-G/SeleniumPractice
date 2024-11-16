package RahulShetty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		//HerokuApp(driver);
		DragAndDrop(driver);

	}
	
	public static void HerokuApp(WebDriver driver) {
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Nested Frames")).click();
		
		System.out.println(driver.findElements(By.tagName("frame")).size());
		
		driver.switchTo().frame(0);
		//driver.switchTo().frame(0);
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
		System.out.println(driver.findElement(By.cssSelector("div#content")).getText());
		//System.out.println(driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText());
		
		driver.close();

	}

	public static void DragAndDrop(WebDriver driver) {

		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();

		System.out.println(driver.findElements(By.tagName("iframe")).size());
		// driver.switchTo().frame(0); // Switching By Index
		driver.switchTo().frame(driver.findElement(By.tagName("iframe"))); // Switching By Element

		Actions a = new Actions(driver);
		a.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
		
		// To switch back out of Frame to Website
		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.xpath("//h2[contains(text(),'Examples')]")).isDisplayed());

		driver.close();
	}

}
