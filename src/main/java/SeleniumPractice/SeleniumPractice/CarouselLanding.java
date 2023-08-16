package SeleniumPractice.SeleniumPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarouselLanding {

	public static void main(String[] args) {
	
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
		List<WebElement> productslist = driver.findElements(By.xpath("//h2[text()='Today’s Deals']/parent::div/following-sibling::div//span[contains(@class,'a-truncate a-size-base')]"));
		List<String> actualprolist = new ArrayList<String>();
		
		while(!driver.findElement(By.xpath("//a[@aria-label='Carousel next slide']")).getAttribute("class").contains("control-disabled")) {
			
			for(WebElement e : productslist) {
				
				String text = e.getText();
				
				if(!text.isEmpty()) {
				
			actualprolist.add(text);
				}
			}
			
			driver.findElement(By.xpath("//a[@aria-label='Carousel next slide']")).click();
			productslist = driver.findElements(By.xpath("//h2[text()='Today’s Deals']/parent::div/following-sibling::div//span[contains(@class,'a-truncate a-size-base')]"));
			
		}

		for(String e :actualprolist ) {
			
			System.out.println(e);
		}
		
	}

}
