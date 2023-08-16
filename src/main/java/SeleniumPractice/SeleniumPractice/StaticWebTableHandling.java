package SeleniumPractice.SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebTableHandling {
	
	public static WebDriver driver;

	public static void main(String[] args) {
	
		
		WebDriverManager.chromedriver().setup();
		
         driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		driver.manage().window().maximize();
		
		getData("3");
		

	}
	
	public static void getData(String coulumno) {
	
		////table[@id='customers']/tbody//tr[3]//td[1]
		
		String beforexpath = "//table[@id='customers']/tbody//tr[";
		
		String afrerxpath = "]//td["+coulumno+"]";
		
		 List<WebElement> rowlist= driver.findElements(By.xpath("//table[@id='customers']/tbody//tr"));
		 
		int rowcount= rowlist.size();
		
		for(int i=2;i<=rowcount-1;i++) {
			
			String completexpath = beforexpath+i+afrerxpath;
			
			String text = driver.findElement(By.xpath(completexpath)).getText();
			
			System.out.println(text);
		}
	}

}
