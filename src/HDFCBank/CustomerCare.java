package HDFCBank;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CustomerCare {
	
	public static void main(String[] args){
		
		//Open browser
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.hdfc.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='block-hdfc-site-banner-hdfc-header-banner']/descendant::a[text()='REACH US']")).click();
		driver.findElement(By.xpath("//*[@id='node-2602']/div/div[1]/div/div/div/section/div/section[2]/article[2]/div/a")).click();
		driver.findElement(By.xpath("html/body/div[5]/div/div[1]/div/ul/ul[2]/li[3]/a")).click();
	}

}
