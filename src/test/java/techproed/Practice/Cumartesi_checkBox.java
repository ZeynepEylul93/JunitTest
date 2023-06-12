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

public class Cumartesi_checkBox {
    // https://demo.guru99.com/test/radio.html adresine gidin
// checkbox elementlerini locate edin
// checkbox1 ve checkbox3  secili degil ise secin
// checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
// checkbox2 elementinin secili olmadıgını test edin
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
      //  driver.close();
    }

    @Test
    public void test01() {
        // https://demo.guru99.com/test/radio.html adresine gidin
        driver.get(" https://demo.guru99.com/test/radio.html");


// checkbox elementlerini locate edin
        WebElement chekBox1= driver.findElement(By.xpath("//input[@id='vfb-6-0']"));
        WebElement chekBox2=driver.findElement(By.xpath("//input[@id='vfb-6-1']"));
        WebElement chekBox3=driver.findElement(By.xpath("//input[@id='vfb-6-2']"));

// checkbox1 ve checkbox3  secili degil ise secin
        if (!chekBox1.isSelected()){
            chekBox1.click();
        }
        if (!chekBox3.isSelected()){
            chekBox3.click();
        }
    // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(chekBox1.isSelected());

        Assert.assertTrue(chekBox3.isSelected());


    // checkbox2 elementinin secili olmadıgını test edin
        Assert.assertFalse(chekBox2.isSelected());

    }
}


