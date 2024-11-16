package RahulShetty;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaStreams {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		TableSort(driver);
		Filter(driver);
		
		driver.close();
	}

	public static void TableSort(WebDriver driver) {

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> List = driver.findElements(By.xpath("//tr/td[1]")); // stored list in List
		List<String> OriginalList = List.stream().map(s -> s.getText()).collect(Collectors.toList()); // get text from
																										// list
		List<String> SortedList = OriginalList.stream().sorted().collect(Collectors.toList()); // sorted the list
		OriginalList.forEach(a -> System.out.println(a)); // to print each value from Lists
		System.out.println(SortedList);
		Assert.assertTrue(OriginalList.equals(SortedList)); // method in assertion is used to check whether the 2 lists
															// are same.

//		// price of beans
//		List<String> Price = List.stream().filter(s->s.getText().contains("Beans"))
//				.map(s->Amount(s)).collect(Collectors.toList());
//		Price.stream().forEach(a->System.out.println(a));

		// To print price of item from next page.
		List<String> price;

		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> Amount(s))
					.collect(Collectors.toList());
			price.forEach(a -> System.out.println(a));
			if (price.size() < 1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		} while (price.size() < 1);
	}

	private static String Amount(WebElement s) {
		String Value = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return Value;
	}

	public static void Filter(WebDriver driver) {

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
		// 1 results
		List<WebElement> filteredList = veggies.stream().filter(veggie -> veggie.getText().contains("Rice"))
				.collect(Collectors.toList());
		// 1 result
		Assert.assertEquals(veggies.size(), filteredList.size());
	}
}
