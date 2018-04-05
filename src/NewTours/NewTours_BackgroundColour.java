package NewTours;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewTours_BackgroundColour {
	
	public static void main(String[] args) throws AWTException{
		
		//Open browser
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//get Background color before mouse movement
		String backGroundColor_01 = driver.findElement(By.xpath("html/body/div[1]")).getCssValue("background-color");
		System.out.println("BackGroundColor : "+backGroundColor_01);
		
		//Mouse Movement
		
		WebElement object = driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]"));
		Point img = object.getLocation();
		Robot robot = new Robot();
		robot.mouseMove(img.getX(), img.getY()+80);
		
		//get Background color after mouse movement
		String backGroundColor_02 = driver.findElement(By.xpath("html/body/div[1]")).getCssValue("background-color");
		System.out.println("BackGroundColor : "+backGroundColor_02);
	}

}
