package RahulShetty;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PracticePage {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		// Tables(driver);
		// DynamicElements(driver);
		 Alerts(driver);
		// CheckBox(driver);
		// SuggestiveDropdown2(driver);

		driver.close();
	}
	
	public static void SuggestiveDropdown2(WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.id("autocomplete")).sendKeys("United");
		Thread.sleep(1000);	
		
		List<WebElement> options = driver.findElements(By.className("ui-menu-item"));
		for(WebElement option: options) {
			if(option.getText().equals("United Kingdom (UK)")) {
				option.click();	
				break;	
				}
			}
		System.out.println(driver.findElement(By.cssSelector("input#autocomplete")).getDomAttribute("value"));
	}
	
	public static void SuggestiveDropdown(WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.cssSelector("input#autocomplete")).sendKeys("Ind");
		Thread.sleep(1000);
		
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//div[@class='ui-menu-item-wrapper' and text()='India']"))).click().build().perform();
		//Thread.sleep(1000);
		
		System.out.println(driver.findElement(By.cssSelector("input#autocomplete")).getDomAttribute("value"));
		
	}
	
	public static void Tables(WebDriver driver) {
		
		System.out.println("Total No. of Rows are: "+driver.findElements(By.cssSelector("table.table-display td:nth-child(1)")).size());
		System.out.println("Total No. of Columns are: "+driver.findElements(By.cssSelector("table.table-display th")).size());
		
		List<WebElement> RowData = driver.findElements(By.cssSelector("table.table-display tr:nth-child(3) td"));
		
		for (int i=0; i<RowData.size(); i++) {
			System.out.println(RowData.get(i).getText());
		}
	}

	public static void DynamicElements(WebDriver driver) {

		String CheckBox = "checkBoxOption1";

		driver.findElement(By.id("" + CheckBox + "")).click(); // id("checkBoxOption1")

		String Text = driver.findElement(By.xpath("//*[@id='" + CheckBox + "']/parent::label")).getText(); // xpath("//*[@id='checkBoxOption1']/parent::label")
		System.out.println(Text);

		Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropdown.selectByVisibleText(Text);

		driver.findElement(By.name("enter-name")).sendKeys(Text);
		driver.findElement(By.id("alertbtn")).click();

		String AlertText = driver.switchTo().alert().getText().split(",")[0].split(" ")[1];
		System.out.println(AlertText);
		driver.switchTo().alert().accept();

		Assert.assertEquals(Text, AlertText);

	}

	public static void Alerts(WebDriver driver) {

		// Simple Alert
		driver.findElement(By.id("name")).sendKeys("Chandu");
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		// Confirmation Alert
		driver.findElement(By.id("name")).sendKeys("Micky");
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
	}

	public static void CheckBox(WebDriver driver) throws InterruptedException {

		WebElement FirstCheckBox = driver.findElement(By.id("checkBoxOption1"));
		FirstCheckBox.click();
		Assert.assertTrue(FirstCheckBox.isSelected());
		Thread.sleep(1000);
		FirstCheckBox.click();
		Assert.assertFalse(FirstCheckBox.isSelected());

		// Number of Checkboxes
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
	}
}
