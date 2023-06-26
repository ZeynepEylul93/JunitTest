package techproed.ODEVLER;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C08 extends TestBase {

//    -https://jqueryui.com/slider/#colorpicker adrese gidiniz
 //           -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
///-Sarı olduğunu test edelim


    @Test
    public void test01() {

      //    -https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");

      //   -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        WebElement iframe= driver.findElement(By.xpath("//iframe[@src='/resources/demos/slider/colorpicker.html']"));
driver.switchTo().frame(iframe);

     WebElement kirmiziButon= driver.findElement(By.xpath("(//span[@tabindex='0'])[1]"));
     WebElement yesilButon= driver.findElement(By.xpath("(//span[@tabindex='0'])[2]"));
     WebElement maviButon= driver.findElement(By.xpath("(//span[@tabindex='0'])[3]"));

        System.out.println(yesilButon.getLocation());
        Actions actions=new Actions(driver);

       actions.clickAndHold(yesilButon).moveByOffset(-160,0).release().click().perform();

       actions.clickAndHold(maviButon).moveByOffset(-65,0).release().perform();
       actions.clickAndHold(yesilButon).moveByOffset(300,0).release().perform();
       /*
       moveByOffset elementi bulundugu konumdan baska bir konuma goturur
       - yazarsak sola,+yazarsak saga kaydirir
        */


        //-Sarı olduğunu test edelim
      WebElement sariKutu=  driver.findElement(By.xpath("//div[@id='swatch']"));
      String expectedSari="background-color: rgb(255, 255, 5);";
      String actualSari=sariKutu.getAttribute("style");
        Assert.assertEquals(expectedSari,actualSari);



    }
}

