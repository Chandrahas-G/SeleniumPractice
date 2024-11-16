package RahulShetty;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SpiceJet {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();

		FromTo(driver);
		DepartureDate(driver);
		PassengersCount(driver);
		Currency(driver);
		PassengerType(driver);
		driver.findElement(By.xpath("//div[text()='Search Flight']//parent::div[@data-testid='home-page-flight-cta']")).click();
		System.out.println("Search Results are here.");

		driver.close();
	}

	public static void RoundTrip(WebDriver driver) {

		//radio button
		driver.findElement(By.xpath("//div[text()='round trip']//parent::div[@class='css-1dbjc4n']//preceding-sibling::div[@class='css-1dbjc4n r-zso239']//*[name()='svg']//*[name()='circle' and contains(@cx,'9')]")).click();
		//checking of Return Date calender is enabled
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Return Date']")).getAttribute("style").contains("1"));
	}

	public static void FromTo(WebDriver driver) throws InterruptedException {

		//Dynamic dropdown
		driver.findElement(By.xpath("//div[text()='From']")).click();
		driver.findElement(By.xpath("//div[text()='HYD']")).click();//selecting HYD from Dropdown

		//Auto-suggestive dropdown
		driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[2]")).sendKeys("DE");//same xpath, 2nd index
		Thread.sleep(1000);

		List<WebElement> Options = driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-ov7bg r-z2wwpe r-utggzx r-atwnbb r-cfp7ip']"));
		for (WebElement option : Options) {
			if (option.getText().equalsIgnoreCase("DEL")) {
				option.click();
				break;
			}
		}
	}

	public static void DepartureDate(WebDriver driver) {

		//selecting current date
		driver.findElement(By.cssSelector(".css-1dbjc4n.r-1awozwy.r-19m6qjp.r-156aje7.r-y47klf.r-1phboty.r-1d6rzhh.r-1pi2tsx.r-1777fci.r-13qz1uu")).click();
	}

	public static void ReturnDate(WebDriver driver) {


	}

	public static void PassengersCount(WebDriver driver) throws InterruptedException {

		//dropdown with loop
		WebElement PassengersDropdown = driver.findElement(By.xpath("//div[text()='Passengers']//following-sibling::div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']"));
		PassengersDropdown.click();
		Thread.sleep(1000);

		/*int i=1;
		while(i<5)
		{
		driver.findElement(By.id("hrefIncAdt")).click();
		i++;
		}*/

		//System.out.println(PassengersDropdown.getText());
		//Adding 3 passengers
		for(int i=1;i<3;i++)
		{
			WebElement AddPassengers = driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']"));
			AddPassengers.click();
		}
	}

	public static void Currency(WebDriver driver) throws InterruptedException {

		//static dropdown
		WebElement SelectDropdown = driver.findElement(By.xpath("//div[text()='Currency']/following-sibling::div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']"));

		SelectDropdown.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='USD']")).click();
		Thread.sleep(2000);
		//System.out.println(SelectDropdown.getText());

		//for Select dropdown 
		/*WebElement DropdownMenu = driver.findElement(By.xpath("//div[text()='Currency']/following-sibling::div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']"));

		Select Dropdown = new Select(DropdownMenu);
		Dropdown.selectByIndex(3);
		Dropdown.selectByValue("IND");
		Dropdown.selectByVisibleText("USD");*/
	}

	public static void PassengerType(WebDriver driver) throws InterruptedException {

		//checkbox
		WebElement SeniorCitizen = driver.findElement(By.xpath("//div[text()='Senior Citizen']//parent::div[@class='css-1dbjc4n']//preceding-sibling::div[@class='css-1dbjc4n']//*[@width='18']//*[@r='8']"));
		SeniorCitizen.click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[@class='css-1dbjc4n' and @style='flex: 0.7 1 0%; padding-top: 7px; padding-bottom: 7px; -webkit-box-flex: 0.7;']")).click();
	}
}