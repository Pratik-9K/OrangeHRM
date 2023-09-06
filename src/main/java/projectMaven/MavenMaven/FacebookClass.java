package projectMaven.MavenMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FacebookClass {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		driver.findElement(By.id("email")).sendKeys("pratik123@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("pass")).sendKeys("Pratik@1234");
		Thread.sleep(1000);
		
		driver.close();
		

	}

}
