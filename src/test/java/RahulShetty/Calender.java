package RahulShetty;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calender {

	public static void main(String[] args) {

		// Storing values in Strings separately
		String Month = "12";
		String Date = "21";
		String Year = "1999";

		// Expected values in an Array of String
		String[] ExpectedValue = { "12", "21", "1999" };

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();

		driver.findElement(By.cssSelector(".react-date-picker__calendar-button__icon")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__prev-button")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__prev-button")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__prev-button")).click();
		driver.findElement(By.xpath("//button[text()='" + Year + "']")).click();
		driver.findElement(By.xpath("(//button[@class='react-calendar__tile react-calendar__year-view__months__month'])[" + Month + "]")).click();
		driver.findElement(By.xpath("//abbr[text()='" + Date + "']")).click();

		List<WebElement> SelectedValue = driver.findElements(By.cssSelector("input.react-date-picker__inputGroup__input"));

		// Matching each value, one by one with For loop
		for (int i = 0; i < SelectedValue.size(); i++) {

			// System.out.println("Selected is:
			// "+SelectedValue.get(i).getAttribute("value"));
			// System.out.println("Expected is: "+ExpectedValue[i]);

			Assert.assertEquals(SelectedValue.get(i).getDomAttribute("value"), ExpectedValue[i]);
		}
		driver.close();
	}

}
