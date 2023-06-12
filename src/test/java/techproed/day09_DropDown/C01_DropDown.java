package techproed.day09_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;

public class C01_DropDown extends TestBase {
    /*
    DropDown:Altbasliklarin oldugu acilir menu listesidir
    DropDown 3 adimda handle edilir

    1-)DropDown locate edilmelidir

    2-)Select objesi olusturulmalidir
    Select select = new Select(ddm)

    3-)Opsiyonlardan bir tanesi secilir
    -selectByVisibleText()==>option'a gorunur metin ile ulasmak icin kullanilir
    -selectByIndex()==>option'a index ile ulasmak icin kullanilir.(index 0'dan baslar)
    -selectByValue()==>option'a value ile ulasmak icin kullanilir.
     */
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
       // driver.close();
    }

    @Test
    public void test01() {

        // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
      driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        // Yıl Drodown'undan "2020" seciniz
        //Yil dd nini handle ettik
       WebElement ddmYil= driver.findElement(By.xpath("//select[@id='year']"));//dd'nin locatini aldik
        Select select=new Select(ddmYil);//select objesi olusturduk
        //select.selectByVisibleText("2020");//nasil gorunuyorsa oyle yaziyoruz-->en cok bu tercih edilir
         // select.selectByIndex(3);-->indexle aldik 2020 yi
          //  select.selectByValue("2020");//-->value ile aldik 2020 yi
        ddmVisibleText(ddmYil,"2020");

        // Ay Dropdown'undan "August" seciniz
        WebElement ddmAy=driver.findElement(By.xpath("//select[@id='month']"));
        Select select2=new Select(ddmAy);
        select2.selectByVisibleText("August");//gorundugu sekilde opsiyonu sec
       //  select2.selectByIndex(7);
       // select2.selectByValue("7");


        // Gün Dropdown'undan "5" seciniz
        WebElement ddmGun= driver.findElement(By.xpath("//select[@id='day']"));
        Select select3=new Select(ddmGun);
       //select3.selectByVisibleText("5");
       // select3.selectByIndex(4);
        select3.selectByValue("5");

    }




}
