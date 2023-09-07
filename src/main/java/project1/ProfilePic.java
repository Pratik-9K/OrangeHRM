package project1;

import static org.testng.Assert.assertNotNull;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProfilePic {
	
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
		Thread.sleep(1000);
		
		driver.findElement(a.pim).click();
		Thread.sleep(1500);
		driver.findElement(a.addemp).click();
		Thread.sleep(1500);
		
		driver.findElement(a.fisn).sendKeys("Kevin");
		driver.findElement(a.midn).sendKeys("Ethan");
		driver.findElement(a.lasn).sendKeys("Levin");
		Thread.sleep(500);
		
	}
	
	@Test (priority = 1) // mentioned Type-1 Size-1
	public void Tc11() throws Exception, InterruptedException {
		driver.findElement(a.pic).click();;
		Thread.sleep(2000);
		
		Robot rb = new Robot();
		rb.delay(2000);
		
		//Put path to file in clipboard
		StringSelection ss = new StringSelection("C:\\Users\\prati\\Downloads\\Test Pictures\\picopic.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		//CTRL+v
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		//Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(3000);
		driver.findElement(a.savebt).click();
		Thread.sleep(5000);
		
		boolean uploadedPic = driver.findElement(a.pic11).isDisplayed();
		SoftAssert s2 = new SoftAssert();
		s2.assertEquals(uploadedPic, true);
		if (uploadedPic==true) {
			System.out.println("Test Case Success");
		}else {System.out.println("Test Case Failed");}
		
	}
	
	@Test (priority = 2) // mentioned Type-1 Size-0
	public void Tc12() throws Exception, InterruptedException {
		driver.findElement(a.pic).click();;
		Thread.sleep(2000);
		
		Robot rb = new Robot();
		rb.delay(2000);
		
		StringSelection ss = new StringSelection("C:\\Users\\prati\\Downloads\\Test Pictures\\kenpa.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
		boolean picAlert1 = driver.findElement(a.sizexce).isDisplayed();
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(picAlert1, true);
		if (picAlert1==true) {
			System.out.println("Test Case Success");
			String a2 = driver.findElement(a.sizexce).getText();
			System.out.println(a2);
		}else {System.out.println("Test Case Failed");}	
		
	}
	
	@Test (priority = 3) // mentioned Type-0 Size-1
	public void Tc13() throws Exception, InterruptedException {
		driver.findElement(a.pic).click();;
		Thread.sleep(2000);
		
		Robot rb = new Robot();
		rb.delay(2000);
		
		StringSelection ss = new StringSelection("C:\\Users\\prati\\Downloads\\Test Pictures\\chigo.mkv");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
		boolean picAlert2 = driver.findElement(a.invfile).isDisplayed();
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(picAlert2, true);
		if (picAlert2==true) {
			System.out.println("Test Case Success");
			String a2 = driver.findElement(a.invfile).getText();
			System.out.println(a2);
		}else {System.out.println("Test Case Failed");}	
		
	}
	
	@Test (priority = 4) // mentioned Type-0 Size-0
	public void Tc14() throws Exception, InterruptedException {
		driver.findElement(a.pic).click();;
		Thread.sleep(2000);
		
		Robot rb = new Robot();
		rb.delay(2000);
		
		StringSelection ss = new StringSelection("C:\\Users\\prati\\Downloads\\Test Pictures\\banka.mkv");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
		boolean picAlert3 = driver.findElement(a.sizexce).isDisplayed();
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(picAlert3, true);
		if (picAlert3==true) {
			System.out.println("Test Case Success");
			String a2 = driver.findElement(a.sizexce).getText();
			System.out.println(a2);
		}else {System.out.println("Test Case Failed");}	
		
	}
	
	@AfterMethod
	public void CloseH() {
		driver.close();
	}

}
