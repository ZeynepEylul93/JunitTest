package techproed.day17_exception;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {
    /*
    TimeOutException:

    sayfada aradıgımız elementi wait ile belirttigimiz max. sürede
    bulamadıgı durumda TimeOutException hatası alırız.Wait islemini kontrol etmeliyiz
    Locateine veya suresine dikkat etmeliyiz.

     */
    @Test
    public void TimeOutException() {
        //techproEducation sayfasina gidiniz.
        driver.get("https://techproeducation.com");

        //reklami kapatiniz
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


        //searchBox gorunur oluncaya kadar bekleyin
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
    WebElement searchBox= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Yanlis--elementor-search-form-9f26725']")));



       /*
       TimeOutException alabilmek icin visibilityOfElementLocated methodunu kullanarak yanlıs bir locate aldık.

       webelement'i beklerken o webelementin locate'ını bulamadıgı icin max. belirttigimiz süre kadar bekledi ve
       TimeOutException hatasını verdi.
        */

    }

    @Test
    public void TimeOutExceptiontest2() {
        // https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

     // Start butonuna tıklayınız
        driver.findElement(By.xpath("//button[text()='Start']")).click();

      // Hello World! yazısının görünürlügünü test ediniz
      WebElement helloWorldYazisi=driver.findElement(By.xpath("//h4[text()='Hello World!']"));

      WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1));
      wait.until(ExpectedConditions.visibilityOf(helloWorldYazisi));
        Assert.assertTrue(helloWorldYazisi.isDisplayed());

        /*
        Gercekte hello world yazisi ortalama 6 sn de gorunuyor.
         TimeOutException alabilmek icin Explicit Wait'e max.bekleme suresini 1 sn verdik.
         Bu sebeple  TimeOutException
         */
    }
}
