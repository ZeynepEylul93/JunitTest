package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C04_WebelementResmi extends TestBase {
    /*
    Bir webelementin resmini almak icin once webelementi locate edip bir webelmente assign ederiz.
    ve bu webelementi direk getScreenShotAs() methodunu kullanarak  resmini belirttigimiz dosyaya kaydederiz
     */
    @Test
    public void test01() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        bekle(2);

        //iphone aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);


        //Cikan sonucun resmini alalim
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/ElementResmi/WescreenShot" + tarih + ".jpeg";
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));

    }


}