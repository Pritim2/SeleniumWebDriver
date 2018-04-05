package Yatra;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Login_SourceDestination {
	
	public static void main(String[] args){
		
		//Declare userID and password- Need to update
		String phoneNO = "7875286668";
		String password = "yatrag5.";
		
		//Open Yatra booking site
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.yatra.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Set Action mode for hovering mouse action
		Actions action = new Actions(driver);
		WebElement myAccount = driver.findElement(By.xpath("//li[@id='userSignInStrip']/a[@class='dropdown-toggle']"));
		action.moveToElement(myAccount).moveToElement(driver.findElement(By.xpath("//a[@id='signInBtn']"))).click().build().perform();
		
		//Provide User ID and password
		driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys(phoneNO);
		//Select ISD code
		Select isdCode = new Select(driver.findElement(By.name("isdCode")));
		isdCode.selectByVisibleText("India (+91)");
		driver.findElement(By.xpath("//button[@id='login-continue-btn']")).click();
		driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='login-submit-btn']")).click();
		
		//Select Source and Destination
		driver.findElement(By.xpath("//a[@id='booking_engine_buses']")).click();
		driver.findElement(By.xpath("//input[@id='BE_bus_from_station']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//input[@id='BE_bus_to_station']")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("//form[@id='BE_bus_form']/h1")).click();
	}

}
