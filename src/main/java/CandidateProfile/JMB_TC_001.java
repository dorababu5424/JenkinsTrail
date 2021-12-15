package CandidateProfile;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class JMB_TC_001 {


	public static WebDriver driver;
	public  static String dashboardurl;
	@BeforeClass
	public  void StepUp() {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Users\\dorab\\AppCRM\\JombaneProject\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://52.60.159.184/login");

	}

	@BeforeMethod
	public void Login() throws InterruptedException {
		// TODO Auto-generated method stub
		driver.findElement(By.id("email")).sendKeys("kauromkar94@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Omk@r123");
		driver.findElement(By.id("sbBt")).click();
		String dashboardpageurl = driver.getCurrentUrl();
		dashboardurl = dashboardpageurl;
		System.out.println(dashboardurl);
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//a[text()='UPDATE PROFILE']")).click();
		} catch (Exception e) {
			System.out.println("No update button");
		}


	}

	@Test
	private void Tc1() throws IOException {
		// TODO Auto-generated method stub

		String  expectedUrl ="http://52.60.159.184/candidate/profile";
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl,expectedUrl);

	}



	@AfterMethod
	public  void Logout() {
		// TODO Auto-generated method stub

	}


	@AfterClass
	private void teardown() {
		// TODO Auto-generated method stub
		//	driver.quit();
	}



	


}
