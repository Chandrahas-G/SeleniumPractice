package RahulShetty;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenCart {

	public static void main(String[] args) throws InterruptedException {

		String[] Items = { "Cucumber", "Beetroot", "Brocolli" };

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		AddItems(driver, Items);

		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		// Explicit wait
		WebDriverWait W = new WebDriverWait(driver, Duration.ofSeconds(5));
		W.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".promoInfo")));

		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());

		driver.close();

	}

	public static void AddItems(WebDriver driver, String[] Items) {

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {

			// Splitting name to match to declared array "Items"
			String ProductName = products.get(i).getText();
			String[] Product = ProductName.split("-");// converts to array after splitting
			String ItemName = Product[0].trim();// trim() removes spaces(" ") from string

			// converting array to arraylist for easy search & to use .contains method
			List ItemsNeeded = Arrays.asList(Items);

			if (ItemsNeeded.contains(ItemName)) {
				int j = 0;
				j++;
				driver.findElements(By.cssSelector(".product-action button")).get(i).click();
				// Thread.sleep(2000);

				if (j == Items.length) {// for array .length
					System.out.println(ItemsNeeded.size());// for arrayList .size
					break;
				}
			}
		}
	}
}
