package project1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class HomepageTests extends Baseclass {
	
	Homepage home;
	
	
	@Test (priority = 1) 
	public void Tc1() throws Exception {
		home = new Homepage(driver);
		home.typeLogin("Admin", "admin123");
		home.verifyLoginByLocatingPIM();
	}
	
	@Test (priority = 2) 
	public void Tc2() throws Exception {
		home = new Homepage(driver);
		home.typeLogin("", "");
		home.verifyRequired();
	}
	
	@Test (priority = 3) 
	public void Tc3() throws Exception {
		home = new Homepage(driver);
		home.typeLogin("Admin", "a1 *");
		home.verifyInvalidCredentials();
	}
	@Test (priority = 4) 
	public void Tc4() throws Exception {
		home = new Homepage(driver);
		home.verifyforgotPassBTandClickCancel(null);
	}
	
	@Test (priority = 5) 
	public void Tc5() throws Exception {
		home = new Homepage(driver);
		home.verifyforgotPassBTandSubmitUID("Admin");
	}
	
}
