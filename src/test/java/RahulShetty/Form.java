package RahulShetty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Form {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//input[@name='name'])[1]")).sendKeys("Chandrahas");
		driver.findElement(By.name("email")).sendKeys("Chandrahas@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Micky@021");
		driver.findElement(By.id("exampleCheck1")).click();

		// Dropdown
		WebElement Dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select Gender = new Select(Dropdown);
		Gender.selectByVisibleText("Male");

		driver.findElement(By.id("inlineRadio2")).click();
		driver.findElement(By.name("bday")).sendKeys("30071999");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".btn.btn-success")).click();

		// Success! The Form has been submitted successfully!.

		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());

		driver.close();
	}

}
