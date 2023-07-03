package techproed.day21_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecutor_Click extends TestBase {

    /*
    Eger bir websayfasinin HTML kodlari tamamen veya kismen JavaScript kullanilarak olusturulduysa ,
    o sayfayla etkilesimde bulunmak icin standart Webdriver komutlari yetersiz kalabilir.
    Bu durumda sayfayla etkilesime gecmek icin JavaScriptExecuter arayuzunu kullanmak gerekir.
    JavaScriptExecuter arayuzu sayfaya dogrudan erisebilir.
    Ancak mumkunse webdriwer'in sundugu standart yontemlerle sayfayla etkilesime gecmek her zaman daha iyidir
    Cunku JS kullanimi sayfanin daha yavas yuklenmesine  neden olabilir.

     */

    @Test
    public void jsExecuterClick() {
        //https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        //returns kismina tiklayin
        WebElement returns= driver.findElement(By.xpath("//a[@id='nav-orders']"));
       // returns.click();

        /*
        Ilgili webelementin HTML kodu,JavaScript kullanilarak olusturulduysa,
        standart Webdriver komutu olan click() yetersiz kalabilir.
        Boyle durumlarda JavaScriptExecuter kullanilarak sayfayla etkilesime gecillebilir
         */
        JavascriptExecutor js=(JavascriptExecutor) driver;
      // js.executeScript("arguments[0].click();",returns);

      click(returns);

    }
}
