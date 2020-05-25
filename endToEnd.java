import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class endToEnd {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\babic\\Desktop\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		
		Select a = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		Select b = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child")));
		Select c = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Infant")));
		Select d = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();// Ako sklonimo ovu liniju koda(tj. ako zelimo kartu u jednom smeru) neophodno je da ne sledecoj liniji koda kod assert stavimo false jer ce se u tom slucaju check button biti odcekiran(False) i podrazumevati da je jednosmerna karta u pitanju
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isSelected());

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).sendKeys("Amri");
		Thread.sleep(2000);
		
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).sendKeys("Kol");
		
		driver.findElement(By.cssSelector("#ui-datepicker-div > div.ui-datepicker-group.ui-datepicker-group-first > table > tbody > tr:nth-child(1) > td.ui-datepicker-today > a")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#divpaxinfo")).click();
		Thread.sleep(2000);
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
			System.out.println("Ovo je opcija za kupovinu karte u jednom smeru");
		}else {
			System.out.println("Ovo je opcija za kupovinu povratne karte");
		}
						
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_Adult")).click();
		a.selectByValue("4");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_Child")).click();
		b.selectByValue("2");
		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_Infant")).click();
		c.selectByVisibleText("2");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).click();
		d.selectByVisibleText("USD");
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();
		
		Thread.sleep(3000);
		driver.close();
		
		
		
		
		
		
}
}