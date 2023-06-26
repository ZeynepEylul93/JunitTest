package techproed.day19_ExtentReport_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C02_ExtendReport extends TestBase {
    @Test
    public void test01() {
        extentReport("Chrome","Amazon Testi");
        extentTest=extentReports.createTest("ExtentReport","Test Raporu");

        //amazon sayfasına gidiniz
        driver.get("https://amazon.com");
        extentTest.info("Amazon sayfasına gidildi");

        //sayfanın resmini alınız
        tumSayfaResmi();
        extentTest.info("Sayfanin resmi alindi");


        //arama kutusunda iphone aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama kutusunda iphone aratildi");
        extentTest.pass("Sayfa kapatildi");


    }
}
