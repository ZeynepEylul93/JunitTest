package techproed.day12_WindowHandles_ErolHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import techproed.day10_ErolHoca_Alert.utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {
    //    Aşağıdaki bilgileri kullanarak authentication yapınız:
//    Url: https://the-internet.herokuapp.com/basic_auth
//    Username: admin
//    Password: admin
//    Başarılı girişi doğrulayın.

    @Test
    public void test01() {
        //    Aşağıdaki bilgileri kullanarak authentication yapınız:
//    Url: https://the-internet.herokuapp.com/basic_auth
//    Username: admin
//    Password: admin
//    Başarılı girişi doğrulayın.
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
      bekle(3);

      // Basarili bir giristen sonra ,Congratulations! yazisinin ciktigini dogrulayin
       WebElement text= driver.findElement(By.xpath("//p"));
        Assert.assertTrue(text.getText().contains("Congratulations!"));

        //Elemental Selenium yazisina tiklayalim
        driver.findElement(By.xpath("(//a)[2]")).click();
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        //Aclan yeni pencereye gectik.

        //Basligin Elemantal Selenium olmadigini dogrulayin
        System.out.println("Sayfa Basligi:"+driver.getTitle());
        Assert.assertNotEquals("Elemantal Selenium",driver.getTitle());


        //ddm 'den Java secelim
     WebElement ddm=driver.findElement(By.xpath("//select"));
       // Select select=new Select(ddm);
      //  select.selectByVisibleText("Java");

        //metodla
        selectVisibleText(ddm,"Java");


    }



}
