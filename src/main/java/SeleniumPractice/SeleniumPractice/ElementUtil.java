package SeleniumPractice.SeleniumPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	
   private WebDriver driver;
   
   public ElementUtil(WebDriver driver) {
	   
	   this.driver = driver;
   }

   
   public WebElement getElement(By locator) {
	   
	 return   driver.findElement(locator);
   }
   
   public void doSendKeys(By locator,String value) {
	   
	   getElement(locator).sendKeys(value);
   }
   
   public void doClick(By locator) {
	   
	   getElement(locator).click();
   }
   
   public String dogetText(By locator) {
	   
	  return getElement(locator).getText();
   }
   
   public boolean doIsDisplayed(By locator) {
	   
	  return  getElement(locator).isDisplayed();
   }
   
   public boolean doIsEnabled(By locator) {
	   
		  return  getElement(locator).isEnabled();
	   }
   
   public boolean doIsSelected(By locator) {
	   
		  return  getElement(locator).isSelected();
	   }
   
   public String doGetAttributeValue(By locator,String AttrName) {
	   
	  return getElement(locator).getAttribute(AttrName);
   }
   
   public boolean checkElementDisabled(By locator,String AttrName) {
	   
	   String attributeValue = doGetAttributeValue(locator, AttrName);
	   
	   if(attributeValue.equalsIgnoreCase("true")){
		   
		   return true;
	   }
	   		return false;
   }
   
   
   public List<WebElement> getElements(By locator) {
	   
	  return  driver.findElements(locator);
   }
   
   public void doLinkClick(List<WebElement> linkslist,String linkvalue) {
	   
	   for (WebElement e : linkslist) {
		   
		   String text = e.getText();
		   
		   if(text.trim().equalsIgnoreCase(linkvalue)){
			   
			   e.click();
			   break;
		   }
	   }
   }
   
   public boolean checkElementDisplayed(By locator) {
	   
	  if( getElements(locator).size()==1) {
		  
		  return true;
	  }
	  return false;
   }
   public boolean checkElementDisplayed(By locator,int Occurance) {
	   
		  if( getElements(locator).size()==Occurance) {
			  
			  return true;
		  }
		  return false;
	   }
   
   public boolean doSelectByIndex(By locator,int index,String expectedvalue) {
	   
	   Select se = new Select(getElement(locator));
	   
	   se.selectByIndex(index);
	   
	   return isDropdownValueSelected(se,expectedvalue );
   }
   
   public void doSelectByVisibleText(By locator,String text) {
	   
	   Select se = new Select(getElement(locator));
	   
	   se.selectByVisibleText(text);
	   
	   isDropdownValueSelected(se, text);
   }
   
   public boolean doSelectByValue(By locator,String value) {
	   
	   Select se = new Select(getElement(locator));
	   
	   se.selectByValue(value);
	   
	   return isDropdownValueSelected(se, value);
   }
   
   public void selectValueDropdown(By locator,String value) {
	   
	   Select se = new Select(getElement(locator));
	   
	   List<WebElement> optionslist = se.getOptions();
	   
	   for (int i=0;i<=optionslist.size()-1;i++) {
		   
		   String text = optionslist.get(i).getText();
		   
		   if(text.equalsIgnoreCase(value)) {
			   
			   optionslist.get(i).click();
			   break;
		   }
	   }
	   
	   
   }
   
   public void doSelectDropdown(By locator,String value) {
	   
	   List<WebElement> list = getElements(locator);
	   
	   for(WebElement e : list) {
		   
		   String text = e.getText();
		   
		   if(text.equalsIgnoreCase(value)) {
			   
			   e.click();
			   break;
		   }
	   }
   }
   
   public void iterateDropdownAndSelect(List<WebElement> list,String value) {
	   
	   for(WebElement e: list) {
		   
		   String text = e.getText();
		   
		   if(text.equalsIgnoreCase(value)) {
			   
			   e.click();
			   break;
		   }
	   }
   }
   
   public void googleSearchAndSelect(By Searchlocator,String searchkey,By suggestionlistlocator,String value) {
	   
	   doSendKeys(Searchlocator,searchkey );
	   
	   try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   List<WebElement> list = getElements(suggestionlistlocator);
	   
	   for(WebElement e :list) {
		   
		   String text = e.getText();
		   
		   if(text.equalsIgnoreCase(value)) {
			   
			   e.click();
			   break;
		   }
	   }
   }
   
   public boolean isDropdownValueSelected(Select se,String value) {
	   
	   String text = se.getFirstSelectedOption().getText();
	   
	   if(text.contains(value)) {
		   
		   return true;
	   }
	   
	   return false;
   }
   
	public void multiChoiceSelection(By locator, String... value) {

		List<WebElement> choicelist = getElements(locator);

		if (!value[0].equalsIgnoreCase("ALL")) {

			for (int i = 0; i <= choicelist.size() - 1; i++) {

				String text = choicelist.get(i).getText();

				for (int j = 0; j <= value.length - 1; j++) {

					if (text.equals(value[j])) {

						choicelist.get(i).click();
						break;
					}

				}

			}
		}

		else {

			for (WebElement e : choicelist) {

				e.click();
			}

		}
	}
	
	
	public void parentChildMenuHandle(By Parentlocator,By childlocator) {
		
		Actions ac = new Actions(driver);
		
		ac.moveToElement(getElement(Parentlocator)).build().perform();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doClick(childlocator);
	}
	
	public List<String> getRightClickList (By locator,By listlocator) {
		
		Actions ac = new Actions(driver);
		
		List<String> itemslist = new ArrayList<String>();
		
		ac.contextClick(getElement(locator)).build().perform();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<WebElement> list = getElements(listlocator);
		
		for(int i=0;i<=list.size()-1;i++) {
			
			String text = list.get(i).getText();
			
			System.out.println(text);
			
			itemslist.add(text);
		}
		return itemslist;
	}
	
	
	public void doActionSendkeys(By locator,String value) {
		
		Actions ac = new Actions(driver);
		
		ac.sendKeys(getElement(locator),value).build().perform();
	}
	
	public void doActionsClick(By locator) {
		
		Actions ac = new Actions(driver);
		
		ac.click(getElement(locator)).build().perform();
	}
	
	public WebElement waitForElementPresence(int timeout,By locator) {
		
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

public WebElement waitForElementPresence(int timeout,By locator,long pollingtime) {
		
		WebDriverWait wait = new WebDriverWait(driver,timeout,pollingtime);
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

   public Alert waitForAlert(int timeout) {
	
	WebDriverWait wait = new WebDriverWait(driver,timeout);
	
	return wait.until(ExpectedConditions.alertIsPresent());
}


    public void acceptAlert(int timeout) {
	
    	waitForAlert(timeout).accept();
}
    
    public void dismissAlert(int timeout) {
    	
    	waitForAlert(timeout).dismiss();
}
    
    public void doAlertSendKeys(int timeout,String value) {
    	
    	waitForAlert(timeout).sendKeys(value);
    }
    
    public String doAlertGetText(int timeout) {
    	
    	return waitForAlert(timeout).getText();
    }
    
    public boolean waitForURL(int timeout,String fractionvalue) {
    	
    	WebDriverWait wait = new WebDriverWait(driver,10);
    	
    	if( wait.until(ExpectedConditions.urlContains(fractionvalue))) {
    		
           return true;
    	}
		return false;
    }
    
    public String waitForTitle(String titlefraction) {
    	
    	WebDriverWait wait = new WebDriverWait(driver,10);
    	
    	if (wait.until(ExpectedConditions.titleContains(titlefraction))) {
    		
    		return driver.getTitle();
    	}
		return null;
    }
    
    public void waitForFrame(int timeout,By locator) {
    	
    	WebDriverWait wait = new WebDriverWait(driver,timeout);
    	
    	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }
    
    public WebElement retryingElement(By locator) {
    	
    	WebElement element = null;
    	
    	int attempts =0;
    	
    	while(attempts<10) {
    		
    		try {
				element = driver.findElement(locator);
				break;
			} catch (NoSuchElementException  e) {
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println("element is not found with in given attemots" +attempts);
			}
                  attempts++;
    	}
    	
    	return element;
    }
    
    
    
    
	
}
