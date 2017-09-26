package PageObjectClass;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import ObjectRepo.HomePageRepo;

public class HomePage extends HomePageRepo {
	WebDriver driver;
	String customerId;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String clickOncreateNewAccountLink(Map<String, String> map) {
		Wait<WebDriver> wait = new FluentWait<>(driver)
		// wait for the condition
				.withTimeout(10, TimeUnit.SECONDS)
				// which to check for the condition with interval of 5 seconds.
				.pollingEvery(5, TimeUnit.SECONDS)
				// which will ignore the Nosuch element exception
				.ignoring(NoSuchElementException.class)
				// will ignore illegal state exceptiom
				.ignoring(IllegalStateException.class)
				// send out string messages
				.withMessage("will wait 5 seconds");
		wait.until(
				ExpectedConditions
						.presenceOfElementLocated(createNewAccountLink))
				.click();
		driver.findElement(CustomerName).sendKeys(map.get("CustomerName"));
		driver.findElement(Gender).click();
		driver.findElement(DOB).sendKeys(map.get("DOB"));
		driver.findElement(Address).sendKeys(map.get("Address"));
		driver.findElement(City).sendKeys(map.get("City"));
		driver.findElement(State).sendKeys(map.get("State"));
		driver.findElement(PIN).sendKeys(map.get("PIN"));
		driver.findElement(Mobile).sendKeys(map.get("Mobile"));
		driver.findElement(Email).sendKeys(map.get("Email"));
		driver.findElement(Password1).sendKeys(map.get("Password1"));
		driver.findElement(Submit1).click();
		this.customerId = driver.findElement(CustomerID).getText();
		return customerId;

	}

	public EditPage navigateToEditPage() {
		return new EditPage(driver);

	}

	public void Logout() {
		driver.findElement(logout).click();
		String logoutmessage = driver.switchTo().alert().getText();
		System.out.println(logoutmessage);
		driver.switchTo().alert().accept();

	}

}
