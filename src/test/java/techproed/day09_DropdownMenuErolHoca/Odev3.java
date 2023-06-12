package techproed.day09_DropdownMenuErolHoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Odev3 {
 //  1.http://zero.webappsecurity.com/ Adresine gidin
 //  2.Sign in butonuna basin
 //3.Login kutusuna “username” yazin
  //4.Password kutusuna “password.” yazin
//5.Sign in tusuna basin(not: navigate.Back yapınız)
//6.Pay Bills sayfasina gidin
//7.“Purchase Foreign Currency” tusuna basin
//8.“Currency” drop down menusunden Eurozone’u secin
//9.“amount” kutusuna bir sayi girin
//10.“US Dollars” in secilmedigini test edin
//11.“Selected currency” butonunu secin
//12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
//“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
       // driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //  1.http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //  2.Sign in butonuna basin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();


        //3.Login kutusuna “username” yazin
        //4.Password kutusuna “password.” yazin
        //5.Sign in tusuna basin(not: navigate.Back yapınız)
       WebElement loginKutusu= driver.findElement(By.xpath("//*[@id='user_login']"));
       loginKutusu.sendKeys("username", Keys.TAB,"password",Keys.TAB,Keys.TAB,Keys.ENTER);

       driver.navigate().back();
       driver.navigate().back();


       //6.Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

    //7.“Purchase Foreign Currency” tusuna basin
       driver.findElement(By.linkText("Purchase Foreign Currency")).click();


   //8.“Currency” drop down menusunden Eurozone’u secin
     WebElement ddm= driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Eurozone (euro)");

  //9.“amount” kutusuna bir sayi girin
     driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys("100");

   //10.“US Dollars” in secilmedigini test edin
      WebElement radioButton=  driver.findElement(By.xpath("//input[@id='pc_inDollars_true']"));
        Assert.assertFalse(radioButton.isSelected());

   //11.“Selected currency” butonunu secin
        driver.findElement(By.xpath("//input[@id='pc_inDollars_false']")).click();

   //12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();

   //“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
       WebElement sonucYazisi= driver.findElement(By.xpath("//*[text()='Foreign currency cash was successfully purchased.']"));
        System.out.println(sonucYazisi.getText());
    }
}
