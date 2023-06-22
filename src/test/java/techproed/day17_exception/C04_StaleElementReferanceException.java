package techproed.day17_exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferanceException extends TestBase {
/*
StaleElementReferanceException:

bir web sayfasındaki bir webelementin gecerliliginin kayboldugu durumlarda olusur.

Yani bir webelementi locate ettikten sonra sayfada navigate islemleri-->refresh yada back-forward kullanıyorsak

yeniden o elemente ulasmak istedigimizde StaleElementReferanceException hatasını alırız.

Bunu handle edebilmek icin webelemente yeniden aynı locate'ı atamalıyız.
(webelementin locate'ını hatırlatma gibi diyebiliriz.)


 */

    @Test
    public void StaleElementReferanceExceptionTest1() {

        //techpro sayfasına gidelim


        driver.get("https://techproeducation.com");
        bekle(2);


        //reklami kapatiniz
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


        //sayfayi yenileyelim
        driver.navigate().refresh();

        //LMS Login butonuna tiklayalim
        WebElement login = driver.findElement(By.xpath("(//a[text()='LMS LOGIN'])[1]"));
        login.click();
    }

    @Test
    public void StaleElementReferanceExceptionTest2() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //reklami kapatalim
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


        // LMS LOGIN butonunun locate'ını alalım
        WebElement login = driver.findElement(By.xpath("(//a[text()='LMS LOGIN'])[1]"));
        login.click();

        // sayfayı yenileyelim
        driver.navigate().refresh();

        // LMS LOGIN butonuna tıklayalı
        login.click();


      /*
      LMS LOGIN webelementini locate ettikten sonra sayfayi yeniledigimiz icin LMS LOGIN webelementi eskidi(bayatladi).
      sonrasinda bayatlayan weblemente click yaptigimiz icin StaleElementReferenceException hatasi aldik.

      Bu exception'i handle edebilmek icin refresh yaptiktan sonra tekrar ayni locate'i webelemente atamamiz gerekir.
       */

    }

    @Test
    public void StaleElementReferanceExceptionTest3() {

        // techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");


        // reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();



        // LMS LOGIN butonunun locate'ını alalım
        WebElement login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));




        // sayfayı yenileyelim
        driver.navigate().refresh();


        // LMS LOGIN butonuna tıklayalım
        login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));
        login.click();




    }


}