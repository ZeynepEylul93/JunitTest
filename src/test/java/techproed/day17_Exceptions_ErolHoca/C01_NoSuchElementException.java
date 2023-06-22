package techproed.day17_Exceptions_ErolHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.day10_ErolHoca_Alert.utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {

    @Test
    public void test01() {
        /*
        NO_SUCH_ELEMENT_EXCEPTION -->
           -Bir webelementin locate'ini yanlis aldigimizda,elementi bulamayacagi icin
           bu exception'i aliriz
         */

        //techproeducation sayfasina gidelim
        driver.get("https:/techproeducation.com");

        //reklami kapatalim
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //arama kutusunda qa aratalim
     WebElement aramaKutusu= driver.findElement(By.xpath("//*[@type='ssearch']"));
     aramaKutusu.sendKeys("qa"+ Keys.ENTER);

     //normal locatemiz bu sekilde "//*[@type='search']" iken NoSuchElementException alabilmek icin locate'i bozduk.
     //*[@type='ssearch'] ve exception'i aldigimizi gorduk. Dolayisiyla bu hatayi handle edebilmek icin
        //        duzgun locate almamiz gerekiyor.Webelement bir iframe icinde olabilir,bir butona tikladigimizda
        //yeni bir pencere acilabilir. yada alert çıkabilir bu gibi durumlarda da nosuchelementexception alırız


        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));

    }

    @Test
    public void test02() {
        //techproeducation sayfasina gidelim
        driver.get("https:/techproeducation.com");

        //reklami kapatalim
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //arama kutusunda qa aratalim
        WebElement aramaKutusu= driver.findElement(By.cssSelector("//*[@type='search']"));
        /*
        InvalidSelectorException:xpath ile aldigimiz bir webelementin locatini cssSelector locater ile
        kullanirsak bu exception u aliriz

        dolayisiyla bunu handle etmek icin dogru locater'i kullanmamiz gerekir
         */

        aramaKutusu.sendKeys("qa"+ Keys.ENTER);

        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));

    }
}
