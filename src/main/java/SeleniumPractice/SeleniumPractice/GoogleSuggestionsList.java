package SeleniumPractice.SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSuggestionsList {
	
	static WebDriver driver;

	public static void main(String[] args) {
	
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://www.google.co.in/");
		
		driver.manage().window().maximize();
		
	    driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("selenium online");
	    
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	     List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@role='option']//div[@class='wM6W7d']//span"));

	     
	     
	     for(int i=0;i<=list.size()-1;i++) {
	    	 
	    	 String text = list.get(i).getText();
	    	 
	    	 if(text.equals("selenium online compiler")) {
	    		 
	    		 list.get(i).click();
	    		 break;
	    	 }
	     }
	}

}
