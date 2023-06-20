package techproed.day15_fileExist_ErolHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.day10_ErolHoca_Alert.utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTest extends TestBase {
    //https://testcenter.techproeducation.com/index.php?page=file-download
// adresine gidelim.
//b10 all test cases dosyasını indirelim
//Dosyanın başarıyla indirilip indirilmediğini test edelim
    @Test
    public void test01() {
        String filePath="C:\\Users\\ahka1\\Downloads\\b10 all test cases, code.docx";
        try {
            Files.delete(Paths.get(filePath));
        } catch (IOException e) {
            System.out.println("Dosya bulunamadi");
        }
        //Dosyayi daha once indirdigimiz icin ve tekrar testi calistirdigimizda yine ayni dosyayi
        //indirecegi icin dosyayi sildik ki kalabalik yapmasin

        //https://testcenter.techproeducation.com/index.php?page=file-download  adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        bekle(2);

          //b10 all test cases dosyasını indirelim
        driver.findElement(By.xpath("(//*[text()=.])[6]")).click();
        /*
İndirmemizi istediği dosyayı locate edip tıkladık ve dosyamız indirilenler klasörüne indi
 */
bekle(3);//-->indirme suresini goz onunde bulundurarak bekle koyduk
          //Dosyanın başarıyla indirilip indirilmediğini test edelim
    String dosyaYolu="C:\\Users\\ahka1\\Downloads\\b10 all test cases, code.docx";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
