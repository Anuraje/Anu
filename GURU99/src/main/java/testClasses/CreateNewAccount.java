package testClasses;

import java.util.Map;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BANKING.GURU99.navigateToApplication;
import PageObjectClass.DeletePage;
import PageObjectClass.EditPage;
import PageObjectClass.HomePage;
import PageObjectClass.LoginPage;
import Utilities.BaseClass;

public class CreateNewAccount extends BaseClass {
	LoginPage loginpage;
	HomePage homepage;
	EditPage editPage;
	DeletePage deletepage;
	
	@Parameters({"browser", "startRow","endRow","csvFile"})
	public CreateNewAccount(String browser, int startRow, int endRow, String csvFile) {
		super(browser,startRow,endRow,csvFile);
	}
	
	@Test(dataProvider="csvData")
	public void CreateNewAccountfromHomePage(Map<String, String> map){
		loginpage=navigateToApplication();
		homepage=loginpage.Login(map);
		String custId=homepage.clickOncreateNewAccountLink(map);
		editPage=homepage.navigateToEditPage();
		String customerid=editPage.editThePage(custId);
		deletepage=editPage.navigateToDeletePage();
		deletepage.DeleteCustomer(customerid);
		homepage=deletepage.navigateToHomePage();
		homepage.Logout();
		//CloseBrowser();
		
		
	}
	
	

}
