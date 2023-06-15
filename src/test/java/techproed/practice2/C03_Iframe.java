package techproed.practice2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Iframe extends TestBase {
// https://html.com/tags/iframe sayfasına gidiniz
// Videoyu görecek kadar asagiya ininiz
// Videoyu izlemek icin Play tusuna basiniz
// Videoyu calistirdiginizi test ediniz
// 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz


    @Test
    public void test01() {
        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get(" https://html.com/tags/iframe");

  // Videoyu görecek kadar asagiya ininiz
     Actions actions=new Actions(driver);
     actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();//-->perform actionun bittigini gosterir

  // Videoyu izlemek icin Play tusuna basiniz
        //once driver i icteki web sayfasina gecirelim sonra click yapalim
        //Bunun icin iframe/in locateini aldik
        WebElement iframe= driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);
/*
play i dogru locate edip click yapmamiza ragmen videoyu calistirmadi .bunun uzerine
HTML kodlarini inceleyince play in aslinda bir iframe oldugunu gorduk.
bu durumda once iframe'i locate edip
switchTo() ile iframe'e gecmeliyiz
 */
        WebElement playtusu= driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        playtusu.click();


  // Videoyu calistirdiginizi test ediniz

     WebElement youTubeYazisi=driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youTubeYazisi.isDisplayed());


  // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();
       WebElement powerfulYazisi= driver.findElement(By.xpath("//span[@id='Powerful_but_easy_to_misuse']"));
       Assert.assertTrue(powerfulYazisi.isDisplayed());

    }
}
