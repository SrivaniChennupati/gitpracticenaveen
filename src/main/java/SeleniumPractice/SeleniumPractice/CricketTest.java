package SeleniumPractice.SeleniumPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricketTest {
	
	static WebDriver driver;

	public static void main(String[] args) {
	
		
	WebDriverManager.chromedriver().setup();
	
	 driver = new ChromeDriver();
	 
	 driver.get("https://www.espncricinfo.com/series/india-in-west-indies-2023-1381201/west-indies-vs-india-2nd-test-1381213/full-scorecard");
	 
	 driver.manage().window().maximize();
	 
	 System.out.println( getBowlerName("Ajinkya Rahane"));
	 
	 System.out.println(getScore("Virat Kohli"));

	}

	
	public static String getBowlerName(String batsman) {
		
		String xpath = "//span[text()='"+batsman+"']/ancestor::td/following-sibling::td//span";
		
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	
	public static List<String> getScore(String batsman) {
		
		List<String> ActualScorelist = new ArrayList<String>();
		
		String xpath = "//span[text()='"+batsman+"']/ancestor::td/following-sibling::td/following-sibling::td";
	
	   List<WebElement> scorelist = driver.findElements(By.xpath(xpath));
	   
	   for (int i=0;i<=scorelist.size()-1;i++) {
		   
		   String text = scorelist.get(i).getText();
		   
		   ActualScorelist.add(text);
	   }
	
	   return ActualScorelist;
	}
	
	
	

	
	
}
