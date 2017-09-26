package PageObjectClass;

import org.openqa.selenium.WebDriver;

import ObjectRepo.DeletePageRepo;

public class DeletePage extends DeletePageRepo {

	WebDriver driver;
	EditPage editpage;
	String customerid;

	public DeletePage(WebDriver driver) {
		this.driver = driver;
	}
	public void DeleteCustomer(String customerid){
		driver.findElement(deletecustomerlink).click();
		driver.findElement(custIdbox).sendKeys(customerid);
		driver.findElement(submitbutton).click();
		driver.switchTo().alert().accept();
		String deletemessage=driver.switchTo().alert().getText();
		System.out.println(deletemessage);
		driver.switchTo().alert().accept();
		
	}
	public HomePage navigateToHomePage(){
		return new HomePage(driver);
	}
}
