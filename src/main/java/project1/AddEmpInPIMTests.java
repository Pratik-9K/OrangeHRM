package project1;

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
	@Test (priority = 7) 
	public void Tc7 () {
		home = new Homepage(driver);
		addEmp = new AddEmpInPIM(driver);
		addEmp.LoginCC();
		addEmp.goToAddEmpTab();
		addEmp.typeEmpNameandID("", "", "", "");
		home.verifyRequired();
	}
	@Test (priority = 8) 
	public void Tc8 () {
		home = new Homepage(driver);
		addEmp = new AddEmpInPIM(driver);
		addEmp.LoginCC();
		addEmp.goToAddEmpTab();
		addEmp.typeEmpNameandID("Kevin", "Ethan", "Levin", "9000");
		addEmp.verifyIfEmployeeAdeedByCheckingPersonalDetails();
	}

}
