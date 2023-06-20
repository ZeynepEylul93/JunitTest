package techproed.day15_fileExist_ErolHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.day10_ErolHoca_Alert.utilities.TestBase;

public class C03_FileUploadTest extends TestBase {

    //https://the-internet.herokuapp.com/upload adresine gidelim
//
//chooseFile butonuna basalim
//
//Yuklemek istediginiz dosyayi secelim.
//
//Upload butonuna basalim.
//
//"File Uploaded!" textinin goruntulendigini test edelim.
    @Test
    public void test01() {
//https://the-internet.herokuapp.com/upload adresine gidelim
driver.get("https://the-internet.herokuapp.com/upload ");

 /*
        Eger dosya sec butonuna basmamiz istenirse ve otomasyon ile bu butona click yapmak istedigimizde
        exception aliyorsak,direk upload  upload istedigimiz dosya yolunu alip
        sendKeys() methodu ile dosyayi sayfaya upload yapabiliriz
        Eger upload veya dosya sec butonuna tikladiginizda windows penceresi aciliyorsa,
        o webelemente sendkeys metodu ile dosya gonderemeyebilirsiniz.boyle bir durumla karsilasirsaniz
        Robot classindan obje ile methodlar kullanarak bunu asabilirsiniz.
         */
        String dosyaYolu="C:\\Users\\ahka1\\OneDrive\\Desktop\\text (2).txt";

   //chooseFile(dosya sec) butonuna basalim
        WebElement dosyaSec= driver.findElement(By.id("file-upload"));
      //  dosyaSec.click();-->click yapmadi hata aldik



   //Yuklemek istediginiz dosyayi secelim.
        dosyaSec.sendKeys(dosyaYolu);

    //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
bekle(2);
    //"File Uploaded!" textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

    }
}
