package SeleniumPractice.SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SvgElements {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://emicalculator.net/");
		
		driver.manage().window().maximize();
		
		List<WebElement> svglist = driver.findElements(By.xpath("(//*[local-name()='svg' and contains(@class,'highcharts-root')])[2]//*[name()='g' and contains(@class,'highcharts-series-group')]//*[name()='g']//*[name()='rect']"));
		
		
		for (int i=0;i<= svglist.size()-1;i++) {
			
			Actions ac = new Actions(driver);
			
			 ac.moveToElement(svglist.get(i)).build().perform();
			 
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 String text = driver.findElement(By.xpath("(//*[local-name()='svg' and contains(@class,'highcharts-root')])[2]//*[name()='g' and contains(@class,'highcharts-label highcharts-tooltip highcharts-color-undefined')]//*[name()='text']")).getText();
			 
			 System.out.println(text);
		}
	}

}
