package techproed.day16_SeleniumWait_ErolHoca;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import techproed.day10_ErolHoca_Alert.utilities.TestBase;

import java.time.Duration;

public class C04_ExplicitWaitClassWork extends TestBase {
    //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
//Click me to open an Alert buttonuna basalım
//Çıkan Alert'ü kapatalım
    @Test
    public void test01() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

  //Click me to open an Alert buttonuna basalım

        driver.findElement(By.xpath("(//button)[3]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());
        //Alert cikana kadar bekleyip sonra kapatacak

    //Çıkan Alert'ü kapatalım

        driver.switchTo().alert().accept();
    }
}
