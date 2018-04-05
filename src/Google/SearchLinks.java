package Google;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchLinks {
	
	public static void main(String[] args){
		
		//Open the browser
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(int i=1;i<links.size();i++){
			boolean b = links.get(i).isDisplayed();
			if(b == true)
				System.out.println(links.get(i).getText());
		}
	}

}
