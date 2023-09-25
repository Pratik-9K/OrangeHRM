package project1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class Baseclass {

	WebDriver driver;
	Homepage use;
	 
	 
	 @BeforeMethod
		public void startBrowser() throws Exception {
			System.setProperty("webdriver.chrome.driver", 
					"E:\\ST by Manas\\JARs\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		@AfterMethod
		public void closeBrowser() {
			driver.close();
		}
}
