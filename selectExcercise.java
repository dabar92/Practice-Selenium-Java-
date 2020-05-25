import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class selectExcercise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\babic\\Desktop\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.cleartrip.com/");
		Thread.sleep(2000);
		driver.findElement(By.id("Adults")).click();
		
		Select a = new Select(driver.findElement(By.id("Adults")));
		a.selectByValue("2");
		
		driver.findElement(By.id("Childrens")).click();
		
		Select b = new Select(driver.findElement(By.id("Childrens")));
		b.selectByValue("1");
		
		driver.findElement(By.id("MoreOptionsLink")).click();
		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("9 air");
		Thread.sleep(2000);
		driver.findElement(By.id("SearchBtn")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
		
		
		
		
		
	}

}
