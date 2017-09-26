package ObjectRepo;

import org.openqa.selenium.By;

public class DeletePageRepo {
	protected By deletecustomerlink= By.xpath("//a[@href='DeleteCustomerInput.php']");
	protected By custIdbox=By.xpath("//input[@name='cusid']");
	protected By submitbutton= By.xpath("//input[@type='submit']");

}
