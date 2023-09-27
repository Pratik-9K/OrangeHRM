package project1;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class AddEmpInPIM extends Baseclass{
	Homepage home;
	
	@FindBy(xpath = "//button[text()=' Cancel ']")WebElement cancelBT;
	@FindBy(xpath = "//button[text()=' Save ']")WebElement saveBT;
	@FindBy(xpath = "//span[text()='PIM']")WebElement PIMmodule;
	@FindBy(xpath = "//a[text()='Add Employee']")WebElement addEmployeeTab;
	@FindBy(xpath = "//input[@name='firstName']")WebElement firstName;
	@FindBy(xpath = "//input[@name='middleName']")WebElement middleName;
	@FindBy(xpath = "//input[@name='lastName']")WebElement lastName;
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")WebElement empID;
	@FindBy(xpath = "//a[text()='Personal Details']")WebElement personalDetails;
	@FindBy(xpath = "//a[text()='Employee List']")WebElement empListTab;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span")WebElement CreateLoginDetailsBT;
	@FindBy(xpath = "//label[text()='Enabled']")WebElement enableRBT;
	@FindBy(xpath = "//label[text()='Disabled']")WebElement disableRBT;
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input")WebElement usernameInCreateLogin;
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input")WebElement passwordInCreateLogin;
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input")WebElement confirmPasswordInVreateLogin;
	@FindBy(xpath = "//span[text()='Should be at least 5 characters']")WebElement alert5Characters;
	@FindBy(xpath = "//span[text()='Should have at least 7 characters']")WebElement alert7Characters;
	@FindBy(xpath = "//span[text()='Your password must contain minimum 1 lower-case letter']")WebElement alert1Lowercase;
	@FindBy(xpath = "//span[text()='Your password must contain minimum 1 number']")WebElement alert1Number;
	@FindBy(xpath = "//span[text()='Passwords do not match']")WebElement alertPassMismatch;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/div[2]/div/button/i")WebElement addProfilePic;



	
	AddEmpInPIM(WebDriver d){
		driver=d;
		PageFactory.initElements(driver, this);}
	
	public void LoginCC() {
		home = new Homepage(driver);
		home.typeLogin("Admin", "admin123");
	}
	public void goToAddEmpTab() {
		PIMmodule.click();
		addEmployeeTab.click();
	}
	public void clickCancelBT() {
		cancelBT.click();
	}
	public void verifyCancelBTByCheckingIfRedirectedToEmpListTab () {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean empLst = empListTab.isSelected();
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(empLst, true);
	}
	public void typeEmpNameandID(String fname, String mname, String lname, String empid) {
		firstName.sendKeys(fname);
		middleName.sendKeys(mname);
		lastName.sendKeys(lname);
		empID.clear();
		empID.sendKeys(empid);
		saveBT.click();
	}
	public void verifyIfEmployeeAdeedByCheckingPersonalDetails() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean personalDet = personalDetails.isDisplayed();
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(personalDet, true);
	}
	public void clickCreateLoginDetails() {
		CreateLoginDetailsBT.click();
	}
	public void clickDisableAndEnable() {
		disableRBT.click();
		enableRBT.click();
	}
	public void typeEmpNameandID2() {
		firstName.sendKeys("Kevin");
		middleName.sendKeys("Ethan");
		lastName.sendKeys("Levin");
		empID.clear();
		empID.sendKeys("9000");
	}
	public void clickSaveBT() {
		saveBT.click();
	}
	
	public void typeLogonDetails(String uname, String pass, String cpass) {
		usernameInCreateLogin.sendKeys(uname);
		passwordInCreateLogin.sendKeys(pass);
		confirmPasswordInVreateLogin.sendKeys(cpass);
	}
	public void verifyAtLeast5() {
		boolean char5 = alert5Characters.isDisplayed();
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(char5, true);
	}
	public void verifyAtLeast7() {
		boolean char7 = alert7Characters.isDisplayed();
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(char7, true);
	}
	public void verifyAtLeastLowerCase() {
		boolean lower = alert1Lowercase.isDisplayed();
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(lower, true);
	}
	public void verifyAtLeastNumber() {
		boolean num = alert1Number.isDisplayed();
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(num, true);
	}
	public void verifyPassMismatch() {
		boolean mismatch = alertPassMismatch.isDisplayed();
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(mismatch, true);
	}
	
	public void clickProfilepIC() {
		addProfilePic.click();
	}
	public void addProfilePic(String path) throws Exception {
		addProfilePic.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Robot rb = new Robot();
		rb.delay(2000);
		//Put path to file in clipboard
		StringSelection ss = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		//CTRL+v
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		//Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}
}
