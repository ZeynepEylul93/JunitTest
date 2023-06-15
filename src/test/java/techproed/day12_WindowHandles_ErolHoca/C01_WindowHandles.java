package techproed.day12_WindowHandles_ErolHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.day10_ErolHoca_Alert.utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
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
    public void test01() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandle = driver.getWindowHandle();
        System.out.println("Ilk Sayfa Handle Degeri:" + ilkSayfaHandle);

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedTest = "Opening a new window";
        Assert.assertEquals(expectedTest, actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//-->Yeni bir sekme acildi
        /*
    Bir button'a click yaptigimizda kontrolumuz disinda yeni bir sekme ya da pencere acilirsa , yeni acilan pencerenin
    handle degerini bilmedigim icin normal getWindowHandle ile driver'imi yeni pencereye geciremem. Bunu getWindowHandles()
    methoduyla acilan tum pencereleri bir Set'e assign edip , ilk actigimiz pencere degilse ikinci acilan yeni penceredir
    mantigiyla bir loop icinde cozebiliriz
 */
        Set<String> pencereler = driver.getWindowHandles();//Set benzersiz sekilde alir
        for (String w : pencereler) {
            System.out.println(w);
            if (!w.equals(ilkSayfaHandle)) {
                driver.switchTo().window(w);
            }
        }

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow, actualTitleNewWindow);
        String ikinciSayfaHandle = driver.getWindowHandle();
        System.out.println("ikinci Sayfa Handle Degeri:" + ikinciSayfaHandle);
        bekle(2);
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(ilkSayfaHandle);
        String ilkSayfaActualTitle = driver.getTitle();
        String ilkSayfaExpectedTitle = "The Internet";
        Assert.assertEquals(ilkSayfaExpectedTitle, ilkSayfaActualTitle);
        bekle(2);
        //  ikinci sayfaya tekrar geçin.
        bekle(2);
        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(ilkSayfaHandle);
    }
/*
//Assert.assertTrue ==> isSelected, isEnable, isDisplay ve contains tarzinda boolean donduren ifadelerde kullanilir
//Assert.assertTrue ==> ... oldugu gibi esitlik isteyen ifadelerde kullanilir
 */

    @Test
    public void test02() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText, actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//--> Kontrolümüz dışında Yeni bir sekme açıldı
        bekle(3);

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));
        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow, actualTitleNewWindow);
        /*
            getWindowHandles() methodunu kullanarak açılan tüm pencerelerin handle değerlerini bir arraylist'e atadık.
        Index 0(sıfır)'dan başladığı için kontrolüm dışında açılan pencere 1. index de olduğundan
         driver.switchTo().window(pencereler.get(1)); ile yeni açılan penceye geçiş yaptık
         */

        bekle(2);
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(pencereler.get(0));
        String ilkSayfaActualTitle = driver.getTitle();
        String ilkSayfaExpectedTitle = "The Internet";
        Assert.assertEquals(ilkSayfaExpectedTitle, ilkSayfaActualTitle);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(pencereler.get(1));
        bekle(2);
        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(pencereler.get(0));
        bekle(2);
    }

    @Test
    public void test03() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText, actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//--> Kontrolümüz dışında Yeni bir sekme açıldı
        bekle(3);

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
    /*
    Set ve ArrayList kullanmadan switchTo().window() methodu içine argüman olarak driver.getWindowHandles()
    methodunu ile bütün açılan pencereli bir array olarak alıp index belirterek isteğim pencereye geçiş yapabilirim.
     */
        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow, actualTitleNewWindow);
    /*
        getWindowHandles() methodunu kullanarak açılan tüm pencerelerin handle değerlerini bir arraylist'e atadık.
    Index 0(sıfır)'dan başladığı için kontrolüm dışında açılan pencere 1. index de olduğundan
     driver.switchTo().window(pencereler.get(1)); ile yeni açılan penceye geçiş yaptık
     */

        bekle(2);
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        String ilkSayfaActualTitle = driver.getTitle();
        String ilkSayfaExpectedTitle = "The Internet";
        Assert.assertEquals(ilkSayfaExpectedTitle, ilkSayfaActualTitle);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        bekle(2);
        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        bekle(2);
    }
    @Test
    public void test04() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //  ilk sayfadaki textin “Opening a new window” olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText, actualText);
        //  ilk sayfa Title'ının “The Internet” olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, actualTitle);
        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//--> Kontrolümüz dışında Yeni bir sekme açıldı
        bekle(3);
        //  ikinci sayfa Title'ının “New Window” olduğunu test edin.
        switchToWindow(1);
        /*
        Set ve ArrayList kullanmadan switchTo().window() methodu içine argüman olarak driver.getWindowHandles()
        methodunu ile bütün açılan pencereli bir array olarak alıp index belirterek isteğim pencereye geçiş yapabilirim.
         */
        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow, actualTitleNewWindow);
        /*
            getWindowHandles() methodunu kullanarak açılan tüm pencerelerin handle değerlerini bir arraylist'e atadık.
        Index 0(sıfır)'dan başladığı için kontrolüm dışında açılan pencere 1. index de olduğundan
         driver.switchTo().window(pencereler.get(1)); ile yeni açılan penceye geçiş yaptık
         */
        bekle(2);
        //  ilk sayfaya dönün ve Title'ının “The Internet” olduğunu test edin.
        switchToWindow(0);
        String ilkSayfaActualTitle = driver.getTitle();
        String ilkSayfaExpectedTitle = "The Internet";
        Assert.assertEquals(ilkSayfaExpectedTitle, ilkSayfaActualTitle);
        //  ikinci sayfaya tekrar geçin.
        switchToWindow(1);
        bekle(2);
        //  ilk sayfaya tekrar dönün.
        switchToWindow(0);
        bekle(2);
    }
}








