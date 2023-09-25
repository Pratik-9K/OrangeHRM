package project1;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SubmitCancel {
	
	WebDriver driver;
	OrHRMElementso a = new OrHRMElementso();
	
	@BeforeMethod
	public void LaunchPIM() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\ST by Manas\\JARs\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
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
		driver.findElement(a.disabt).click();
		driver.findElement(a.enabt).click();
		driver.findElement(a.cluid).sendKeys("Kevin@123!#");
		driver.findElement(a.clpwd).sendKeys("Kevin@619");
		driver.findElement(a.clcpwd).sendKeys("Kevin@619");
	}
	
	@Test(priority = 1) // Verifying submit button (Personal Detailss detected means successfully verified
	public void Tc22() throws Exception {
		
		driver.findElement(a.savebt).click();
		Thread.sleep(8000);
		
		boolean personalDet = driver.findElement(a.persdet).isDisplayed();
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(personalDet, true);
		if (personalDet==true) {
			System.out.println("Test Case Success");
			String a2 = driver.findElement(a.persdet).getText();
			String a3 = driver.findElement(a.ename).getText();
			System.out.println(a2+ "of" +a3);
		}else {System.out.println("Test Case Failed");}	
	}
	
	@Test(priority = 1) // Verifying cancell button (will redirect to Employee List on canceling)
	public void Tc23() throws Exception {
		
		driver.findElement(a.cancelbt).click();
		Thread.sleep(8000);
		
		boolean eList = driver.findElement(a.emplist).isDisplayed();
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(eList, true);
		if (eList==true) {
			System.out.println("Test Case Success");
			String a2 = driver.findElement(a.emplist).getText();
			System.out.println(a2);
		}else {System.out.println("Test Case Failed");}	
	}
		

	
	@AfterMethod
	public void CloseH() {
		driver.close();
	}

}
