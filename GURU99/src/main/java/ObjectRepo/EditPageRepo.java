package ObjectRepo;

import org.openqa.selenium.By;

public class EditPageRepo {
	protected By editCustomer= By.xpath("//a[@href='EditCustomer.php']");
	protected By PassCustomerId = By.xpath("//input[@name='cusid']");
    protected By submitbutton= By.xpath("//input[@type='submit']");
}
