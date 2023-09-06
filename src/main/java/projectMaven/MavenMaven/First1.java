package projectMaven.MavenMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class First1 {

WebDriver driver;
	
	@BeforeTest
	public void launchApp() throws Exception {
		
		 driver = new EdgeDriver();
		driver.get("https://fast.com/");
		driver.manage().window();
		Thread.sleep(15000);
	}
	
	@Test
	public void speedTest() {
		WebElement Speed = driver.findElement(By.cssSelector("div[id='speed-value']"));
		WebElement speedUnit = driver.findElement(By.cssSelector("div[id='speed-units']"));
		
		System.out.println("Internet Speed is: "+Speed.getText()+" "+speedUnit.getText());
	}
	
	@AfterTest
	public void closeApp() {
		driver.close();
	}

}
