package techproed.day10_ErolHoca_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.day10_ErolHoca_Alert.utilities.TestBase;

public class C02_Alerts extends TestBase {
    /*
    Eger bir sayfadaki bir butona tikladigimizda uyari penceresi cikiyorsa ve bu pencereye sag click
    yapip locate alamiyorsak ,bu bir javascript js alert'tur.
    js Alert'u handle edebilmek icin driver'imizi o pencereye gecirmemiz gerekir.Bunun icin
    driver objemizi kullanarak switchTo methoduyla alert() methodunu kullanarak js alerte gecis yapmis oluruz
      accept() ya da dismiss() methodlariyla js Alert'u onaylar ya da iptal ederek kapatiriz
       accept()-->onaylar
       dismiss()-->iptal eder
     */

    //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
    //Bir metod olusturun: acceptAlert
    //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    //Bir metod olusturun: dismissAlert
    //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //“successfuly” icermedigini test edin.
    //Bir metod olusturun: sendKeysAlert
    //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.


    @Test
    public void acceptAlert() {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        //Bir metod olusturun: acceptAlert
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("(//button)[1]")).click();
        bekle(3);
        driver.switchTo().//gecmek icin kullanilir-->switchTo
                alert().//allert'e gecis yapar
                accept();//cikan alert/te OK yada tamama tiklar
        WebElement resultMessage= driver.findElement(By.xpath("(//p)[2]"));
        String istenenYazi="You successfully clicked an alert";
        Assert.assertEquals(istenenYazi,resultMessage.getText());
    }

    @Test
    public void dismissAlert() {
        //Bir metod olusturun: dismissAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");


        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının  “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("(//button)[2]")).click();
        bekle(3);
        driver.switchTo().
                alert().
                dismiss();//js teki iptal butonuna basar


        WebElement resultMessage = driver.findElement(By.xpath("(//p)[2]"));//You clicked:Cancel
        String istenenMetin = "successfuly";
        Assert.assertFalse(resultMessage.getText().contains(istenenMetin));


    }

    @Test
    public void sendKeysAlert() {
        //Bir metod olusturun: sendKeysAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("(//button)[3]")).click();
        bekle(3);
        driver.switchTo().alert().sendKeys("Zeynep");
        bekle(3);
        driver.switchTo().alert().accept();
        bekle(3);
        WebElement resultMessage=driver.findElement(By.xpath("(//p)[2]"));
        String girilenMetin="Zeynep";
        Assert.assertTrue(resultMessage.getText().contains(girilenMetin));
        bekle(3);


    }
}
