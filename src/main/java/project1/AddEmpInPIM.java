package project1;

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
}
