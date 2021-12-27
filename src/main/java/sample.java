import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.map.LinkedMap;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.utils.FileUtil;

public class sample {

    public static WebDriver driver;
    public static String locationvalue = "Sydney";
    
    public static String iphoneNamestxt;
    public static String iphonepricetxt;
    
    public static void main(String[] args) throws InterruptedException, AWTException, IOException {
    	
    
    	
    	
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\dorab\\AppCRM\\JombaneProject\\drivers\\chromedriver.exe");

    	driver= new ChromeDriver();
    	
    	driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 13",Keys.ENTER);
		
		
		List<WebElement> iphoneNames = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		
		for (WebElement webElement : iphoneNames) {
			 iphoneNamestxt = webElement.getText();
			 List<WebElement> iphoneprice = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
			 for (WebElement webElement1 : iphoneprice) {
					
					iphonepricetxt = webElement1.getText();
					
					Map<String,String> mp = new LinkedMap<String, String>();
					
					mp.put(iphoneNamestxt, iphonepricetxt);
					
					System.out.println(mp);
					
					Collection<String> s = mp.values();
					
					if (s.contains("79,000")) {
						webElement1.click();
						break;
					}
					
					
					
				
					
					
				}
		}
		
		
		

		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
    }
}
