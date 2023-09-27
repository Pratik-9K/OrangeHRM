package project1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class AddEmpCreateLoginDetailsTests extends Baseclass {
	AddEmpInPIM addEmp;
	Homepage home;
	
	@Test (priority = 9) 
	public void Tc9 () {
		home = new Homepage(driver);
		addEmp = new AddEmpInPIM(driver);
		addEmp.LoginCC();
		addEmp.goToAddEmpTab();
		addEmp.clickCreateLoginDetails();
		addEmp.clickDisableAndEnable();
	}
	@Test (priority = 10, dataProvider = "createLogin1") 
	public void Tc10 (String uname, String pass, String cpass) {
		home = new Homepage(driver);
		addEmp = new AddEmpInPIM(driver);
		addEmp.LoginCC();
		addEmp.goToAddEmpTab();
		addEmp.typeEmpNameandID2();
		addEmp.clickCreateLoginDetails();
		addEmp.clickDisableAndEnable();
		addEmp.typeLogonDetails(uname, pass, cpass);
		addEmp.clickSaveBT();
		home.verifyRequired();
	}
	@Test (priority = 11, dataProvider = "createLogin2") 
	public void Tc11 (String uname, String pass, String cpass) {
		home = new Homepage(driver);
		addEmp = new AddEmpInPIM(driver);
		addEmp.LoginCC();
		addEmp.goToAddEmpTab();
		addEmp.typeEmpNameandID2();
		addEmp.clickCreateLoginDetails();
		addEmp.clickDisableAndEnable();
		addEmp.typeLogonDetails(uname, pass, cpass);
		addEmp.clickSaveBT();
		addEmp.verifyAtLeast5();
	}
	@Test (priority = 12, dataProvider = "createLogin3") 
	public void Tc12 (String uname, String pass, String cpass) {
		home = new Homepage(driver);
		addEmp = new AddEmpInPIM(driver);
		addEmp.LoginCC();
		addEmp.goToAddEmpTab();
		addEmp.typeEmpNameandID2();
		addEmp.clickCreateLoginDetails();
		addEmp.clickDisableAndEnable();
		addEmp.typeLogonDetails(uname, pass, cpass);
		addEmp.clickSaveBT();
		addEmp.verifyAtLeast7();
	}
	@Test (priority = 13, dataProvider = "createLogin4") 
	public void Tc13 (String uname, String pass, String cpass) {
		home = new Homepage(driver);
		addEmp = new AddEmpInPIM(driver);
		addEmp.LoginCC();
		addEmp.goToAddEmpTab();
		addEmp.typeEmpNameandID2();
		addEmp.clickCreateLoginDetails();
		addEmp.clickDisableAndEnable();
		addEmp.typeLogonDetails(uname, pass, cpass);
		addEmp.clickSaveBT();
		addEmp.verifyAtLeastLowerCase();
	}
	@Test (priority = 14, dataProvider = "createLogin5") 
	public void Tc14 (String uname, String pass, String cpass) {
		home = new Homepage(driver);
		addEmp = new AddEmpInPIM(driver);
		addEmp.LoginCC();
		addEmp.goToAddEmpTab();
		addEmp.typeEmpNameandID2();
		addEmp.clickCreateLoginDetails();
		addEmp.clickDisableAndEnable();
		addEmp.typeLogonDetails(uname, pass, cpass);
		addEmp.clickSaveBT();
		addEmp.verifyAtLeastNumber();
	}
	@Test (priority = 15, dataProvider = "createLogin6") 
	public void Tc15 (String uname, String pass, String cpass) {
		home = new Homepage(driver);
		addEmp = new AddEmpInPIM(driver);
		addEmp.LoginCC();
		addEmp.goToAddEmpTab();
		addEmp.typeEmpNameandID2();
		addEmp.clickCreateLoginDetails();
		addEmp.clickDisableAndEnable();
		addEmp.typeLogonDetails(uname, pass, cpass);
		addEmp.clickSaveBT();
		addEmp.verifyPassMismatch();
	}
	@Test (priority = 16, dataProvider = "createLogin7") 
	public void Tc16 (String uname, String pass, String cpass) {
		home = new Homepage(driver);
		addEmp = new AddEmpInPIM(driver);
		addEmp.LoginCC();
		addEmp.goToAddEmpTab();
		addEmp.typeEmpNameandID2();
		addEmp.clickCreateLoginDetails();
		addEmp.clickDisableAndEnable();
		addEmp.typeLogonDetails(uname, pass, cpass);
		addEmp.clickSaveBT();
		addEmp.verifyIfEmployeeAdeedByCheckingPersonalDetails();
	}
	
	@DataProvider (name = "createLogin1")
	public Object[][] dataProviderMethod1() {
		return new Object[][] {{"", "", ""}};
	}
	@DataProvider (name = "createLogin2")
	public Object[][] dataProviderMethod2() {
		return new Object[][] {{"aaaa", "abc123", "1232@"}};
	}
	@DataProvider (name = "createLogin3")
	public Object[][] dataProviderMethod3() {
		return new Object[][] {{"KeviinL", "abc123", "1232@"}};
	}
	@DataProvider (name = "createLogin4")
	public Object[][] dataProviderMethod4() {
		return new Object[][] {{"KeviinL", "1234123", "1232@"}};
	}
	@DataProvider (name = "createLogin5")
	public Object[][] dataProviderMethod5() {
		return new Object[][] {{"KeviinL", "abcdabc", "1232@"}};
	}
	@DataProvider (name = "createLogin6")
	public Object[][] dataProviderMethod6() {
		return new Object[][] {{"KeviinL", "kevin9000", "1232@"}};
	}
	@DataProvider (name = "createLogin7")
	public Object[][] dataProviderMethod7() {
		return new Object[][] {{"KeviinL", "kevin9000", "kevin9000"}};
	}

}
