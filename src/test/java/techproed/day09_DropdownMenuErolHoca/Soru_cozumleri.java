package techproed.day09_DropdownMenuErolHoca;
 /*
public class Soru_cozumleri {


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v111.page.Page;
import org.openqa.selenium.support.ui.Select;
​
        import java.time.Duration;
import java.util.List;
​
    public class C01 {
​
        WebDriver driver;
​
        @Before
        public void before()  {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            //●https://the-internet.herokuapp.com/dropdown adresine gidin.
            driver.get("https://the-internet.herokuapp.com/dropdown");
        }
​
        ​
        @Test
        public void Test01() {
​
            //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
            WebElement optionAll = driver.findElement(By.xpath("//select[@id='dropdown']"));
            Select select = new Select(optionAll);
            select.selectByIndex(1);
            System.out.println(select.getFirstSelectedOption().getText());
            bekle(3);
​
            //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
            select.selectByValue("2");
            bekle(4);
            //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
            select.selectByVisibleText("Option 1");
            System.out.println(select.getFirstSelectedOption().getText());
            //4.Tüm dropdown değerleri(value) yazdırın
            select.getOptions().forEach(t-> System.out.println(t.getText()));
            //5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
            //False yazdırın.
            List<WebElement> boyut=driver.findElements(By.xpath("//select[@id='dropdown']"));
            Assert.assertTrue(select.getOptions().size()==4);
​
            //List<WebElement> boyut=driver.findElements(By.xpath("//option"));
            //Assert.assertTrue(boyut.size()==4);
            //(//option)[position()>1] ilk optionı almaz
​
​
​
​
​
​
        }
​
        public void bekle(int saniye){
            try {
                Thread.sleep(saniye*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
​
            }
​
​
        }
    }
}

     *************************************************************

     ​
public class C02 {
​
​
    WebDriver driver;
​
    @Before
    public void before()  {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://www.amazon.com/ adresine gidin.
        driver.get("https://amazon.com");
    }
​
​
    @Test
    public void Test01() {
         //-Test 1
         //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
         //oldugunu test edin
         WebElement katagori=driver.findElement(By.xpath("//select[@title='Search in']"));
         Select select=new Select(katagori);
         Assert.assertTrue(select.getOptions().size()==45);
​
​
​
​
​
    }
​
    @Test
    public void test02() {
​
        //-Test 2
        // 1.Kategori menusunden Books secenegini secin
        WebElement katagori=driver.findElement(By.xpath("//select[@title='Search in']"));
        Select select=new Select(katagori);
        select.selectByVisibleText("Books");
        // 2.Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        // 3.Bulunan sonuc sayisini yazdirin
        WebElement sonuc=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String[] sonucYazısı=sonuc.getText().split(" ");
        // 4.Sonucun Java kelimesini icerdigini test edin
        Assert.assertTrue(sonuc.getText().contains("Java"));
​
​
​
    }
}*************************************************************************************************

​
public class C03 {
    WebDriver driver;
​
    @Before
    public void before()  {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1.http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
    }
​

    @Test
    public void test01() {
​
       //2.Sign in butonuna basin
        driver.findElement(By.cssSelector("button[id='signin_button']")).click();
       //3.Login kutusuna “username” yazin
        driver.findElement(By.cssSelector("input#user_login")).sendKeys("username");
       //4.Password kutusuna “password.” yazin
        driver.findElement(By.cssSelector("#user_password")).sendKeys("password");
       //5.Sign in tusuna basin(not: navigate.Back yapınız)
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.navigate().back();
        driver.navigate().refresh();
       //6.Pay Bills sayfasina gidin
        driver.findElement(By.cssSelector("#onlineBankingMenu")).click();
        driver.findElement(By.cssSelector("#pay_bills_link")).click();
       //7.“Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[@href='#ui-tabs-3']")).click();
​
       //8.“Currency” drop down menusunden Eurozone’u secin
        WebElement option= driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select=new Select(option);
        select.selectByVisibleText("Eurozone (euro)");
​
       //9.“amount” kutusuna bir sayi girin
        driver.findElement(By.cssSelector("#pc_amount")).sendKeys("24");
​
       //10.“US Dollars” in secilmedigini test edin
        Assert.assertFalse(driver.findElement(By.cssSelector("#pc_inDollars_true")).isSelected());
​
       //11.“Selected currency” butonunu secin
        driver.findElement(By.cssSelector("#pc_inDollars_false")).click();
​
       //12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.cssSelector("#pc_calculate_costs")).click();
        driver.findElement(By.xpath("(//input[@class='btn btn-primary'])[2]")).click();
​
       //“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
        Assert.assertTrue(driver.findElement(By.cssSelector("div#alert_content")).isDisplayed());
​
    }
}
​
public class C04 {
    WebDriver driver;
​
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
​
​
    }
​
   @Test
   public void test01() {
​
       //Amazon sayfasına gidelim
       driver.get("https://amazon.com");
       //-Arama Kutusundaki Dropdown menuyu yazdıralım
       WebElement ddm=driver.findElement(By.xpath("//select[@title='Search in']"));
       Select select=new Select(ddm);
       select.getOptions().forEach(t-> System.out.println(t.getText()));
       //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
       //başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım

​
​
       for (int i = 1; i < 5; i++) {
           List<WebElement> options=select.getOptions();
           options.get(i).click();
           System.out.println(driver.getTitle());
​
       }
​
​
       // Not: Select Class'ı kullanalım

*/