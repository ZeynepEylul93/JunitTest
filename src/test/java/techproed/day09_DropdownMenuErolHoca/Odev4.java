package techproed.day09_DropdownMenuErolHoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev4 {
    //BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
  //Before methodunda http://www.google.com adresine gidin
   //Üç farklı test methodu ile;
  //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
   //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
  //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
  //After method'u ile başlıkları yazdırınız
  //AfterClass ile browser'ı kapatınız

  static  WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        //BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Before
    public void setUp() throws Exception {
        //Before methodunda http://www.google.com adresine gidin
        driver.get("http://www.google.com");
    }

    @Test
    public void test01() {
        //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
        WebElement aramaKutusu= driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
      aramaKutusu.sendKeys("The God Father"+ Keys.ENTER);
      WebElement TheGodFather= driver.findElement(By.xpath("//*[@id='result-stats']"));
      String []sonucYazisi=TheGodFather.getText().split(" ");//Yaklaşık 129.000.000 sonuç bulundu (0,61 saniye)
       System.out.println("Got Father Sonuc Sayisi"+sonucYazisi[1]);
    }

    @Test
    public void test02() {
        //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
        WebElement aramaKutusu= driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        aramaKutusu.sendKeys("Lord of the Rings"+Keys.ENTER);
        driver.navigate().refresh();
       WebElement lordoftheRings= driver.findElement(By.xpath("//div[@id='result-stats']"));
      String []sonucYazisi= lordoftheRings.getText().split(" ");

        System.out.println("sonuc sayisi :"+sonucYazisi[1]);
    }

    @Test
    public void test03() throws InterruptedException {
        //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
        WebElement aramaKutusu= driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        aramaKutusu.sendKeys("Kill Bill"+Keys.ENTER);

         WebElement killBill= driver.findElement(By.xpath("//div[@class='WE0UJf']"));
        String[] sonucYazisi= killBill.getText().split(" ");
        System.out.println("Kill Bill sonuc Sayisi:"+sonucYazisi[1]);

    }

    @After
    public void tearDown() throws Exception {
        //After method'u ile başlıkları yazdırınız
        System.out.println(driver.getTitle());
    }

    @AfterClass
    public static void afterClass() throws Exception {
        //AfterClass ile browser'ı kapatınız
        driver.close();
    }
}
