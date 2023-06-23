package techproed.day10_TestBase;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;
import org.junit.Assert;

public class C03_AlertMethods extends TestBase {
     /*
    https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.


    Bir metod olusturun: acceptAlert
    1. butona tıklayın,
    uyarıdaki OK butonuna tıklayın
    ve result mesajının "You successfully clicked an alert" oldugunu test edin.



    Bir metod olusturun: dismissAlert
    2. butona tıklayın,
    uyarıdaki Cancel butonuna tıklayın
    ve result mesajının "successfuly" icermedigini test edin.



    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın,
    uyarıdaki mesajı konsolda yazdırın,
    uyarıdaki metin kutusuna isminizi yazin,
    OK butonuna tıklayın
    ve result mesajında isminizin görüntülendiğini doğrulayın.

     */


    @Test
    public void acceptAlert() throws InterruptedException {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //    Bir metod olusturun: acceptAlert
        //    1. butona tıklayın,
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        bekle(3);



        //    uyarıdaki OK butonuna tıklayın
        alertAccept();
        /*
        driver.switchTo(). // Gecmek,Degistirmek
                alert().   // Alert'e gecis yaptı
                accept();  // cıkan uyarıda OK yada TAMAM butonuna basar
*/

        bekle(3);


        //    ve result mesajının "You successfully clicked an alert" oldugunu test edin.

        String actuelResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult = "You successfully clicked an alert";

        Assert.assertEquals(expectedResult,actuelResult);



    }

    private void alertAccept() {
    }


    @Test
    public void dismissAlert() throws InterruptedException {


        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        Thread.sleep(2000);

        //   Bir metod olusturun: dismissAlert
        //    2. butona tıklayın,
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

       bekle(3);



        //    uyarıdaki Cancel butonuna tıklayın

        //driver.switchTo().alert().dismiss();
       // alertDismiss();

       bekle(3);


        //    ve result mesajının "successfuly" icermedigini test edin.
        String actuelResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult = "successfuly";

        Assert.assertFalse(actuelResult.contains(expectedResult));
    }

    @Test
    public void sendKeysAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //      Bir metod olusturun: sendKeysAlert
        //      3. butona tıklayın,

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        //    uyarıdaki mesajı konsolda yazdırın,
       // alertText();
       // System.out.println(driver.switchTo().alert().getText());
        //gettext uyaridaki mesaji bize string olarak getirir

        //   uyarıdaki metin kutusuna isminizi yazin,
       // alertPrompt("Zeynep");
        //driver.switchTo().alert().sendKeys("Zeynep");

        //           OK butonuna tıklayın
       // driver.switchTo().alert().accept();
        alertAccept();


        // ve result mesajında isminizin görüntülendiğini doğrulayın.
        String actualResult= driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertTrue(actualResult.contains("Zeynep"));
    }
}




