import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\babic\\Desktop\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.path2usa.com/travel-companions");
		
		driver.findElement(By.id("travel_date")).click();
		
		while(!driver.findElement(By.cssSelector("[class = 'datepicker-days'] [class = 'datepicker-switch']")).getText().contains("October"))
				{
			driver.findElement(By.cssSelector("[class = 'datepicker-days'] [class = 'next']")).click();
			
				}
		Thread.sleep(2000);
		
		List<WebElement> date = driver.findElements(By.className("day"));
		
		int j = driver.findElements(By.className("day")).size();
		
		for(int i = 0; i < j; i++)
		{
			String text = driver.findElements(By.className("day")).get(i).getText();
			if(text.equalsIgnoreCase("10"))
				
			{
				driver.findElements(By.className("day")).get(i).click();
			}
		}
	
		driver.close();
	
	}}
		
		
		

