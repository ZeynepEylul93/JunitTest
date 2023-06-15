package techproed.day12_windowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {

    /*
     -Authentication kimlik dogrulama yontemidir
      -soz konusu sisteme dahil olup olunamayacagini belirleyen formu ifade eder.
      -Authentication uzerinde sag click yapip locate alinamaz
      -Authentication bir alert degildir
      -Authentication yapabilmek icin uygulamanin kullanicilara,
      Authentication'i nasil yapacagina dair bilgilendirme yapmis olmasi gerekir
        -https:/username:password@URL gibi
     */
    // Aşağıdaki bilgileri kullanarak authentication yapınız:

// Url: https://the-internet.herokuapp.com/basic_auth
// Username: admin
// Password: admin

//Paragrafın "Congratulations" kelimesini içerdiğini doğrulayınız

    @Test
    public void basicAuthentication() {
  // Aşağıdaki bilgileri kullanarak authentication yapınız:

  // Url: https://the-internet.herokuapp.com/basic_auth

   // Username: admin
  // Password: admin
        /*
        -https:/username:password@URL
        Yukarida bbelirtilen formata uygun kimlik dogrulamasi yapin
         */

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");



  // Paragrafın "Congratulations" kelimesini içerdiğini doğrulayınız
       WebElement paragraf= driver.findElement(By.xpath("//p"));
        Assert.assertTrue(paragraf.getText().contains("Congratulations"));
    }
}
