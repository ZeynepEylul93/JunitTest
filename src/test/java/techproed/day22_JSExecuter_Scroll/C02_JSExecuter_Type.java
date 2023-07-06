package techproed.day22_JSExecuter_Scroll;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSExecuter_Type extends TestBase {
// https://techproeducation.com sayfasına gidin
// Arama kutusuna "QA" yazıp aratın


    @Test
    public void typeTest() {
        // https://techproeducation.com sayfasına gidin
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklami kapattik

       // Arama kutusuna "QA" yazıp aratın


          // 1.yol:
      WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='elementor-search-form-9f26725']"));

        //JavascriptExecutor js= (JavascriptExecutor) driver;
       // js.executeScript("arguments[0].value='QA'",aramaKutusu);

        sendKeysJS(aramaKutusu,"QA");


/*
       // 2.yol
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='elementor-search-form-9f26725']"));

       // JavascriptExecutor js= (JavascriptExecutor) driver;
       // js.executeScript("arguments[0].setAttribute('value','QA')",aramaKutusu);
        //html kodlarindaki value degerine kalici olarak QA yazdirdi

        sendKeysJS(aramaKutusu,"QA");
        aramaKutusu.submit();




 */



    }
}
