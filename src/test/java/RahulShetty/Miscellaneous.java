package RahulShetty;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

public class Miscellaneous {

	public static void main(String[] args) throws IOException, URISyntaxException {

		// SSLCheck();
		// Screenshot();
		BrokenLink();
	}

	public static void SSLCheck() {

		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
	}

	public static void Screenshot() throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies(); // delete coockies
		// driver.manage().deleteCookieNamed("sessionKey");
		driver.manage().window().maximize();
		driver.get("https://google.com");

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\chand\\screenshot.png"));

		driver.close();

	}

	public static void BrokenLink() throws IOException, URISyntaxException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert a=new SoftAssert(); // soft assertions won't make the scripts stop abruptly, it continues until script completed.
		for (WebElement link : links) {

			String url = link.getDomAttribute("href");

			HttpURLConnection conn = (HttpURLConnection) new URI(url).toURL().openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			
			a.assertTrue(respCode<400, link.getText()+" link is Broken with code "+respCode);

//			if (respCode > 400) {
//
//				System.out.println(link.getText() + respCode);
//				Assert.assertTrue(false);
//			}
		}
		a.assertAll(); // scripts will fail if the assert have stored any failures.
		driver.close();

	}
}
