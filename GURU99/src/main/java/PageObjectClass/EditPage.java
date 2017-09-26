package PageObjectClass;

import org.openqa.selenium.WebDriver;

import ObjectRepo.EditPageRepo;

public class EditPage extends EditPageRepo {
	WebDriver driver;
	HomePage homePage;
	String customerId;

	
	public EditPage(WebDriver driver) {
    this.driver=driver;
    

	}
	
	public String editThePage(String custId){
	driver.findElement(editCustomer).click();
	driver.findElement(PassCustomerId).sendKeys(custId);
	driver.findElement(submitbutton).click();
	System.out.println(custId);
	System.out.println("Customer Created");
	return custId;
	
		
		
	}
	public DeletePage navigateToDeletePage(){
		return new DeletePage(driver);
	}
	
	

}
