package techproed.day07_MavenJunit_Erol;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //https://id.heroku.com/login sayfasina gidin
//Bir mail adersi giriniz
//Login butonuna tiklayiniz
// "There was a problem with your login." texti gorunur ise
//"kayit yapilamadi" yazdiriniz
//eger yazi gorunur degilse "kayit yapildi" yazdiriniz
//sayfayı kapatiniz

        /*
        a.Verilen web sayfasına gidin.
https://the-internet.herokuapp.com/checkboxes
b.Checkbox1 ve checkbox2 elementlerini locate edin.
c.Checkbox1 seçili değilse onay kutusunu tıklayın
d.Checkbox2 seçili değilse onay kutusunu tıklayın


*********************************************
-https://www.facebook.com adresine gidin
-Cookies’i kabul edin
-“Create an Account” button’una basin
-“radio buttons” elementlerini locate edin
-Secili degilse cinsiyet butonundan size uygun olani secin
         */
    }
}
