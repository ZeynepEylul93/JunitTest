package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions extends TestBase {
    //Amazon a gidelim https://www.amazon.com/
//Sag ust bolumde bulunan "Account & Lists" menüsüne git  "Account" secenegine tikla
//Acilan sayfanin Title in "Your Account" icerdigini dogrula


    @Test
    public void test01() {
        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");

     //Sag ust bolumde bulunan "Account & Lists" menüsüne git  "Account" secenegine tikla
      WebElement accountList= driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountList).perform();
        //moveToElement() metodu ile mouse u istedigimiz webelementin uzerine goturebiliriz

        driver.findElement(By.xpath("//*[text()='Account']")).click();

    //Acilan sayfanin Title in "Your Account" icerdigini dogrula
        Assert.assertTrue(driver.getTitle().contains("Your Account"));
    }
}
