package techproed.day17_exception;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_NullPointerException  {

    /*
    _NullPointerException:
    Degisken yada obje olusturup bu degiskene atama yapmadigimizda yada esitlemedigimizde _NullPointerException
    hatasi aliriz.
     */

    WebDriver driver;
    Faker faker;
    Actions actions;
    Integer sayi;
    String isim;

    @Test
    public void NullPointerException() {
        // driver = new ChromeDriver() atamasini yapmadigimiz icin NullPointerException hatasini verdi
       driver.get("https://amazon.com");

    }

    @Test
    public void NullPointerExceptionTest2() {
        //faker=new Faker();atamasini yapmadigimiz icin NullPointerException hatasi verdi
        System.out.println(faker.name().firstName());
    }

    @Test
    public void NullPointerExceptionTest3() {
      //  actions=new Actions() atamasini yapmadigimiz icin NullPointerException hatasini aldik
        actions.doubleClick().perform();
    }

    @Test
    public void NullPointerExceptionTest4() {
    //Integer sayi;objesine deger atamadigimiz icin NullPointerException hatasi aldik
        System.out.println(sayi+5);
    }

    @Test
    public void NullPointerExceptionTest5() {
        //isim objesine deger atamasi yapmadigim icin NullPointerException verdi.//isim=Zeynep;yazsaydik hata almazdik

        System.out.println(isim.charAt(0));
    }
}
