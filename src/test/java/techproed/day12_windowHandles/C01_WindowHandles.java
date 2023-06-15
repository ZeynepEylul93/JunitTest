package techproed.day12_windowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandles extends TestBase {
    //  https://the-internet.herokuapp.com/windows adresine gidin.
//  ilk sayfasının Handle degerini alın yazdırın
//  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
//  ilk sayfa Title'ının "The Internet" olduğunu test edin.
//  "Click Here" butonuna tıklayın.
//  ikinci sayfa Title'ının "New Window" olduğunu test edin.
//  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
//  ikinci sayfaya tekrar geçin.
//  ilk sayfaya tekrar dönün.


    @Test
    public void windowHandles() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

//  ilk sayfasının Handle degerini alın yazdırın
     String sayfa1Handle= driver.getWindowHandle();
        System.out.println("Sayfa1 Handle:"+sayfa1Handle);

//  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
      WebElement sayfatexti=driver.findElement(By.xpath("//h3[text()='Opening a new window']"));
        Assert.assertEquals("Opening a new window",sayfatexti.getText());

//  ilk sayfa Title'ının "The Internet" olduğunu test edin.
     String ilkSayfaTitle=driver.getTitle();
     Assert.assertEquals("The Internet",ilkSayfaTitle);


//  "Click Here" butonuna tıklayın.
      WebElement clickHere=driver.findElement(By.xpath("//a[text()='Click Here']"));
      clickHere.click();

        /*
        eger bir butona tıkladıgımızda bizim kontrolumuz dısında 2. sayfa acılıyorsa,
        otomatik acılan 2.sayfa'ya driver'ı gecirmemiz gerekir.
        2.sayfa'ya driver'ı gecirebilmemiz icin 2. sayfa'nın handle degerini bulmalıyız
        getwindowHandles(); methodu sayesinde 2. sayfanın handle degerini tespit edebiliriz.
        daha sonra driver.switchTo().window(sayfa2Handle); diyerek 2. sayfa'ya driver'ı gecirebiliriz
         */



     Set<String> windowHandleSeti= driver.getWindowHandles();//-->getWindowHandles butun sekmelerin handle degerini getirir.Set dondurur.
     //   System.out.println(windowHandleSeti);

        String sayfa2Handle="";
        for (String each:windowHandleSeti) {
            if (!each.equals(sayfa1Handle)){
                sayfa2Handle=each;
            }
        }
        driver.switchTo().window(sayfa2Handle);


//  ikinci sayfa Title'ının "New Window" olduğunu test edin.
       String ikinciSayfaTitle= driver.getTitle();
      Assert.assertEquals("New Window",ikinciSayfaTitle);


//  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(sayfa1Handle);
        Assert.assertEquals("The Internet",driver.getTitle());
        bekle(2);

//  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(sayfa2Handle);

        bekle(2);
        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(sayfa1Handle);
    }
}
