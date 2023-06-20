package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {
    //techpro sayfasina gidelim
//sayfanin altina dogru gidelim
//sayfanin ustune dogru gidelim
    @Test
    public void test01() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
   bekle(2);
   //sayfanin altina dogru gidelim
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
bekle(2);

   //sayfanin ustune dogru gidelim
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();

    }
    //sendKeys(Keys.END) sayfanin en altina götürür
//sendKeys(Keys.HOME); sayfanin en üstüne tasir
    @Test
    public void test02() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        bekle(2);
        //sayfanin en altina scroll yapalim
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();//end den sonra perform kullanmadik.Cunku asagida build le bagladik.bir perform yetti.



        //sayfanin en ustune scroll yapalim
          actions.sendKeys(Keys.HOME).perform();
        //build()--> metodu actionlari birlestirmek icin kullanilir.Birden fazla olusturdugumuz action objesini birbirine baglar
        //release()-->metodu mause'u serbest birakir
        /*
her actions dan sonra perform kullanmazsak olay cok seri gerceklesir.
build kullandigimizda olay milisaniye icinde gerceklesir.
araya bekle methodu koysak bile java build methodunun oldugu kisimda sayfayi asagi yaparak hizli sekilde gerceklestirir

release() methodu kutuyu bir yerrden sürükleme veya eslestirme gibi konulari yaparken
mouseyi cekip birakmali sorularda release() methodu kullanilir
actionsta mouseta sürükleme islemi yapiyorsak serbest birakma islemi icin release() methodu kullanilir.
 *///build = kur , inşa et, oluştur.
        //build() -->methodu action'lari birlestirmek icin kullanilan methoddur.Birden fazla olusturdugumuz action
        //objesini birbirine baglar
        //release() methodu mouse'u birakir
    }
    @Test
    public void test03() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);
        //sayfanın altına doğru gidelim
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,1500).perform();//+ deger asagi indirir.x y kooordinatinda calisir

        //sayfanın üstüne doğru gidelim
      actions.scrollByAmount(0,-1500).perform();//- deger yukari cikarir
    }



}
