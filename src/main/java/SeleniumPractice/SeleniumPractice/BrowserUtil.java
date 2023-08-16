package SeleniumPractice.SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {
	
	WebDriver driver;
	
	public WebDriver initDriver(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {

			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\sriva\\eclipse-workspace\\ChromeDriver");

			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {

			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\sriva\\eclipse-workspace\\ChromeDriver");
            
			WebDriverManager.firefoxdriver().setup();
			
			driver = new FirefoxDriver();

		} else {

			System.out.println("Please pass the Correct Browser" + browser);
		}

		return driver;
	}

	
	
	public void launchURL(String url) {
		
		if(url==null || url.isEmpty()) {
			
			return;
		}
		driver.get(url);
	}
	
	public String getPageTitle() {
		
		return  driver.getTitle();
	}
	
	public String getCurrentPageURL() {
		
		return driver.getCurrentUrl();
	}
	
	public void closeBrowser() {
		
		driver.close();
	}
}
