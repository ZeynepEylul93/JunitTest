package techproed.day14_Actions_Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Odev extends TestBase {

//   1- "http://webdriveruniversity.com/Actions" sayfasina gidin
//    2- Hover over  Me First" kutusunun ustune gelin
//    3- Link 1" e tiklayin
//    4- Popup mesajini yazdirin
//    5- Popup'i tamam diyerek kapatin
//    6- “Click and hold" kutusuna basili tutun
//    7-“Click and hold" kutusunda cikan yaziyi yazdirin  8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin

    @Test
    public void test01() {
        //   1- "http://webdriveruniversity.com/Actions" sayfasina gidin
         driver. get("httpS://webdriveruniversity.com/Actions");

        Actions actions=new Actions(driver);
        actions.scrollByAmount(0,1200).perform();
        driver.findElement(By.xpath("//*[@id='BDCC']")).click();
        bekle(16);
       driver.findElement(By.xpath("//*[@id='ValidateCaptchaButton']")).click();


    //    2- Hover over  Me First" kutusunun ustune gelin
        WebElement hoverOvMeFirstKutusu= driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.moveToElement(hoverOvMeFirstKutusu).perform();

    //    3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();

    //    4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());


        //    5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

    //    6- “Click and hold" kutusuna basili tutun
      WebElement clickandholdkutusu=  driver.findElement(By.xpath("//*[@id='click-box']"));
     actions.clickAndHold(clickandholdkutusu).perform();

    //    7-“Click and hold" kutusunda cikan yaziyi yazdirin
        driver.findElement(By.xpath("//*[@id='click-box']"));
        System.out.println(clickandholdkutusu.getText());


        //    8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin
    WebElement dcm=driver.findElement(By.xpath("//div[@id='double-click']"));

    actions.doubleClick(dcm).perform();

    String clicksonrasiAttribute =dcm.getAttribute("class");
        assertEquals("div-double-click double", clicksonrasiAttribute);

    }
}
