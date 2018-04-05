package Spicejet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Calendar_Selection {

	static FirefoxDriver driver;
	public static void main(String[] args) throws ParseException{
		
		//Date
		String d = "20/06/2018";
		String sMonth[]= {"January","February","March","April","May","June","July","August","September","October","November","December"};		

		//Extract Date and convert to calendar
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date sdate = dateFormat.parse(d);
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdate);
		
		//Extract date, month and year
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		System.out.println("Year : "+year);
		System.out.println("Month : "+sMonth[month]);
		System.out.println("Date : "+day);
		
		//Open Spicejet site
		driver = new FirefoxDriver();
		driver.get("https://book.spicejet.com");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='custom_date_picker_id_1']")).click();
		
		//Select year
		selectYear(year);
		
		//Select month
		String sdMonth = sMonth[month];
		selectMonth(sdMonth);
		
		//Select date
		selectDate(day);
		
		System.out.println("Date has been successfully selected");
		d=null;
	}
	
	private static void selectYear(int year) {
		
		String curYear = "//div[@id='ui-datepicker-div']/descendant::span[@class='ui-datepicker-year']";
		String btnNext = "//div[@id='ui-datepicker-div']/descendant::span[text()='Next']";
		String strYear = Integer.toString(year);
		while(!driver.findElement(By.xpath(curYear)).getText().equals(strYear)){
			driver.findElement(By.xpath(btnNext)).click();
		}
		
	}
	
	private static void selectMonth(String month) {
		String curMonth = "//div[@id='ui-datepicker-div']/descendant::span[@class='ui-datepicker-month']";
		String btnNext = "//div[@id='ui-datepicker-div']/descendant::span[text()='Next']";
		while(!driver.findElement(By.xpath(curMonth)).getText().equals(month)){
			driver.findElement(By.xpath(btnNext)).click();
		}
		
	}
	
	private static void selectDate(int day) {
		// TODO Auto-generated method stub
		String part1 = "//div[@id='ui-datepicker-div']/descendant::div[@class='ui-datepicker-group ui-datepicker-group-first']/table/tbody/tr[";
		String part2 = "]/td[";
		String part3 = "]";
		
		for(int rNum=1; rNum<=6; rNum++){
			for(int cNum=1; cNum<=7; cNum++){
				String date = driver.findElement(By.xpath(part1+rNum+part2+cNum+part3)).getText();
				System.out.print(date+" ");
				if(!date.equals(" ")){
					int curDay = Integer.parseInt(date);
					if(curDay == day){
						driver.findElement(By.xpath(part1+rNum+part2+cNum+part3)).click();
						return;
					}
				}
			}
			System.out.println();
		}
		
	}



}
