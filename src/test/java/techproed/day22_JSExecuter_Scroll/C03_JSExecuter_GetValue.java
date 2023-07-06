package techproed.day22_JSExecuter_Scroll;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecuter_GetValue extends TestBase {

    //https://www.carettahotel.com adresine gidiniz


    @Test
    public void name() {
        //https://www.carettahotel.com adresine gidiniz
        driver.get("https://www.carettahotel.com");
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();

        //Check_In Date kismini JS ile locate ediniz
       JavascriptExecutor js= (JavascriptExecutor) driver;
     WebElement date= (WebElement) js.executeScript("return document.getElementById('checkin_date')");

        /*
        JavascriptExecutor js= (JavascriptExecutor) driver;
       WebElement date= (WebElement) js.executeScript("return document.querySelector(\"input[id='checkin_date']\")");
     //css_selector ile yaptik

         */


      /*
      Eger bir web sayfasinda webelemntler olusturulurken JS kullanilmissa,normal olarak locate almakta zorlanabiliriz
      Bu gibi durumlarda JSExecuter kullanarak webelementi locate edebiliriz.
       */



        //Check-In date kismina 5/25/2023 tarihini yaziniz
        date.clear();
        date.sendKeys("5/25/2023");

        //Check-In Date kisminin degerini yazdirin
     String valueAttribute= (String) js.executeScript("return document.getElementById('checkin_date').value");
        System.out.println(valueAttribute);


    }
}
