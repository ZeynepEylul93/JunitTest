package techproed.day09_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {

    // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
    // Programlama Dili Dropdown'undan "Java" seciniz
    // Programlama Dili Dropdown'undan son secilen option'un "Java" oldugunu test ediniz
    // Programlama Dili Dropdown'undaki tum optionları konsolda yazdırınız

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() {
        // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");


        // Programlama Dili Dropdown'undan "Java" seciniz
     WebElement ddmProgramlamaDili= driver.findElement(By.xpath("//select[@name='Languages']"));//dd'i handle ettik
        Select select=new Select(ddmProgramlamaDili);//select objesini olusturdum
        select.selectByVisibleText("Java");//-->istedigim opsiyonu gorundugu sekilde parantezin icine yaz dedim.dropdown da nasil gorunuyorsa oyle
        //select.selectByValue("java");
      //  select.selectByIndex(0);

        // Programlama Dili Dropdown'undan son secilen option'un "Java" oldugunu test ediniz
       WebElement sonSecilenOpsiyon= select.getFirstSelectedOption();
      String sonSecilenopsiyonStr= sonSecilenOpsiyon.getText();

        Assert.assertEquals("Java",sonSecilenopsiyonStr);



        // Programlama Dili Dropdown'undaki tum optionları konsolda yazdırınız
       List<WebElement> tumOpsiyonlar= select.getOptions();

      // tumOpsiyonlar.stream().forEach(t-> System.out.println(t.getText()));-->lambda

        for (WebElement each:tumOpsiyonlar) {
            System.out.println(each.getText());

        }
        System.out.println("*******************************************************");
        //Sayfadaki butun Dropdown'lardaki tum optionlari konsola yazdir
     List<WebElement> tumDropDownTumOptionlar=  driver.findElements(By.tagName("option"));

       for (WebElement each:tumDropDownTumOptionlar) {
            System.out.println(each.getText());
       }


       // tumDropDownTumOptionlar.stream().forEach(t-> System.out.println(t.getText()));-->Lambda



    }
}
