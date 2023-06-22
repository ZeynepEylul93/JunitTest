package techproed.day17_exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C05_StaleElementRefarenceException extends TestBase {

    @Test
    public void StaleElementRefarenceException() {//elementin bayatlamasi

        // Amazon sayfasına gidelim
        driver.get("https://amazon.com");


        // arama motoruna iphone yazıp aratalım
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone" + Keys.ENTER);


        // cıkan sonuclardan ilk 5'ine tıklayıp sayfa baslıklarını alalım konsola yazdıralım

        List<WebElement> iphoneUrunleri =driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));


        for (int i = 0; i <iphoneUrunleri.size() ; i++) {

            iphoneUrunleri.get(i).click(); // StaleElementReferanceException
            System.out.println(i + ".URUN TİTLE: " + driver.getTitle());

            driver.navigate().back();

            if(i==4){
                break;
            }
        }
    }

    @Test
    public void StaleElementRefarenceExceptionTest2() {

        // Amazon sayfasına gidelim
        driver.get("https://amazon.com");


        // arama motoruna iphone yazıp aratalım
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone" + Keys.ENTER);


        // cıkan sonuclardan ilk 5'ine tıklayıp sayfa baslıklarını alalım konsola yazdıralım

        List<WebElement> iphoneUrunleri =driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));


        for (int i = 0; i <iphoneUrunleri.size() ; i++) {

            iphoneUrunleri =driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));


            iphoneUrunleri.get(i).click();
            System.out.println(i + ".URUN TİTLE: " + driver.getTitle());

            driver.navigate().back();

            if(i==4){
                break;
            }


        }

    }












}
