package techproed.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04 {


    // https://www.bestbuy.com/ sayfasına gidin
   // sayfa Title'ini alın "Best" içerdigini test edin
   // BestBuy logosunun görüntülendigini test edin
    // Canada logosunun görüntülendigini test edin
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
       driver.close();
    }

    @Test
    public void test01() {

        // https://www.bestbuy.com/ sayfasına gidin
        driver.get(" https://www.bestbuy.com/");

        // sayfa Title'ini alın "Best" içerdigini test edin
        String bestByTitle= driver.getTitle();

        Assert.assertTrue(bestByTitle.contains("Best"));

        // BestBuy logosunun görüntülendigini test edin
      WebElement bestBuylogo= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
      Assert.assertTrue(bestBuylogo.isDisplayed());

        // Canada logosunun görüntülendigini test edin
       WebElement canadaLogo = driver.findElement(By.xpath("(//img[@alt='Canada'])[1]"));
       Assert.assertTrue(canadaLogo.isDisplayed());

    }
}
