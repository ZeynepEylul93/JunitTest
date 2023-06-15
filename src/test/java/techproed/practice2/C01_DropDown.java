package techproed.practice2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_DropDown extends TestBase {
    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Books" secenegini secin
    // arama cubuguna "Java" aratın
    // arama sonuclarinin Java icerdigini test edin


    @Test
    public void test01() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        // dropdown'dan "Books" secenegini secin

        //DropDown 3 sekilde locate edilir

        //1->DropDown locate edilmeli
        WebElement ddm= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //2->SElect objesi olustturulmali
        Select select =new Select(ddm);

        //3->uygun bir opsiyon secilmeli
       // select.selectByVisibleText("Books");
         //select.selectByIndex(5);
        select.selectByValue("search-alias=stripbooks-intl-ship");

        // arama cubuguna "Java" aratın
      driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java"+ Keys.ENTER);

        // arama sonuclarinin Java icerdigini test edin
        String aramaSonucYazisi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        Assert.assertTrue(aramaSonucYazisi.contains("Java"));
    }
}
