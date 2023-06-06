package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ClassWork {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //   1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        // 2.Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();


        // 3.Login alanine “username” yazdirin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");
        // 4.Password alanine “password” yazdirin
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");
        // 5.Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        driver.navigate().back();

        // 6. online Banking altinda Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();


        // 7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//*[@id='sp_amount']")).sendKeys("45$");

        // 8.tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//*[@id='sp_date']")).sendKeys("2020-09-10", Keys.TAB,Keys.TAB,Keys.ENTER);

        // 9.Pay buttonuna tiklayin

        // 10.“The payment was successfully submitted.” mesajinin ciktigini control edin
       WebElement sonucYazisiElementi= driver.findElement(By.xpath("//*[@id='alert_content']"));
       if (sonucYazisiElementi.isDisplayed()){
           System.out.println("Test Pass");
       }else System.out.println("Test Fail");
        driver.close();







    }
}
