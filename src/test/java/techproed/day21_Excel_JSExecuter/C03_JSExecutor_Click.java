package techproed.day21_Excel_JSExecuter;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecutor_Click extends TestBase {
   /*
        Bir web sayfasinda bazi webelementler olusturulurken JAVASCRIPT kodlariyla olusturulmus olabilir.
    Bu webelementleri handle edebilmek icin JavaScriptExecutor arayuzunu kullanmamiz gerekir.
    Bir webelement JavaScript kodlari ile yazilmamis olsa da javaScriptExecutor ile o webelementi handle edebiliriz
    Normal bildigimiz methodlardan daha yavas calisacagi icin bildigimiz methodlar isimizi goruyorsa onlari kullaniriz
    <script> tagi ile olusturulmus olan webelementleri de js executer ile handle edebiliriz.
     */

    @Test
    public void Test1() {
        //https://amazon.com sayfasina gidiniz.
        driver.get("https://amazon.com ");
        bekle(2);

        //sell linkinin resmini alalim
        WebElement sellLinki= driver.findElement(By.xpath("//*[text()='Sell']"));
        webElementResmi(sellLinki);

        //Sell linkine js kullanarak tiklayiniz
      // WebElement sellLinki= driver.findElement(By.xpath("//*[text()='Sell']"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",sellLinki);//parantez icindeki 0.index->selllinkinin indexi.olurda baska bir tane almak istersek onun indexini yazariz
       //virgulden sonraki webelementin indexini yazdik yani.

        //Basligin Sell icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanin resmini alalim
        tumSayfaResmi();

    }
    @Test
    public void test02() {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        bekle(2);
        //sell linkinin resmini alalım
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        webElementResmi(sellLinki);

        //Sell linkine tıklayınız
        sellLinki.click();
        /*
        /*
JS executor ile Webelementin önünde uyarı çıkmasına rağmen webelemente click yaptı çünkü kodlara direk ulaşıyor
Normal kullandığımız click methodu burda önünde farklı bir element olduğu için ElementClickInterceptedException:
hatası verdi.Dolayısıyla bu exception ile karşılaştığımızda da js executor ile bunu çözebiliriz
         */

        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanın resmini alalım
        tumSayfaResmi();
    }

    @Test
    public void test03() {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        bekle(2);
        //sell linkinin resmini alalım
        driver.findElement(By.xpath("(//*[@class='a-button-inner'])[1]")).click();//-->uyarı kapatıldı

        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        bekle(2);
        webElementResmi(sellLinki);

        //Sell linkine js executor kullanarak tıklayınız
        click(sellLinki);


        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanın resmini alalım
        tumSayfaResmi();


    }





}
