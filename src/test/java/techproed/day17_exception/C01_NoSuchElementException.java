package techproed.day17_exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {

    @Test
    public void NoSuchElementException() {
         /*
        NoSuchElementException:
         Sayfada bulunmayan bir elemenente erisim saglanmaya calisildiginde
        NoSuchElementException hatasi aliriz.
        Locate'i yanlis alinca --NoSuchElementException--aliriz
         */

        //techproEducation sayfasina gidiniz.
        driver.get("https://techproeducation.com");

     //reklami kapatiniz
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

     //searchBox'a java yazip aratalim
        driver.findElement(By.xpath("//input[@id='Yanlis--elementor-search-form-9f26725']")).sendKeys("Java"+ Keys.ENTER);

    }
}
