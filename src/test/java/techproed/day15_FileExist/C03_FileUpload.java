package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_FileUpload extends TestBase {
    // masaustunde bir deneme dosyası olusturun
    // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
    // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
   // 'Upload' butonuna basın
    // 'File Uploaded!' yazısının goruntulendigini test edin


    @Test
    public void test01() {
        // masaustunde bir deneme dosyası olusturun

        // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/upload");

        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
      WebElement dosyaSec= driver.findElement(By.id("file-upload"));



     //C:\Users\ahka1\OneDrive\Desktop\deneme.txt
        System.out.println(System.getProperty("user.home"));//C:\Users\ahka1
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\OneDrive\\Desktop\\deneme.txt";

        String dosyaYolu=farkliKisim+ortakKisim;

        dosyaSec.sendKeys(dosyaYolu);

        //Deneme dosyasinin yolunu aldik.Asagida dinamik hale getirdik.sendkeys ile dosya yolumu
        //dosya sec kismina yukledik

        // 'Upload' butonuna basın

        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        bekle(3);

        // 'File Uploaded!' yazısının goruntulendigini test edin
       WebElement fileUploaded= driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        Assert.assertTrue(fileUploaded.isDisplayed());
    }
}
