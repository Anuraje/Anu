package ObjectRepo;

import org.openqa.selenium.By;

public class HomePageRepo {
	protected By createNewAccountLink=By.xpath("//a[@href='addcustomerpage.php']");
	protected By CustomerName=By.xpath("//input[@name='name']");
	protected By Gender=By.xpath("//input[@value='f']");
	protected By DOB=By.xpath("//input[@id='dob']");
	protected By Address=By.xpath("//textarea[@cols='20']");
	protected By City=By.xpath("//input[@name='city']");
	protected By State=By.xpath("//input[@name='state']");
	protected By PIN=By.xpath("//input[@maxlength='6']");
	protected By Mobile=By.xpath("//input[@maxlength='15']");
	protected By Email=By.xpath("//input[@maxlength='30']");
	protected By Password1=By.xpath("//input[@name='password']");
	protected By Submit1=By.xpath("//input[@name='sub']");
	protected By CustomerID= By.xpath("//*[@id='customer']/tbody/tr[4]/td[2]");
	protected By logout=By.xpath("//a[@href='Logout.php']");	
	
	
	
	
	
}
