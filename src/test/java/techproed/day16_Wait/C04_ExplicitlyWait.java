package techproed.day16_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_ExplicitlyWait extends TestBase {
//==>  https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
//==>  Remove tuşuna basın
//==>  "It's gone!" yazısının görünür oldugunu test edin.


    @Test
    public void test01() {
        //==>  https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

       //==>  Remove tuşuna basın
        WebElement remove= driver.findElement(By.xpath("//button[text()='Remove']"));
        remove.click();

      //==>  "It's gone!" yazısının görünür oldugunu test edin.
  WebElement itsGoneYazisi= driver.findElement(By.xpath("//*[@id='message']"));
  //text ile de alabiliriz-->//p[text()="It's gone!"]-->it's yazisinda da tek tirnak var o yuzden cift tirnak icine yazdik

        Assert.assertTrue(itsGoneYazisi.isDisplayed());
    }
}
