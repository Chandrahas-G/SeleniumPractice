package RahulShetty;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GeoLocation {

	public static void main(String[] args) throws Exception {

		// CHROME OPTIONS
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		Map<String, Object> profile = new HashMap<String, Object>();
		Map<String, Object> contentSettings = new HashMap<String, Object>();

		// 0 - Default, 1 - Allow, 2 - Block
		contentSettings.put("geolocation", 1);
		profile.put("managed_default_content_settings", contentSettings);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://the-internet.herokuapp.com/geolocation");
		driver.findElement(By.xpath("//*[@id='content']/div/button")).click();
		Thread.sleep(5000);
		driver.quit();
	}
}
