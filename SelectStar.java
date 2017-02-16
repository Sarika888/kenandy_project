package amazon.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectStar {
	
	 WebDriver driver;
	
	@BeforeMethod
	public void Beforemethod(){
		
		//System.setProperty("webdriver.gecko.driver", "F:\\drivers\\geckodriver-v0.13.0-win64\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "F:\\drivers\\chromedriver.exe");

		// driver = new FirefoxDriver();
		driver = new  ChromeDriver();
		
		
	}
	
	
	@Test
public void SelectPhone() throws Exception{
		
		
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     // Go to URL
	     driver.get("https://www.amazon.com/");
	     
	     Thread.sleep(5000);
	     driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone 7");
	     Thread.sleep(5000);

	     driver.findElement(By.xpath("//div[@id='issDiv2']")).click();
	     Thread.sleep(5000);

	     driver.findElement(By.xpath("//*[text()='Sleeves']")).click();
	     Thread.sleep(5000);

	  WebElement ele=   driver.findElement(By.xpath("//*[@id='result_0']//a[@class='a-popover-trigger a-declarative']//span[@class='a-icon-alt']"));

	  JavascriptExecutor je = (JavascriptExecutor) driver;

		// now execute query which actually will scroll until that element is not appeared on page.
		//je.executeScript("arguments[0].scrollIntoView(true);",ele);
      je.executeScript("scroll(0,400)");
	     Thread.sleep(10000);

	     Actions action = new Actions(driver);
		     action.moveToElement(ele).perform();
		     Thread.sleep(10000);

	WebElement rating =    driver.findElement(By.xpath(".//*[@id='a-popover-content-1']/div/div/div/div[1]/span"));

    Thread.sleep(5000);

String text = rating.getAttribute("innerHTML");

	  System.out.println("The rating is :"+text);  
		
	}
	
	@AfterMethod
	public void Aftermethod(){
		
		driver.close();
	}
}

