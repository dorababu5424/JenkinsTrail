package CandidateProfile;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JMB_TC_023 {


    public static WebDriver driver;
    public static String dashboardurl;

    @BeforeClass
    public void StepUp() {
        // TODO Auto-generated method stub

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dorab\\AppCRM\\JombaneProject\\drivers\\chromedriver.exe");

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
    private void Tc23() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(By.xpath("//h3[text()='Employment Details ']"));


        js.executeScript("arguments[0].scrollIntoView();", Element);
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//a[@class='jb-editBtn-ed ajax-popup-mag'])[2]")).click();

        Thread.sleep(3000);
        String employeename =driver.findElement(By.id("currentEmployer")).getAttribute("value");
        System.out.println(employeename);
        driver.findElement(By.xpath("(//button[text()='Cancel'])[1]")).click();
        String perviousemp = driver.findElement(By.xpath("//span[@class='jb-cap-title-emp1']")).getText();
        Assert.assertEquals(employeename,employeename.contains("Subway"));

    }
}
