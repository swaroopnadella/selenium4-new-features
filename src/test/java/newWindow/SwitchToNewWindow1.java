package newWindow;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchToNewWindow1 {
	
	@Test
	public void switchNewWindow() throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://in.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assertions.assertTrue(driver.getTitle().contains("Yahoo India"));
		String currentWindow = driver.getWindowHandle();
		System.out.println(currentWindow);
		
		//switchTo.newWindow() -- new method in Selenium 4
		//newWindow() method new WebDriver object for the new window created
		//WindowType.WINDOW - opens new browser window
		WebDriver newWindowDriver = driver.switchTo().newWindow(WindowType.WINDOW);
		String newWindow = newWindowDriver.getWindowHandle();
		System.out.println(newWindow);
		newWindowDriver.get("https://www.google.com/");
		newWindowDriver.manage().window().maximize();
		newWindowDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		newWindowDriver.findElement(By.name("q")).sendKeys("Selenium 4");
		Thread.sleep(3000);
		List<WebElement> searchResults = newWindowDriver.findElements(By.className("sbl1"));
		for(WebElement text:searchResults) {
			//System.out.println(text.findElement(By.tagName("span")).getText());
			if(text.findElement(By.tagName("span")).getText().contains("release date")) {
				text.click();
				break;
			}
		}
		String firstResultText = newWindowDriver.findElement(By.xpath("//*[@class='LC20lb DKV0Md'][1]")).getText();
		Assertions.assertTrue(firstResultText.contains("Latest Version of Selenium"));
		newWindowDriver.close();
		
		//switching back to current window using handle, is needed before we do further operations on parent window
		driver.switchTo().window(currentWindow);
		WebElement searchInput = driver.findElement(By.id("header-search-input"));
		searchInput.sendKeys("google founder name");
		driver.findElement(By.id("header-desktop-search-button")).click();
		String str = driver.findElement(By.xpath("//h3[@class='title ov-h']/a")).getText();
		Assertions.assertTrue(str.contains("History of Google - Wikipedia"));
		driver.quit();
	}
}
