package project1;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddEmpProfilePicTest extends Baseclass {
	AddEmpInPIM addEmp;
	Homepage home;
	
	@Test (priority = 16, dataProvider = "addProfilePic") // mentioned Type-1 Size-1
	public void Tc16(String path) throws Exception, InterruptedException {
		home = new Homepage(driver);
		addEmp = new AddEmpInPIM(driver);
		addEmp.LoginCC();
		addEmp.goToAddEmpTab();
		addEmp.typeEmpNameandID2();
		addEmp.addProfilePic(path);
		addEmp.clickSaveBT();
		addEmp.verifyIfEmployeeAdeedByCheckingPersonalDetails();
	}

	@DataProvider (name = "addProfilePic")
	public Object[][] dataProviderMethod2() {
		return new Object[][] {{"C:\\Users\\prati\\git\\OrangeHRM\\src\\main\\java\\project1\\ProfilePics\\picopic.jpg"}};
	}
}
