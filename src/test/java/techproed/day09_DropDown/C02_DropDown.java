package techproed.day09_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDown {
    /*

     -getFirstSelectedOption()==> DropDown'daki en son sectigimiz option'u bize dondurur.

     -getOptions()==>DropDown'daki tum opsiyonlari bize dondurur.

     */


// https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz

    // Select a State Dropdown'undan "Arizona" seciniz

    // Select a State Dropdown'undan son secilen option'un "Arizona" oldugunu test ediniz

    // Select a State Dropdown'undaki tum optionları konsolda yazdırınız

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
       // driver.close();
    }

    @Test
    public void test01() {

      // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
   driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        // Select a State Dropdown'undan "Arizona" seciniz
     WebElement ddmSelectaState= driver.findElement(By.xpath("//select[@id='state']"));
        Select select=new Select(ddmSelectaState);
        select.selectByVisibleText("Arizona");
     //  select.selectByIndex(3);
      //  select.selectByValue("AZ");

        // Select a State Dropdown'undan son secilen option'un "Arizona" oldugunu test ediniz
      WebElement sonSecilenOption=  select.getFirstSelectedOption();// getFirstSelectedOption()-->son secilen opsiyonu bize verir
        // .Ama webelement olarak getirir.bunu stringe cevirmemiz lazim

       String  sonSecilenOptionStr=  sonSecilenOption.getText();//son secilen opsiyonu gettext ile stringe donusturduk

        Assert.assertEquals("Arizona",sonSecilenOptionStr);



        // Select a State Dropdown'undaki tum optionları konsolda yazdırınız
      /*
       List<WebElement>tumOpsiyonlar= select.getOptions();//Getoptions bize ilgili dropdowndaki weblelemtlerden olusan bir list donduruyor

        for (WebElement each:tumOpsiyonlar) {
            System.out.println(each.getText());
        }


        tumOpsiyonlar.stream().forEach(t-> System.out.println(t.getText()));-->lambda

    */

       // 2.yol
      List<WebElement> tumOpsiyonlar =  driver.findElements(By.xpath("//select[@id='state']//option"));
      tumOpsiyonlar.stream().forEach(t-> System.out.println(t.getText()));
}



    }