package project1;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

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
		
		/*driver.findElement(a.pic).click();;
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
		rb.keyRelease(KeyEvent.VK_ENTER);*/
		
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
		
		driver.findElement(a.enabt).click();
		boolean enable = driver.findElement(a.enabt).isEnabled();
		SoftAssert s2 = new SoftAssert();
		s2.assertEquals(enable, true);
		if (disable==true) {
			System.out.println("Test Case Success");
			String a2 = driver.findElement(a.enabt).getText();
			System.out.println(a2);
		}else {System.out.println("Test Case Failed");}
	}
	
	@Test (priority = 2) // Saving without(Empty) credentials
	public void Tc16() {
		driver.findElement(a.savebt).click();
		
		boolean idRequired = driver.findElement(a.requid).isDisplayed();
		SoftAssert s3 = new SoftAssert();
		s3.assertEquals(idRequired, true);
		if (idRequired==true) {
			System.out.println("Test Case Success");
			String a2 = driver.findElement(a.requid).getText();
			System.out.println(a2);
		}else {System.out.println("Test Case Failed");}
		boolean passRequired = driver.findElement(a.reqpwd).isDisplayed();
		SoftAssert s4 = new SoftAssert();
		s3.assertEquals(passRequired, true);
		if (passRequired==true) {
			System.out.println("Test Case Success");
			String a2 = driver.findElement(a.reqpwd).getText();
			System.out.println(a2);
		}else {System.out.println("Test Case Failed");}
	}
	
	@Test (priority = 3) // Filling less than mentioned characters
	public void Tc17() throws Exception {
		
		driver.findElement(a.cluid).sendKeys("kevi");
		driver.findElement(a.clpwd).sendKeys("kevi");
		Thread.sleep(1000);
		driver.findElement(a.savebt).click();
		
		boolean id5 = driver.findElement(a.lessuid).isDisplayed();
		SoftAssert s5 = new SoftAssert();
		s5.assertEquals(id5, true);
		if (id5==true) {
			System.out.println("Test Case Success");
			String a2 = driver.findElement(a.lessuid).getText();
			System.out.println(a2);
		}else {System.out.println("Test Case Failed");}
		boolean pass7 = driver.findElement(a.lesspwd).isDisplayed();
		SoftAssert s6 = new SoftAssert();
		s6.assertEquals(pass7, true);
		if (pass7==true) {
			System.out.println("Test Case Success");
			String a2 = driver.findElement(a.lesspwd).getText();
			System.out.println(a2);
		}else {System.out.println("Test Case Failed");}
	}
	
	@Test (priority = 4) // Valid UID Invalid Pass
	public void Tc18() throws Exception {
		
		driver.findElement(a.cluid).sendKeys("Kevin@123!#");
		driver.findElement(a.clpwd).sendKeys("KEVINNN");
		Thread.sleep(1000);
		driver.findElement(a.savebt).click();
		
		boolean smallChar = driver.findElement(a.onesmall).isDisplayed();
		SoftAssert s7 = new SoftAssert();
		s7.assertEquals(smallChar, true);
		if (smallChar==true) {
			System.out.println("Test Case Success");
			String a2 = driver.findElement(a.onesmall).getText();
			System.out.println(a2);
		}else {System.out.println("Test Case Failed");}
	}
	
	@Test (priority = 5) // Valid UID Invalid Pass
	public void Tc19() throws Exception {
		
		driver.findElement(a.cluid).sendKeys("Kevin@123!#");
		driver.findElement(a.clpwd).sendKeys("Kevinnn");
		Thread.sleep(1000);
		driver.findElement(a.savebt).click();
		
		boolean numChar = driver.findElement(a.onenum).isDisplayed();
		SoftAssert s8 = new SoftAssert();
		s8.assertEquals(numChar, true);
		if (numChar==true) {
			System.out.println("Test Case Success");
			String a2 = driver.findElement(a.onenum).getText();
			System.out.println(a2);
		}else {System.out.println("Test Case Failed");}
	}
	
	@Test (priority = 6) // Valid UID & pass, empty confirm pass
	public void Tc20() throws Exception {
		
		driver.findElement(a.cluid).sendKeys("Kevin@123!#");
		driver.findElement(a.clpwd).sendKeys("Kevin@619");
		driver.findElement(a.savebt).click();
		Thread.sleep(1000);
		
		boolean confPass = driver.findElement(a.confreq).isDisplayed();
		SoftAssert s9 = new SoftAssert();
		s9.assertEquals(confPass, true);
		if (confPass==true) {
			System.out.println("Test Case Success");
			String a2 = driver.findElement(a.confreq).getText();
			System.out.println(a2);
		}else {System.out.println("Test Case Failed");}
	}
	
	@Test (priority = 7) //  Confirm pass mismatch
	public void Tc21() throws Exception {
		
		driver.findElement(a.cluid).sendKeys("Kevin@123!#");
		driver.findElement(a.clpwd).sendKeys("Kevin@619");
		driver.findElement(a.clcpwd).sendKeys("Kevin@");
		driver.findElement(a.savebt).click();
		Thread.sleep(1000);
		
		boolean mismtchPass = driver.findElement(a.pwmismatch).isDisplayed();
		SoftAssert s10 = new SoftAssert();
		s10.assertEquals(mismtchPass, true);
		if (mismtchPass==true) {
			System.out.println("Test Case Success");
			String a2 = driver.findElement(a.pwmismatch).getText();
			System.out.println(a2);
		}else {System.out.println("Test Case Failed");}
	}
	
}
