package BANKING.GURU99;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class navigateToApplication {
	String browser;
	WebDriver driver;

	@Parameters({ "browser" })
	public navigateToApplication(String browser) {
		this.browser = browser;

	}

	@BeforeTest
	public void FireBrowser() {
		switch (browser) {
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		case "html":
			driver = new HtmlUnitDriver();
			break;
		default:
			break;
		}
	}

	@Test
	public void navigate() {
		driver.navigate().to("http://demo.guru99.com/v4/index.php");

	}

	@Test(dependsOnMethods = "navigate")
	public void Login() {
		WebElement userid = driver.findElement(By
				.xpath("html/body/form/table/tbody/tr[1]/td[2]/input"));
		userid.sendKeys("mngr94882");
		WebElement password = driver.findElement(By
				.xpath("html/body/form/table/tbody/tr[2]/td[2]/input"));
		password.sendKeys("uteramY");
		WebElement login = driver.findElement(By
				.xpath("html/body/form/table/tbody/tr[3]/td[2]/input[1]"));
		login.click();

	}

	
	  /*@Test(dependsOnMethods = "Login") public void newCustomer() {
	  
	  WebElement newcustomer = driver.findElement(By
	  .xpath("html/body/div[2]/div/ul/li[2]/a")); newcustomer.click();
	  
	  }


	
	  @Test(dependsOnMethods = "newCustomer") 
	  public void createCustomer() {
	  WebElement name = driver .findElement(By
	  .xpath("html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input"));
	  name.sendKeys("Annika"); driver.findElement(
	  By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]"))
	  .click();
	  driver.findElement(By.xpath(".//*[@id='dob']")).sendKeys("07/08/1990");
	 driver.findElement(By.xpath(
	 "html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea"
	 )).sendKeys("1234 test"); driver.findElement(By.xpath(
	 "html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input"
	 )).sendKeys("Austin"); driver.findElement(By.xpath(
	 "html/body/table/tbody/tr/td/table/tbody/tr[9]/td[2]/input"
	)).sendKeys("Texas"); driver.findElement(By.xpath(
	  "html/body/table/tbody/tr/td/table/tbody/tr[10]/td[2]/input"
	  )).sendKeys("786412"); driver.findElement(By.xpath(
	  "html/body/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input"
	  )).sendKeys("4698787455"); driver.findElement(By.xpath(
	  "html/body/table/tbody/tr/td/table/tbody/tr[12]/td[2]/input"
	  )).sendKeys("annikaa@gmail.com"); driver.findElement(By.xpath(
	  "html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]/input"
	  )).sendKeys("annika"); driver.findElement(By.xpath(
	 "html/body/table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[1]"
	  )).click();
	  
	 
	  
	  }
	 
	@Test(dependsOnMethods = "createCustomer")
	public void editCustomer() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String customerId=driver.findElement(By.xpath("//*[@id='customer']/tbody/tr[4]/td[2]"))	.getAttribute("value")	;
		System.out.println(customerId);

	}

	@Test(dependsOnMethods = "editCustomer")
	public void validate() {
		String customername = driver
				.findElement(
						By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input"))
				.getAttribute("value");
		System.out.println(customername);
		Assert.assertEquals("Annika", customername);
		System.out.println("Passed");

	//}
*/
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
