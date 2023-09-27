package project1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class AddEmpInPIMTests extends Baseclass {
	AddEmpInPIM addEmp;
	Homepage home;
	
	@Test (priority = 6) 
	public void Tc6 () {
		home = new Homepage(driver);
		addEmp = new AddEmpInPIM(driver);
		addEmp.LoginCC();
		addEmp.goToAddEmpTab();
		addEmp.clickCancelBT();
		addEmp.verifyCancelBTByCheckingIfRedirectedToEmpListTab();
	}
	@Test (priority = 7, dataProvider = "addEmpNameID1") 
	public void Tc7 (String fname, String mname, String lname, String empid) {
		home = new Homepage(driver);
		addEmp = new AddEmpInPIM(driver);
		addEmp.LoginCC();
		addEmp.goToAddEmpTab();
		addEmp.typeEmpNameandID(fname,mname,lname,empid);
		home.verifyRequired();
	}
	@Test (priority = 8, dataProvider = "addEmpNameID2") 
	public void Tc8 (String fname, String mname, String lname, String empid) {
		home = new Homepage(driver);
		addEmp = new AddEmpInPIM(driver);
		addEmp.LoginCC();
		addEmp.goToAddEmpTab();
		addEmp.typeEmpNameandID(fname,mname,lname,empid);
		addEmp.verifyIfEmployeeAdeedByCheckingPersonalDetails();
	}
	@DataProvider (name = "addEmpNameID1")
	public Object[][] dataProviderMethod1() {
		return new Object[][] {{"", "", "", ""}};
	}
	@DataProvider (name = "addEmpNameID2")
	public Object[][] dataProviderMethod2() {
		return new Object[][] {{"Kevin", "Ethan", "Levin", "9000"}};
	}
	
}
