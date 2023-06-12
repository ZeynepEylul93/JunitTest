package techproed.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {
    //techproeducation sayfasina gidiniz
    //basligin "Bootcamp" icerdigini test ediniz


    @Test
    public void test01() {
        //techproeducation sayfasina gidiniz
        driver.get("https://techproeducation.com");

        //basligin "Bootcamp" icerdigini test ediniz
     String actualTitle=driver.getTitle();
     String expectedTitle="Bootcamp";

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
}
