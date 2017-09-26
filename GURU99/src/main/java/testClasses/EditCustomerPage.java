package testClasses;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjectClass.EditPage;
import Utilities.BaseClass;

public class EditCustomerPage extends BaseClass {
	EditPage editpage;
	
	@Parameters("browser")
	public EditCustomerPage(String browser) {
		super(browser);
	}
	
	public void editTheCustomer(){
		//editpage.editThePage();
		
	}

}
