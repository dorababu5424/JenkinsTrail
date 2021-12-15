import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sample {

    public static WebDriver driver;
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\dorab\\AppCRM\\JombaneProject\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();



        driver.manage().window().maximize();
        driver.get("http://52.60.159.184/login");
    }
}
