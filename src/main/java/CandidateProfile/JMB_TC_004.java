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

public class JMB_TC_004  {


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
    private void TC4() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='jb-cn-edit_profile ajax-popup-mag']")).click();

        Thread.sleep(6000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(By.xpath("//button[@class='btn dropdown-toggle btn-info']"));
        // Scrolling down the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);

        driver.findElement(By.id("experience")).clear();

        driver.findElement(By.id("experience")).sendKeys("6");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

       String expcount = driver.findElement(By.xpath("//label[text()='6 years']")).getText();

       String ActualExperience ="6" +
               " years";
        Assert.assertEquals(ActualExperience,expcount);





    }
}
