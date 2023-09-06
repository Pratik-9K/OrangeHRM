package project1;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Credentials {
	
	WebDriver driver;
	OrHRMElementso a = new OrHRMElementso();
	
	@BeforeMethod
	public void LaunchPIM() throws Exception {
		driver = new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window();
		Thread.sleep(1000);
		
		driver.findElement(a.huid).sendKeys("Admin");
		driver.findElement(a.hpwd).sendKeys("admin123");
		driver.findElement(a.hlogbt).click();
		Thread.sleep(500);
		
		driver.findElement(a.pim).click();
		Thread.sleep(1500);
		driver.findElement(a.addemp).click();
		Thread.sleep(1500);
		
		driver.findElement(a.fisn).sendKeys("Kevin");
		driver.findElement(a.midn).sendKeys("Ethan");
		driver.findElement(a.lasn).sendKeys("Levin");
		Thread.sleep(500);
		
		driver.findElement(a.pic).click();;
		Thread.sleep(2000);
		Robot rb = new Robot();
		rb.delay(2000);
		StringSelection ss = new StringSelection("C:\\Users\\prati\\Downloads\\Test Pictures\\picopic.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		driver.findElement(a.crtlog).click();
		Thread.sleep(1000);
	}
	
	@AfterMethod
	public void CloseH() {
		driver.close();
	}
	
	@Test (priority = 1) //Verifying Enable Disable Button
	public void Tc15() {
		driver.findElement(a.disabt).click();
		boolean disable = driver.findElement(a.disabt).isEnabled();
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(disable, true);
		if (disable==true) {
			System.out.println("Test Case Success");
			String a2 = driver.findElement(a.disabt).getText();
			System.out.println(a2);
		}else {System.out.println("Test Case Failed");}
		
		driver.findElement(a.disabt).click();
		boolean enable = driver.findElement(a.enabt).isEnabled();
		SoftAssert s2 = new SoftAssert();
		s2.assertEquals(enable, true);
		if (disable==true) {
			System.out.println("Test Case Success");
			String a2 = driver.findElement(a.enabt).getText();
			System.out.println(a2);
		}else {System.out.println("Test Case Failed");}
	}

}
