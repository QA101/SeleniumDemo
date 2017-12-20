import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class DemoqaExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Alexis\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demoqa.com");
		driver.findElement(By.partialLinkText("Registration")).click();

		if(driver.getCurrentUrl().contains("registration")) {
			System.out.println("Hey, we made it");
		}

		//Fill in first name
		driver.findElement(By.id("name_3_firstname")).sendKeys("Dustin");
		Select country = new Select(driver.findElement(By.id("dropdown_7")));
		country.selectByValue("United States");
		
		List<WebElement> status = driver.findElements(By.name("radio_4[]"));
		
		for(WebElement w : status) {
			if(w.getAttribute("value").equals("married")) {
				w.click();
			}
		}
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(scrFile, new File("C:\\Users\\Alexis\\Documents\\screenshot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		driver.quit();
	}

}
