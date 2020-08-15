package relativeLocators;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

public class relativeLocatorUsage1 {
	
	@Test
	public void relativeLocator1() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		
		WebElement login = driver.findElement(withTagName("input").below(By.id("txtPassword")));
		
		login.click();
		
		WebElement dashboardHeader = driver.findElement(By.xpath("//div[@class='head']/h1"));
		Assertions.assertTrue(dashboardHeader.getText().contains("Dashboard"));
		
	}
}
