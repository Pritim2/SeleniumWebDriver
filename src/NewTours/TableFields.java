package NewTours;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TableFields {
	
	public static void main(String[] args){
		
		//Open browser
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//User login
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("pritim1140");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		//New York to Chicago (As option Chicago is not present hence using Frankfurt)
		driver.findElement(By.xpath("//input[@value='oneway']")).click();
		Select source = new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
		source.selectByVisibleText("New York");
		Select destination = new Select(driver.findElement(By.xpath("//select[@name='toPort']")));
		destination.selectByVisibleText("Frankfurt");
		driver.findElement(By.xpath("//input[@name='findFlights']")).click();
		
		//Retrieve Table data and print
		String str1 = "html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[";
		String str2 = "]/td[";
		String str3 = "]";
		String str4 = "]/td";
		
		System.out.println("NewYork to Frankfurt Airline Details (As Chicago option is not available)");
		System.out.println("------------------------------------");
		
		for(int i=2; i<10; i++){
			
			if(((i+1)%2)!=0){
				for(int j=1; j<4; j++){
					System.out.print(driver.findElement(By.xpath(str1+(i+1)+str2+(j+1)+str3)).getText());
					System.out.print(" : ");
				
				}
				
			}
			
			if((i+1)%2==0){
				
				System.out.println(driver.findElement(By.xpath(str1+(i+1)+str4)).getText());
			}
			
		}
		
	}

}
