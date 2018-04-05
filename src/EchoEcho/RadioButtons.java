package EchoEcho;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class RadioButtons {
	
	public static void main(String[] args) throws AWTException{
		
		//Open browser
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://www.echoecho.com/htmlforms10.htm");
		
		//Mouse Movement
		WebElement object = driver.findElement(By.xpath("html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td"));
		Actions action = new Actions(driver);
		Point move = object.getLocation();
		action.moveToElement(object).moveByOffset(move.getX(), move.getY()).build().perform();
		
		//Validate checked option
		String str1 = "html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td/input[";
		String str2 = "]";
		for(int i=1;i<=6;i++){
			WebElement btnRadio = driver.findElement(By.xpath(str1+i+str2));
			Boolean selected = btnRadio.isSelected();
			if(selected == true){
				System.out.println("Selected Radio button "+i+" : "+btnRadio.getAttribute("Value"));
			}
		}
		
	}

}
