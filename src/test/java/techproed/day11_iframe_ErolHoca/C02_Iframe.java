package techproed.day11_iframe_ErolHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.day10_ErolHoca_Alert.utilities.TestBase;

public class C02_Iframe extends TestBase {
    //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
   //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
   //Textbox içindeki yazıyı siliniz.
  //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
  //Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
    @Test
    public void iframe() {
        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        String editorYazisi=driver.findElement(By.xpath("//h3")).getText();//Strig e assgn ettigimiz icin gettext kullandik
        Assert.assertTrue(editorYazisi.contains("Editor"));

        //Textbox içindeki yazıyı siliniz.
       driver.switchTo().frame("mce_0_ifr");//-->id ile frame gecis yapyik
      WebElement textBox= driver.findElement(By.xpath("//p"));
      textBox.clear();

        //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");

        //Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
       WebElement elementalSeleniumLinki= driver.findElement(By.xpath("(//a)[3]"));
       Assert.assertTrue(elementalSeleniumLinki.isDisplayed());
    }
}
