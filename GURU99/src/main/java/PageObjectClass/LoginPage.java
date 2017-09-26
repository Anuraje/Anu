package PageObjectClass;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectRepo.LoginPageObjRepo;

public class LoginPage extends LoginPageObjRepo {
	WebDriver driver;
	WebDriverWait webdriverwait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage Login(Map<String ,String> map) {
		webdriverwait=new WebDriverWait(driver, 3,100);
		webdriverwait.until(ExpectedConditions.presenceOfElementLocated(username)).sendKeys(map.get("username"));
		webdriverwait.until(ExpectedConditions.presenceOfElementLocated(password)).sendKeys(map.get("password"));
		webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(submit)).click();
		return new HomePage(driver);
	}

}
