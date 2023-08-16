package SeleniumPractice.SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderHandling {
	
	public static  WebDriver driver;

	public static void main(String[] args) {
		
		String ExpectedDateYear = "August 2023";

       WebDriverManager.chromedriver().setup();
       
       driver = new ChromeDriver();
       
       driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

       
       driver.manage().window().maximize();
       
       
       driver.findElement(By.id("datepicker")).click();
       
    
       
	}
	
	
	public  static void selectDay(String ExpectedDateYear, String day) {
		
		String ActualDateYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
	    
	       
		
		if (Integer.parseInt(day)>31){
		
		
	       
	       while(!ActualDateYear.equalsIgnoreCase(ExpectedDateYear)) {
	    	   
	    	   driver.findElement(By.xpath("//span[text()='Next']")).click();
	    	   
	    	   ActualDateYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
	    	   
	       }
	       
	       selectDate(day);
		}
	}
	
	public static  void selectDate(String day) {
		
		driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
	}
	
	

}
