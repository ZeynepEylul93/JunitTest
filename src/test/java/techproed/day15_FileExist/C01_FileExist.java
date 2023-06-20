package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist {
    //Selenyum ile sadece web sayfalarinin otomasyonunu yapabiliriz
    //Selenyum ile windows uygulamalarini test edemeyiz
    //localimizdeki dosyalarada mudahale edemez.Benim bilgisayarimi otomate edemez.
    //windows uygulamalarini test etmek icin java kullaniriz
    //localimdeki bir dosyanin olup olmadigini(exist) java ile kontrol ederiz


    @Test
    public void fileExist() {
        System.out.println(System.getProperty("user.dir"));//icinde oldugum projenin dosya yolunu(path) verir.

        System.out.println(System.getProperty("user.home"));//herkesin blgisayarinda farkli olan kismi verir


       // SORU:
        // Desktop(masaustu)'da bir text dosyası olusturun

        // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin
        /*
        Dosyanin,bilgisayarimda desktop'ta olup olmadigini java ile test edecegim
        Cunku selenium,web sayfalarini test eder.
         */

        //C:\Users\ahka1\OneDrive\Desktop
        Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\ahka1\\OneDrive\\Desktop\\text.txt")));

        //daha dinamik hale getirelim
      //  C:\Users\ahka1-->herkesste farkli                //\OneDrive\Desktop\text.txt-->herkeste ayni
       String farkliKisim= System.getProperty("user.home");
       String ortakKisim="\\OneDrive\\Desktop\\text.txt";
       String dosyaYolu=farkliKisim+ortakKisim;

       Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
