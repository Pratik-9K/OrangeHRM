package project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OHRMElements {
	
	By uid = By.name("username");
	By pwd = By.name("password");
	By lbt = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
	
	// Login Page Locators
	@FindBy (name = "username") WebElement huid;
	@FindBy (name = "password") WebElement hpwd;
	@FindBy (xpath = "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button") WebElement hlogbt;
	
	// Selecting PIM Module & Add Employee
	@FindBy (xpath = "//*[@id=\\\"app\\\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span") WebElement pim;
	@FindBy (xpath = "//a[text()='Add Employee']") WebElement addemp;
	
	// Employee Details
	@FindBy (name = "firstName") WebElement fisn;
	@FindBy (name = "middleName") WebElement midn;
	@FindBy (name = "lastName") WebElement lasn;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input") WebElement empid;
	
	// Profile Pic
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/div[2]/div/button/i") WebElement pic;
	
	// Create Employee Login Details
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span") WebElement crtlog;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input") WebElement cluid;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[2]/div/div[2]/div[1]/div[2]/div/label") WebElement enabt;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[2]/div/div[2]/div[2]/div[2]/div/label/span") WebElement disabt;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input") WebElement clpwd;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input") WebElement clcpwd;
	
	// Cancel & Submit Button
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[1]") WebElement cancelbt;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]") WebElement savetbt;

}
