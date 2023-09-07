package project1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Homepage {
	
	WebDriver driver;
	OrHRMElementso a = new OrHRMElementso();
	
	@BeforeMethod
	public void LaunchH() throws Exception {
		driver = new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window();
		Thread.sleep(1000);
	}
	
	@Test (priority = 1) // if  PIM module located means successfully logged in
	public void Tc1() throws Exception {
		driver.findElement(a.huid).sendKeys("Admin");
		driver.findElement(a.hpwd).sendKeys("admin123");
		driver.findElement(a.hlogbt).click();
		Thread.sleep(500);
		
		boolean pimDisplay = driver.findElement(a.pim).isDisplayed();
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(pimDisplay, true);
		if (pimDisplay==true) {
			System.out.println("Test Case Success");
		}else {System.out.println("Test Case Failed");}	
	}
	
	@Test (priority = 2) // If login button of homepage lacated means not logged in
	public void Tc2() throws Exception {
		driver.findElement(a.huid).sendKeys("");
		driver.findElement(a.hpwd).sendKeys("");
		driver.findElement(a.hlogbt).click();
		Thread.sleep(500);
		
		boolean alrtDisplay2 = driver.findElement(a.hreq).isDisplayed();
		SoftAssert s2 = new SoftAssert();
		s2.assertEquals(alrtDisplay2, true);
		if (alrtDisplay2==true) {
			System.out.println("Test Case Success");
			String s = driver.findElement(a.hreq).getText();
			System.out.println(s);
		}else {System.out.println("Test Case Failed");}	
	}
	
	@Test (priority = 3) // If Alert massage on homepage lacated means not logged in
	public void Tc3() throws Exception {
		driver.findElement(a.huid).sendKeys("Admin");
		driver.findElement(a.hpwd).sendKeys("a1 *");
		driver.findElement(a.hlogbt).click();
		Thread.sleep(500);
		
		boolean alrtDisplay3 = driver.findElement(a.invalert).isDisplayed();
		SoftAssert s3 = new SoftAssert();
		s3.assertEquals(alrtDisplay3, true);
		if (alrtDisplay3==true) {
			System.out.println("Test Case Success");
			String s = driver.findElement(a.invalert).getText();
			System.out.println(s);
		}else {System.out.println("Test Case Failed");}	
	}
	
	@Test (priority = 4) // If Alert massage on homepage lacated means not logged in
	public void Tc4() throws Exception {
		driver.findElement(a.huid).sendKeys("q2 &");
		driver.findElement(a.hpwd).sendKeys("admin123");
		driver.findElement(a.hlogbt).click();
		Thread.sleep(500);
		
		boolean alrtDisplay4 = driver.findElement(a.invalert).isDisplayed();
		SoftAssert s4 = new SoftAssert();
		s4.assertEquals(alrtDisplay4, true);
		if (alrtDisplay4==true) {
			System.out.println("Test Case Success");
			String s = driver.findElement(a.invalert).getText();
			System.out.println(s);
		}else {System.out.println("Test Case Failed");}	
	}
	
	@AfterMethod
	public void CloseH() {
		driver.close();
	}

}
