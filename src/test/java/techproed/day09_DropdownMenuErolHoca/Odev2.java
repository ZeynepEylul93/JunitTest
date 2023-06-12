package techproed.day09_DropdownMenuErolHoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Odev2 {
//    ●https://www.amazon.com/ adresine gidin.
//            -Test 1
    //   Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45  oldugunu test edin



    //-Test 2
    //           1.Kategori menusunden Books secenegini secin
//2.Arama kutusuna Java yazin ve aratin
//3.Bulunan sonuc sayisini yazdirin
//4.Sonucun Java kelimesini icerdigini test edin
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //    ●https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
    }

    @After
    public void tearDown() throws Exception {
       // driver.close();
    }

    @Test
    public void test01() {
        //   Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45  oldugunu test edin
    WebElement ddm= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
       List<WebElement> kategori= select.getOptions();
        System.out.println(kategori.size());
        Assert.assertTrue(kategori.size()==28);
    }

   @Test
    public void test02() {
       //-Test 2
       //1.Kategori menusunden Books secenegini secin
       WebElement ddm= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
       Select select=new Select(ddm);
       select.selectByVisibleText("Books");

   //2.Arama kutusuna Java yazin ve aratin
       driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);


   //3.Bulunan sonuc sayisini yazdirin
      WebElement sonucYazisi= driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
     String []sonucSayisiArr= sonucYazisi.getText().split(" ");
       System.out.println("Sonuc Sayisi :"+sonucSayisiArr[3]);
       System.out.println(sonucYazisi.getText());

   //4.Sonucun Java kelimesini icerdigini test edin
       Assert.assertTrue(sonucYazisi.getText().contains("Java"));


   }

}
