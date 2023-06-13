package techproed.day11_iframe_ErolHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.day10_ErolHoca_Alert.utilities.TestBase;

public class C01_Iframe extends TestBase {
    //➢ https://testcenter.techproeducation.com/index.php?page=iframe
//➢    Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin   oldugunu test edelim
//➢    Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
//➢    Son olarak footer daki 'Povered By' yazisini varligini test edilip

    /*
    Bir HTML dokumaninin icine yerlestirilmis baska bir HTML dokumanina inline frame yani
    IFRAME denir.
    Bir sayfada iframe varsa iframe icindeki webelementi handle edebilmek icin switchTo()
    metoduyla iframe ye gecis yapmamiz gerekir.Eger grcis yapmazsak no-suche-element exception aliriz.
             Aler'ten farki:Alert ciktiginda hicbir webelementi locate edemeyiz.
             Iframe olsa da locate ederiz,fakat handle edemeyiz.

     */

    @Test
    public void iframe() {
        //➢ //➢ https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

//➢    Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin   oldugunu test edelim
        String metin=driver.findElement(By.xpath("(//p)[1]")).getText();
        System.out.println(metin);
        Assert.assertTrue(metin.contains("black border"));

//➢    Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);//-->iframe e indexle gecis yaptik.gecis yapmazsak nosuchelementexception aliriz.
        String ApplicationslistsYazisi=driver.findElement(By.xpath("//h1")).getText();
        System.out.println(ApplicationslistsYazisi);
        Assert.assertEquals("Applications lists",ApplicationslistsYazisi);
//not:footer-->alt bilgi

//➢    Son olarak  sayfa basliginda iframe yazisinin gorunur oldugunu test edin
        driver.navigate().refresh();//-->anasayfaya boylede gidebiliriz
      //  driver.switchTo().defaultContent();-->bu da anasyfaya gider
       // driver.get(driver.getCurrentUrl());//-->bu cod da sayfayi refresh yapar ve anasayfaya doneriz
        WebElement iframeYazisi= driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());

        /*
         Eğer iki tane iframe olsaydı ve 2. frame'e geçmek isteseydik index'i 1 almam gerekicekti
        <body>
	            <iframe id="outerIframe" src="https://www.w3schools.com"> --> driver.switchTo().frame("outerIframe")
		            <iframe id="innerIframe" src="https://www.google.com"></iframe> --> bu örnekte parentFrame ile bir üst frame geçiş yapabiliriz
	            </iframe>
            </body>

          İstersek WebElement frame = driver.findElement(By.xpath("//*[@id='outerIframe'")) bu şekilde locate ettiğimiz
        iframe'e driver.switchTo().frame(frame) geçiş yapabiliriz.

         */
    }
}