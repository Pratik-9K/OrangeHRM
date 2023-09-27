package project1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class HomepageTests extends Baseclass {
	
	Homepage home;
	
	
	@Test (priority = 1, dataProvider = "homepageData1") 
	public void Tc1(String uid1, String pass1) throws Exception {
		home = new Homepage(driver);
		home.typeLogin(uid1, pass1);
		home.verifyLoginByLocatingPIM();
	}
	@Test (priority = 2, dataProvider = "homepageData2") 
	public void Tc2(String uid2, String pass2) throws Exception {
		home = new Homepage(driver);
		home.typeLogin(uid2, pass2);
		home.verifyRequired();
	}
	@Test (priority = 3, dataProvider = "homepageData3") 
	public void Tc3(String uid3, String pass3) throws Exception {
		home = new Homepage(driver);
		home.typeLogin(uid3, pass3);
		home.verifyInvalidCredentials();
	}
	@Test (priority = 4) 
	public void Tc4() throws Exception {
		home = new Homepage(driver);
		home.verifyforgotPassBTandClickCancel(null);
	}
	@Test (priority = 5, dataProvider = "homepageData4") 
	public void Tc5(String uid4) throws Exception {
		home = new Homepage(driver);
		home.verifyforgotPassBTandSubmitUID(uid4);
	}
	
	@DataProvider (name = "homepageData1")
	public Object[][] dataProviderMethod1() {
		return new Object[][] {{"Admin", "admin123"}};
	}
	@DataProvider (name = "homepageData2")
	public Object[][] dataProviderMethod2() {
		return new Object[][] {{"", ""}};
	}
	@DataProvider (name = "homepageData3")
	public Object[][] dataProviderMethod3() {
		return new Object[][] {{"Admin", "a1 *"}};
	}
	@DataProvider (name = "homepageData4")
	public Object[][] dataProviderMethod4() {
		return new Object[][] {{"Admin"}};
	}
	
}
