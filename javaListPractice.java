import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class javaListPractice {
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\babic\\Desktop\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait w = new WebDriverWait(driver, 5);
		
		String[] potrebneNamirnice = {"Brocolli","Cucumber"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		
		metodaVoce(driver, potrebneNamirnice);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()= 'PROCEED TO CHECKOUT']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class = 'promoInfo']")));
		System.out.println(driver.findElement(By.xpath("//span[@class = 'promoInfo']")).getText());
	
	}
	
	public static void metodaVoce(WebDriver driver, String[] potrebneNamirnice) {
		
		int j = 0;
		List<WebElement> sveNamirnice = driver.findElements(By.cssSelector("h4.product-name"));
		List listaPotrebnihNamirnica = Arrays.asList(potrebneNamirnice);
		
		for(int i = 0; i <= sveNamirnice.size(); i++) {
			String[] imeJedneNamirnice = sveNamirnice.get(i).getText().split("-");
			String formatiranoImeNamirnice = imeJedneNamirnice[0].trim();
			
			if(listaPotrebnihNamirnica.contains(formatiranoImeNamirnice)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click(); {
				if(j==listaPotrebnihNamirnica.size()) {
					break;
				}
				}
				
			}
		}
	}
	
	
	}
	