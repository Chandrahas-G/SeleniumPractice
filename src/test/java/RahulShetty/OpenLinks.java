package RahulShetty;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenLinks {

	public static void main(String[] args) {
		// Set the path for the ChromeDriver
		// System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

		// Create a new instance of the Chrome driver
		WebDriver driver = new ChromeDriver();

		try {
			// Go to the main page
			driver.get("https://rahulshettyacademy.com/AutomationPractice");

			// Find all links on the main page (update the selector as needed)
			// Update XPath as necessary
			WebElement footer = driver.findElement(By.cssSelector("div#gf-BIG"));
			WebElement courses = footer.findElement(By.xpath("//td[1]/ul"));
			List<WebElement> courseLinks = courses.findElements(By.tagName("a"));
			// Loop through each link
			for (WebElement link : courseLinks) {
				// Store the link text and click it
				String linkText = link.getText();
				link.click();

				// Wait for the page to load
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
				wait.until(ExpectedConditions.titleIs(driver.getTitle()));

				// Get the title of the current page
				String pageTitle = driver.getTitle();
				System.out.println("Title of page '" + linkText + "': " + pageTitle);

				// Go back to the main page
				driver.navigate().back();

				// Wait for the main page to load again
				wait.until(ExpectedConditions.titleContains("Practice Page")); // Update this

				// Re-find all links to avoid stale element reference
				courseLinks = courses.findElements(By.tagName("a")); // Update XPath as necessary
			}
		} finally {
			// Close the main window
			driver.quit();
		}
	}
}