package project1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SelPIM {

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
	}
	
	@Test (priority = 1) // Submitting with blank name Required alert will be shown
	public void Tc5() throws Exception {
		driver.findElement(a.fisn).sendKeys("");
		driver.findElement(a.midn).sendKeys("");
		driver.findElement(a.lasn).sendKeys("");
		Thread.sleep(500);
		driver.findElement(a.savebt).click();
		
		boolean reqAlert = driver.findElement(a.nreq).isDisplayed();
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(reqAlert, true);
		if (reqAlert==true) {
			System.out.println("Test Case Success");
			String a1 = driver.findElement(a.nreq).getText();
			System.out.println(a1);
		}else {System.out.println("Test Case Failed");}	
	}
	
	@Test (priority = 2) // if  Personal Details located means Emp Added successfully (Checking with Special characters in Name)
	public void Tc6() throws Exception {
		driver.findElement(a.fisn).sendKeys("@Kevin");
		driver.findElement(a.midn).sendKeys("");
		driver.findElement(a.lasn).sendKeys("#Levin");
		Thread.sleep(500);
		driver.findElement(a.empid).sendKeys("0010");
		Thread.sleep(500);
		driver.findElement(a.savebt).click();
		Thread.sleep(5000);
		
		boolean personalDet = driver.findElement(a.persdet).isDisplayed();
		SoftAssert s2 = new SoftAssert();
		s2.assertEquals(personalDet, true);
		if (personalDet==true) {
			System.out.println("Test Case Success");
		}else {System.out.println("Test Case Failed");}	
	}
	
	@Test (priority = 3) // if  Personal Details located means Emp Added successfully (Checking with Alphabets only in Name)
	public void Tc7() throws Exception {
		driver.findElement(a.fisn).sendKeys("Kevin");
		driver.findElement(a.midn).sendKeys("Ethan");
		driver.findElement(a.lasn).sendKeys("Levin");
		Thread.sleep(500);
		driver.findElement(a.empid).sendKeys("009");
		Thread.sleep(500);
		driver.findElement(a.savebt).click();
		Thread.sleep(5000);
		
		boolean personalDet = driver.findElement(a.persdet).isDisplayed();
		SoftAssert s3 = new SoftAssert();
		s3.assertEquals(personalDet, true);
		if (personalDet==true) {
			System.out.println("Test Case Success");
		}else {System.out.println("Test Case Failed");}	
	}
	
	@Test (priority = 4) // if  Personal Details located means Emp Added successfully (Checking with Special characters & Alphhabets in Employee ID)
	public void Tc8() throws Exception {
		driver.findElement(a.fisn).sendKeys("Kevin");
		driver.findElement(a.midn).sendKeys("Ethan");
		driver.findElement(a.lasn).sendKeys("Levin");
		Thread.sleep(500);
		driver.findElement(a.empid).sendKeys(Keys.chord(Keys.CONTROL, "a"), "@#009");
		//driver.findElement(a.empid).sendKeys();
		Thread.sleep(2000);
		driver.findElement(a.savebt).click();
		Thread.sleep(5000);
		
		boolean personalDet = driver.findElement(a.persdet).isDisplayed();
		SoftAssert s4 = new SoftAssert();
		s4.assertEquals(personalDet, true);
		if (personalDet==true) {
			System.out.println("Test Case Success");
		}else {System.out.println("Test Case Failed");}	
	}
	
	@Test (priority = 5) // if  Personal Details located means Emp Added successfully (Checking with Numbers only in Employee ID)
	public void Tc9() throws Exception {
		driver.findElement(a.fisn).sendKeys("Kevin");
		driver.findElement(a.midn).sendKeys("Ethan");
		driver.findElement(a.lasn).sendKeys("Levin");
		Thread.sleep(500);
		driver.findElement(a.empid).clear();
		driver.findElement(a.empid).sendKeys(Keys.chord(Keys.CONTROL, "a"), "9000");
		Thread.sleep(2000);
		driver.findElement(a.savebt).click();
		Thread.sleep(5000);
		
		boolean personalDet = driver.findElement(a.persdet).isDisplayed();
		SoftAssert s5 = new SoftAssert();
		s5.assertEquals(personalDet, true);
		if (personalDet==true) {
			System.out.println("Test Case Success");
		}else {System.out.println("Test Case Failed");}	
	}
	
	/*@Test (priority = 6) // By giving Same Employee ID again Alert will be shown (Checking with Numbers only in Employee ID)
	public void Tc10() throws Exception {
		driver.findElement(a.fisn).sendKeys("Kevinn");
		driver.findElement(a.midn).sendKeys("Ethann");
		driver.findElement(a.lasn).sendKeys("Levinn");
		Thread.sleep(500);
		driver.findElement(a.empid).clear();
		driver.findElement(a.empid).sendKeys(Keys.chord(Keys.CONTROL, "a"), "9000");
		Thread.sleep(2000);
		driver.findElement(a.savebt).click();
		Thread.sleep(500);
		
		boolean idEmp = driver.findElement(a.idexist).isDisplayed();
		SoftAssert s6 = new SoftAssert();
		s6.assertEquals(idEmp, true);
		if (idEmp==true) {
			System.out.println("Test Case Success");
			String a2 = driver.findElement(a.idexist).getText();
			System.out.println(a2);
		}else {System.out.println("Test Case Failed");}	
	}*/
	
	
	@AfterMethod
	public void CloseH() {
		driver.close();
	}

}
