package HDFCBank;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreditCard {
	
	public static void main(String[] args) throws InterruptedException{
		
		//Open browser
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://hdfcbank.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Hover on Product
		Actions action = new Actions(driver);
		WebElement product = driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[3]/ul/li[2]/div[1]"));
		action.moveToElement(product).moveToElement(driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[3]/ul/li[2]/div[2]/div[2]/div[1]/ul/li[3]"))).build().perform();
		Thread.sleep(3000);
		List<WebElement> atags = driver.findElements(By.xpath("html/body/div[1]/div[1]/div[2]/div[3]/ul/li[2]/div[2]/div[2]/div[2]/div[3]/div/ul/li"));
		System.out.println("Total Elements : "+atags.size());
		
		for(int i=0;i<atags.size();i++){
			if(atags.get(i).getText().equals("Credit Cards")){
				
				System.out.println("Credit Cards --- found");
				String str1 = "html/body/div[1]/div[1]/div[2]/div[3]/ul/li[2]/div[2]/div[2]/div[2]/div[3]/div/ul/li["+(i+1)+"]";
				System.out.println(str1);
				driver.findElement(By.xpath(str1)).click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
				
		}
	}

}
