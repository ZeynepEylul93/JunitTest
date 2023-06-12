package techproed.day10_ErolHoca_Alert;

import org.junit.Assert;
import org.junit.Test;
import techproed.day10_ErolHoca_Alert.utilities.TestBase;

public class C01_TestBase_Demo extends TestBase {
    @Test
    public void test01() {
    //Techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");

        //Uc saniye bekle    //handle-->halletmek
        bekle(3);

   // Basligin Bootcamp icerdigini test edin
        String actualTitle= driver.getTitle();
        String expectedTitle="Bootcamp";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
       // assert actualTitle.contains(expectedTitle);==>bu da javadan gelen assert kullanimi
    }
}
