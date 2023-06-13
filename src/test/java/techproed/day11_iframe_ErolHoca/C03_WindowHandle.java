package techproed.day11_iframe_ErolHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import techproed.day10_ErolHoca_Alert.utilities.TestBase;

public class C03_WindowHandle extends TestBase {
    //Window 1'de https://www.techproeducation.com adresine gidiniz
//Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
//Window 2'de https://www.youtube.com sayfasını açınız:
//Window 3'te https://www.linkedin.com sayfasını açınız:
//techproeducation sayfasına geçiniz:
//youtube sayfasına geçiniz:
//linkedIn sayfasına geçiniz:
    @Test
    public void windowHandle() {
        /*

        Eger sayfaya gittikten sonra yeni sekme yada yeni bir pencereyle baska sayfaya gittikten sonra
        tekrar ilk actiginiz sayfaya donmek isterseniz, ilk sayfaya driver.get() methoduyla gittikten sonra
        String bir degisken handle degerini assign ederseniz tekrar ilk acilan sayfaya donmek istediginizde
        driver.switchTo().window(ilksayfaHandleDegeri) ile gecis yapabilirsiniz
        ilk geciste newWindow deriz.eger zaten acik sayfalar arasinda gecis yapmak istersek  driver.switchTo().window(ilksayfaHandleDegeri)
         */
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproedWindowHandle= driver.getWindowHandle();

//Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle= driver.getTitle();
        String expectedTitle="Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle,actualTitle);

//Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().//-->Gecis yap
                newWindow(WindowType.WINDOW);//-->Yeni bir pencereye driver'i tasir.
       // WindowType.TAB-->Yeni bir sekme acar

       driver.get("https://www.youtube.com");
      String youTubeWindowHandle=driver.getWindowHandle();


//Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle=driver.getWindowHandle();


//techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproedWindowHandle);

//youtube sayfasına geçiniz:
        driver.switchTo().window(youTubeWindowHandle);

//linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);

    }

    @Test
    public void test02() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproedWindowHandle= driver.getWindowHandle();

//Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle= driver.getTitle();
        String expectedTitle="Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle,actualTitle);

//Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().//-->Gecis yap
                newWindow(WindowType.TAB);//-->Yeni bir pencereye driver'i tasir.
        // WindowType.TAB-->Yeni bir sekme acar

        driver.get("https://www.youtube.com");
        String youTubeWindowHandle=driver.getWindowHandle();


//Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle=driver.getWindowHandle();


//techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproedWindowHandle);

//youtube sayfasına geçiniz:
        driver.switchTo().window(youTubeWindowHandle);

//linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);

    }

}

