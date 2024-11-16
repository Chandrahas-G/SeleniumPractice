package RahulShetty;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ResetPassword {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		//Thread.sleep(2000);
		String password = getPassword(driver);
		
		String Name = "Chandrahas";
		
		driver.findElement(By.id("inputUsername")).sendKeys(Name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		
		//System.out.println(driver.findElement(By.xpath("//div/h2")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//div/h2")).getText(), "Hello "+Name+",");	
		
		driver.close();
		
	}
	public static String getPassword(WebDriver driver) throws InterruptedException {

		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("button[class*='pwd']")).click();//taking some part of class from whole value by using *, only possible in CSSSelector
		String Text = driver.findElement(By.tagName("p")).getText();
		//Text is Please use temporary password 'rahulshettyacademy' to Login.
		String[] Text2 = Text.split("'");
		//After split() here Text2 are 2 parts, 2nd part is rahulshettyacademy' to Login.
		String password = Text2[1].split("'")[0];
		//splitting 2nd part of Text2 with ' and selecting 0th index for password.
		//System.out.println(password);
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		return password;
	}
}
