package techproed.day17_Exceptions_ErolHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.day10_ErolHoca_Alert.utilities.TestBase;

import java.util.List;

public class C04_StaleElementReferenceException extends TestBase {

    /*
    StaleElementReferenceException
       Bir webelementin sayfayi refresh(yenileme) ya da back_forward yapma sonucunda eskimesi (bayatlamasi)
       durumunda bu exception u aliriz.Yani driver sayfayi yeniden olusturdugunda elementin locate i ayni
       olmasina ragmen tekrar o elementinlocatini almamizi ister.Almadigimiz tekdirde locate'i
       eskimis olarak gorur ve StaleElementReferenceException hatasi verir.
     */

    @Test
    public void test01() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));

        driver.navigate().refresh();
        /*
org.openqa.selenium.StaleElementReferenceException hatası aldık çünkü refresh yaptıktan sonra
tekrar locate almadık. Dolayısıyla bu hatayı handle edebilmek için refresh yaptıktan sonra
tekrar locate almalıyız.
 */

        aramaKutusu.sendKeys("qa", Keys.ENTER);//-->arama kutusu eskidigi icin sendKeys()metodunu kullanamadi

        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));
    }

    @Test
    public void test02() {//test02 -->Bu test methodunda test01 methodunun nasil handle edilecegini yaptik

        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        //reklami kapatalim
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //arama kutusunda qa aratalim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        driver.navigate().refresh();

        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("qa", Keys.ENTER);

        //sayfa basliginin qa icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));
    }

    @Test
    public void test03() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        aramaKutusu.sendKeys("developer",Keys.ENTER);

        driver.navigate().back();
        driver.navigate().forward();
        /*
        org.openqa.selenium.StaleElementReferenceException: back-forward sonrasında da bu hatayı aldık
         */

        aramaKutusu.sendKeys("qa", Keys.ENTER);

        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));
    }

    @Test
    public void test04() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //arama kutusunda iphone aratalım
       WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
       aramaKutusu.sendKeys("iphone"+Keys.ENTER);

        //çıkan sonuclardan ilk beşine tıklayıp,her ürünün başlığını konsola yazdıralım
        List<WebElement> urunler= driver.findElements(By.xpath("//h2//a"));

        for (int i = 0; i < urunler.size(); i++) {
            urunler.get(i).click();
            bekle(2);
            System.out.println(driver.getTitle());
            driver.navigate().back();//staleelementreferenceexception
            bekle(2);
            if (i==4){
                break;
            }
            urunler= driver.findElements(By.xpath("//h2//a"));//-->StaleElementReferenceException'i handle ettik
        }

    }
}








