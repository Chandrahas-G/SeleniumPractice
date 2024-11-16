package RahulShetty;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobilePurchase {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebDriverWait W = new WebDriverWait(driver, Duration.ofSeconds(2));
		LogIn(driver, W);
		AddItems(driver, W);
		driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();

	}

	public static void LogIn(WebDriver driver, WebDriverWait W) {

		driver.findElement(By.cssSelector("#username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("#password")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value='user']/following-sibling::span[@class='checkmark']")).click();
		
		// Explicit wait
		W.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn.btn-success")));
		driver.findElement(By.cssSelector("button.btn.btn-success")).click();

		// Dropdown
		Select Dropdown = new Select(driver.findElement(By.cssSelector("select.form-control")));
		Dropdown.selectByVisibleText("Consultant");

		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.cssSelector(".btn.btn-info.btn-md")).click();
	}

	public static void AddItems(WebDriver driver, WebDriverWait W) {

		W.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/angularpractice/shop"));

		// Adding Products to cart
		String[] Product = { "iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry" };
		List<String> Products = Arrays.asList(Product);

		List<WebElement> ItemText = driver.findElements(By.cssSelector(".col-lg-3.col-md-6.mb-3 h4.card-title"));

		for (int i = 0; i < ItemText.size(); i++) {
			String Items = ItemText.get(i).getText();

			if (Products.contains(Items)) {
				int j = 0;
				j++;
				driver.findElements(By.cssSelector(".btn.btn-info")).get(i).click();

				if (j == Product.length) {
					break;
				}
			}
		}
	}
}
