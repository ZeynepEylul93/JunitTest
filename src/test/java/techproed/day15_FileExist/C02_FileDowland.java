package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDowland  extends TestBase {
    //"https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
   //"b10 all test cases" dosyasını indirin
    // Dosyanın başarıyla indirilip indirilmediğini test edin.


    @Test
    public void test01() {
        //"https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        bekle(2);

        //\Users\ahka1\Downloads\b10 all test cases, code.docx-->indirdigimiz dosya
        File silinecekDosya=new File("\\Users\\ahka1\\Downloads\\b10 all test cases, code.docx");
        silinecekDosya.delete();

        /*
         File silinecekDosya=new File("\\Users\\ahka1\\Downloads\\b10 all test cases, code.docx");
        silinecekDosya.delete();

        Eger localimizden otomasyon ile bir dosya silmek icin File clasindan obje olusturup.dosya yolumuzu
        icine yerlestiririz.Ve olusturdugumuz obje ile delete() methodunu kullanarak o dosyayi silebiliriz

        Bunu yapma sebebimiz test clasimizi calistirdigimizda,her calistirmada yeni bir dosya indirecegi icin
        oradaki dosya kalabaligini onlemis oluyoruz.Ayni zamanda dogrulama yaperken isimizi garantiye almis oluruz

        Ayni isimde birden fazla dosya indirmis olsakta her indirilenin yanina index verecegi icin ve bizim ilk indirdigimiz
        o klasorun icinde bulamayacagi icin her zaman ilk dosyanin varligini test etmis oluruz
         */


  //"b10 all test cases" dosyasını indirin
  WebElement indirilecekDosya= driver.findElement(By.xpath("//a[text()='b10 all test cases, code.docx']"));
  indirilecekDosya.click();
  bekle(5);

    // Dosyanın başarıyla indirilip indirilmediğini test edin.

        /*
        Dosyanin bilgisayarimda dowlands'a basariyla indirilip indirilmedigini java ile test edecegim.
        Cunku selenium web sayfalarini test eder.
        selenium,benim bilgisayarimdaki dowlwnds'a mudahale edemez
         */

        // \Users\ahka1\Downloads\b10 all test cases, code.docx
      //  Assert.assertTrue(Files.exists(Paths.get("\\Users\\ahka1\\Downloads\\b10 all test cases, code.docx")));

        //daha dinamik yapmak icin
       String farkliKisim= System.getProperty("user.home");//-->benim bilgisayarimda olani yani farkli olani verir-->\Users\ahka1
       String ortakKisim="\\Downloads\\b10 all test cases, code.docx";
       String dosyaYolu=farkliKisim+ortakKisim;
       Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
