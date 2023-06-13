package techproed.day11_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_WindowHandle extends TestBase {
    //  https://www.techproeducation.com adresine gidiniz
//  Title'ın "Techpro Education | Online It Courses & Bootcamps" olduğunu test edin

//  Yeni bir pencere acıp,  https://www.youtube.com sayfasına gidiniz

//  Yeni bir pencere acıp, https://www.linkedin.com sayfasına gidiniz

//  techproeducation sayfasına geçiniz
//  youtube sayfasına geçiniz
//  linkedIn sayfasına geçiniz:


    @Test
    public void windowHandle() {
        //  https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        /*
        Techproeducation sayfasinin handle degerini getWindowHandle() metodu ile elde edebiliriz
         */
       String techproWindowhandle= driver.getWindowHandle();
        System.out.println("Techpro Handle :"+techproWindowhandle);

//  Title'ın "Techpro Education | Online It Courses & Bootcamps" olduğunu test edin
     String actualTitle= driver.getTitle();
     String expectedTitle="Techpro Education | Online It Courses & Bootcamps";

        Assert.assertEquals(expectedTitle,actualTitle);
bekle(3);

//  Yeni bir pencere acıp,  https://www.youtube.com sayfasına gidiniz
      driver.switchTo().newWindow(WindowType.WINDOW);//Yeni bir pencereye driver i tasir
      driver.get("https://www.youtube.com");
     String youTubeWindowHandle= driver.getWindowHandle();
        System.out.println("YouTube Window Handle degeri:"+youTubeWindowHandle);

bekle(3);
//  Yeni bir pencere acıp, https://www.linkedin.com sayfasına gidiniz
driver.switchTo().newWindow(WindowType.WINDOW);
driver.get("https://www.linkedin.com");
bekle(3);
/*
Linkedin sayfasinin handle degerini getWindowHandle() metodu ile elde edecegiz
 */
    String linkedinWindowHandle= driver.getWindowHandle();
        System.out.println("Linkedin Handle:"+linkedinWindowHandle);
bekle(3);

//  techproeducation sayfasına geçiniz
      driver.switchTo().window(techproWindowhandle);
bekle(3);
//  youtube sayfasına geçiniz
        driver.switchTo().window(youTubeWindowHandle);
bekle(3);
//  linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);

/*Eger pencere degilde sekme acmak isteseydik window tipini tabb olarak yazardik
 WindowType.TAB-->yeni sekme acar

        driver.switchTo().newWindow(WindowType.TAB);-->boyle yazardik
 */
    }
}
