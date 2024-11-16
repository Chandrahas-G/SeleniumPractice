package RahulShetty;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadFile {

	public static void main(String[] args) throws Exception {

		String downloadPath = System.getProperty("user.dir");
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.ilovepdf.com/word_to_pdf");

		fileUpload(driver);
		fileDownload(driver, downloadPath);

		driver.close();
	}

	public static void fileUpload(WebDriver driver) throws Exception {

		driver.findElement(By.cssSelector("a.uploader__btn")).click();
		Thread.sleep(1000);

		// uploading file using AutoIt
//		'Au3info', to record window component objects
//		Build Script with editor 'scite.exe'
		// ControlFocus("Open", "", "Edit1")
		// ControlSetText("Open", "", "Edit1", "C:\Users\chand\Documents\Chandrahas G
		// Resume.docx")
		// ControlClick("Open", "", "Button1")
//		Save the script file with '.au3' extension
//		Convert file into '.exe' by compiling .au3 file
//		Call .exe file with Runtime class in java into your selenium tests

		String[] file = { "C:\\Users\\chand\\Documents\\UploadFile.exe", "" };
		Runtime.getRuntime().exec(file);
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.cssSelector("span#processTaskTextBtn")).getText());
	}

	public static void fileDownload(WebDriver driver, String downloadPath) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span#processTaskTextBtn")));
		driver.findElement(By.cssSelector("span#processTaskTextBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a#pickfiles")));
		driver.findElement(By.cssSelector("a#pickfiles")).click();
		Thread.sleep(5000);

		File f = new File(downloadPath + "/Chandrahas G Resume.pdf");
		Assert.assertTrue(f.exists());
		if (f.delete())
			System.out.println("file deleted");
	}
}