package techproed.day18_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C05_ScreenShotClassWork extends TestBase {

    //Techproeducation sayfasına gidelim
    //sayfanın resmini alalım
    //Arama bölümünde java aratalım
    //ve sonuc yazısının resmini alalım
   //Yeni bir sekmede amazona gidelim
    //sayfanın resmini alalım
   //arama bölümde iphone aratalım
   //ve sonuc yazısının resmini alalım
    //tekrar tecpro sayfasına geçelim ve sayfa resmini alalım


    @Test
    public void name() {

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//-->Reklamı kapatır

        bekle(2);

        //sayfanın resmini alalım
        tumSayfaResmi();

        //Arama bölümünde java aratalım
        driver.findElement(By.id("elementor-search-form-9f26725")).sendKeys("java", Keys.ENTER);

        //ve sonuc yazısının resmini alalım
        WebElement sonucYazisi= driver.findElement(By.xpath("//h1"));
        webElementResmi(sonucYazisi);//-->Method ile webelementin resmini aldik

        //Yeni bir sekmede amazona gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");

        //sayfanın resmini alalım
        tumSayfaResmi();//-->Method ile sayfanin resmini aldik

        //arama bölümde iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //ve sonuc yazısının resmini alalım
        WebElement amazonSonucYazisi= driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));

        //tekrar tecpro sayfasına geçelim ve sayfa resmini alalım

        switchWindow(0);
        tumSayfaResmi();
    }
}
