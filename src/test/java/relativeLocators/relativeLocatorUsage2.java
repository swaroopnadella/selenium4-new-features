package relativeLocators;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatorUsage2 {
	
	@Test
	public void relativeLocator1() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//WebDriverManager.edgedriver().setup();
		//WebDriver driver = new EdgeDriver();
		driver.get("https://automationbookstore.dev/");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		WebElement advSelJavaTag = driver.findElement(withTagName("li").toRightOf(By.id("pid5")).below(By.id("pid2")));
		
		WebElement advSelJavaText = advSelJavaTag.findElement(By.id("pid6_title"));
		
		System.out.println(advSelJavaText.getText());
		Assertions.assertTrue(advSelJavaText.getText().contains("Advanced Selenium in Java"));
		
		driver.quit();
		
	}
}