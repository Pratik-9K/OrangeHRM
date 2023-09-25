package project1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;



public class Homepage extends Baseclass {
	
	// Login Page Locators
		@FindBy(name = "username")WebElement userID;
		@FindBy(name = "password")WebElement userPass;
		@FindBy(xpath = "//button[text()=' Login ']")WebElement loginButton;
		@FindBy(xpath = "//p[text()='Invalid credentials']")WebElement invalidCredentials;
		@FindBy(xpath = "//span[text()='Required']")WebElement loginRequired;
		@FindBy(xpath = "//p[text()='Forgot your password? ']")WebElement forgotPasswordBT;
		@FindBy(xpath = "//input[@placeholder='Username']")WebElement UIDinForgot;
		@FindBy(xpath = "//span[text()='Required']")WebElement RequiredinForgot;
		@FindBy(xpath = "//button[text()=' Cancel ']")WebElement cancelBTinForgot;
		@FindBy(xpath = "//button[text()=' Reset Password ']")WebElement resetBTinForgot;
		@FindBy(xpath = "//h6[text()='Reset Password link sent successfully']")WebElement resetDone;
		@FindBy(xpath = "//span[text()='PIM']")WebElement PIMmodule;
		
		Homepage(WebDriver d){
			driver=d;
			PageFactory.initElements(driver, this);}
	
	//Homepage
	public void typeLogin(String hid, String hpass) {
		userID.sendKeys(hid);
		userPass.sendKeys(hpass);
		loginButton.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void verifyLoginByLocatingPIM() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean pim = PIMmodule.isDisplayed();
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(pim, true);
	}
	public void verifyRequired() {
		boolean req = loginRequired.isDisplayed();
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(req, true);
	}
	public void verifyInvalidCredentials() {
		boolean InvCredentials = invalidCredentials.isDisplayed();
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(InvCredentials, true);
	}
	public void verifyforgotPassBTandClickCancel(String forguid) {
		forgotPasswordBT.click();
		cancelBTinForgot.click();
	}
	public void verifyforgotPassBTandSubmitUID(String forguid) {
		forgotPasswordBT.click();
		UIDinForgot.sendKeys(forguid);
		resetBTinForgot.click();
		boolean resetMsg = resetDone.isDisplayed();
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(resetMsg, true);
	}

}
