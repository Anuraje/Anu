package Utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.DataProvider;

import au.com.bytecode.opencsv.CSVReader;
import PageObjectClass.LoginPage;

public class BaseClass {
	WebDriver driver;
	String browser;
	int startRow;
	int endRow;
	String csvFile;
	PropertiesManager propertiesmanager = PropertiesManager.PROPERTIES;
	public BaseClass(String browser, int startRow, int endRow, String csvFile) {
		this.browser = browser;
		this.startRow = startRow;
		this.endRow = endRow;
		this.csvFile = csvFile;
	}

	

	public BaseClass(String browser) {
		this.browser = browser;
	}

	public LoginPage navigateToApplication() {
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
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		//driver.navigate().to("http://demo.guru99.com/v4/index.php");
		driver.navigate().to(propertiesmanager.getProperty("env_url"));
		return new LoginPage(driver);
	}

	@DataProvider(name = "csvData")
	public Object[][] provideCSVData() {

		Object[][] testNgData = null;
		try {
			
			CSVReader reader = new CSVReader(new FileReader(csvFile));
			String[] headers = reader.readNext();
			String[] inputLine = null;

			try {
				int counter = 1;
				int testNgDataIndex = 0;
				testNgData = new Object[endRow - startRow + 1][1];
				//System.out.println(testNgData);
				while ((inputLine = reader.readNext()) != null) {
					if (startRow <= counter && endRow >= counter) {
						Map<String, String> csvMap = new HashMap<String, String>();
						for (int index = 0; index < inputLine.length; index++) {
							csvMap.put(headers[index], inputLine[index]);
							System.out.println(headers[index]);
							System.out.println(inputLine[index]);
						}
						testNgData[testNgDataIndex++][0] = csvMap;
					}
					counter++;
				}
			} catch (IOException ioe) {
				System.out.println(ioe);
				// throw new
				// TestNGUtilityException("Error while attemping to read around line ["
				// + rowCount + "] of file [" + fileName + "] - ", ioe);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return testNgData;
	}

	public void CloseBrowser() {
		driver.close();
	}
}