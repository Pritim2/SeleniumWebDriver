package Rediff;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ajax {
	
	public static void main(String[] args){
		
		//Open browser
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://in.rediff.com");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='srchword']"))));
		
		//type h on search tab
		driver.findElement(By.xpath("//input[@id='srchword']")).sendKeys("h");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='sugbox']"))));
		List<WebElement> search = driver.findElements(By.xpath("//div[starts-with(@id,'suggest_')]"));
		System.out.println("Total number of Searched elements : "+search.size());
		System.out.println("-----------------------------------");
		
		//Print all elements
		for(int i=0; i<search.size(); i++){
			System.out.println(search.get(i).getText());
		}
	}

}
