package techproed.day15_fileExist_ErolHoca;

import org.junit.Assert;
import org.junit.Test;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist {
/*
    Bir web sitesini test ettiğimizde download işlemi yapıldığı zaman dosyanın bilgisayarımıza inip inmediğini
kontrol etmek varlığını doğrulamak için yada bilgisayarımızdaki herhangi bir dosyanın varlığını doğrulabilmek
için;
    Files class'ından exists() methodunu kullanarak parametre olarak Paths.get(dosyaYolu) methodunu kullanarak
dosyanın varlığını test edebiliriz. --> Files.exists(Paths.get(dosyaYolu)
Dolayısıyla bu işleme başlamadan önce varlığını test edeceğimiz dosyanın yolunu String bir değişkene
assing ederiz.

  Windows eski surumde yol olarak kopyala cikmiyorsa--->>shift+sag click yap o zaman yol olarak kopyala cikar
 */

    @Test
    public void test01() {
        String dosyaYolu="C:/Users/ahka1/OneDrive/Desktop/text.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));//-->dosya varsa true yoksa false doner.
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void test02() {
        String dosyaYolu="C:\\Users\\ahka1\\OneDrive\\Desktop\\deneme.txt";//basindaki ve sonundaki gereksiz slaslari sildik
        //--> "C" den once ve en sondaki çift tırnaktan önce /" olmayacak
        System.out.println(Files.exists(Paths.get(dosyaYolu)));//-->dosya varsa true yoksa false doner.
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }

    @Test
    public void test03() throws IOException {
        /*
        Bir server da farkli isletim sistemleri ile ayni anda dosya varligini test etmek istedigimiz zaman,
        daha dinamik olmasi acisindan  System.getProperty("os.name")-->bu sekilde isletim sistemi alir
        Her isletim sisteminin kullanici yolu farkli olacagindan  System.getProperty("user.home")
        bilgisayarimizdaki kullanici yolunu bu sekilde String bir degiskene farkli yol ismi ile System.getProperty("user.home")
         atayarak
   her seferinde farkli yollari almayla ugrasmamiz oluruz. Dosya diyelim ki masa ustunde ve her isletim sisteminde
   bize ayni yolu verecegi icin bunu da ortak yol olarak bir String'e assing ederiz
         */
        //-->"C:/Users/ahka1-->kendi yolum/farkliYol         ****--> /OneDrive/Desktop/text.txt";-->ortak yol-->slastan itibaren

        String farkliYol="";
        String isletimSistemiAdi=System.getProperty("os.name");//-->Isletim sistemimizin adini verir
        System.out.println(isletimSistemiAdi);
        System.out.println(System.getProperty("user.home"));//-->Bilgisayarimizdaki kullanici yolunu verir
        if (isletimSistemiAdi.contains("Win")){
            farkliYol=System.getProperty("user.home");//-->Windows 10/-->C:\Users\ahka1
        }else  if (isletimSistemiAdi.contains("mac")){
            farkliYol="/Users/aycapolatkamali";//-->mac isletim sistemi yolu
        }
        String ortakYol="/OneDrive/Desktop/text.txt";
        String dosyaYolu=farkliYol+ortakYol;
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        try {
            Files.delete(Paths.get(dosyaYolu));//-->Bu sekilde belirtmis oldugumuz dosyayi sileriz
        } catch (IOException e) {
            System.out.println("Dosya bulunamadi");

        }
        Assert.assertFalse(Files.exists(Paths.get(dosyaYolu)));//-->sildigimiz icin assert false kullandik

        //Sildigimiz dosya isminde yeni bir dosya olusturalim
        try {
            Files.createFile(Paths.get(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
     /*
        Her seferinde test ettiğimiz sayfada download işlemi yapılıyorsa gereksiz dosya kalabalığını önlemek için
    yukardaki delete işlemini kullanabiliriz
     */

    @Test
    public void test04() {
        //"C:\Users\ahka1\OneDrive\Desktop\text.txt"
        /*
    Yukaridaki methodlarda bilgisayarimizdaki dosya yolunun varligini Files.exists() methodu ile test etmistik.
    Ayni islemi asagidaki ornekteki gibi File class'indan obje olusturarak da yapabiliriz
 */
        String dosyaYolu="C:\\Users\\ahka1\\OneDrive\\Desktop\\text.txt";
        File file= new File(dosyaYolu);
        System.out.println(file.exists());
        Assert.assertTrue(file.exists());
        file.delete();
    }
}
