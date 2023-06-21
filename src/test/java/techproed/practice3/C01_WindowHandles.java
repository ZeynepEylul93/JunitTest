package techproed.practice3;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandles extends TestBase {

    // 'https://www.n11.com' adresine gidin
// arama motoruna 'Oppo' yazıp aratın
// ilk ürüne tıklayın
// ikinci sayfa Title'ının 'Türkiye' icerdigini test edin.
// ilk sayfaya donun ve Title'ını yazdırın


    @Test
    public void test01() throws InterruptedException {
        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
       String sayfa1Handle= driver.getWindowHandle();
        System.out.println("Sayfa1 hanndle:"+sayfa1Handle);
        Thread.sleep(2000);



     // arama motoruna 'Oppo' yazıp aratın
     driver.findElement(By.xpath("//input[@id='searchData']")).sendKeys("Oppo"+ Keys.ENTER);
     Thread.sleep(2000);
     driver.findElement(By.xpath("(//button[text()='Daha Sonra'])[1]")).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

     // ilk ürüne tıklayın
     WebElement ilkUrun=driver.findElement(By.xpath("(//img[@class='lazy cardImage'])[1]"));
        ilkUrun.click();

        Thread.sleep(2000);

       Set<String> windowHandleSeti=driver.getWindowHandles();

       String sayfa2Handle="";
        for (String each:windowHandleSeti) {
            if (!each.equals(sayfa1Handle)){
                sayfa2Handle=each;

            }
        }
        System.out.println("Sayfa2 Handle:"+sayfa2Handle);
        driver.switchTo().window(sayfa2Handle);
        //  <---driver i yeni acilan sekmeye gecirdik--->


     // ikinci sayfa Title'ının 'Türkiye' icerdigini test edin.
       String ikinciSayfaTitle=driver.getTitle();
        System.out.println("ikinciSayfaTitle:"+ikinciSayfaTitle);
        Assert.assertTrue(ikinciSayfaTitle.contains("Türkiye"));

        Thread.sleep(2000);


    // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(sayfa1Handle);
        System.out.println(driver.getTitle());

        String ilksayfaTitle=driver.getTitle();
        System.out.println("ilk Sayfa Title:"+ilksayfaTitle);

    }
}
