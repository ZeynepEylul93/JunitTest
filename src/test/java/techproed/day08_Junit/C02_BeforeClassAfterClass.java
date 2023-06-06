package techproed.day08_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;

public class C02_BeforeClassAfterClass {
    /*
    @BeforeClass class'ta en once calisan metoddur.
    @AfterClass class'ta en son calisan metoddur.
     @BeforeClass ve @AfterClass metodlari sadece statik metodlar ile calisir.
     @BeforeClass ve @AfterClass metodlari  clasta sadece bir kez calisir.
     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Clas'ta en once calisan metoddur");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Clas'ta en son calisan metoddur");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her Test metodundan once calisir");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her Test metodundan sonra calisir");
    }

    @Test
    public void test01() {
        System.out.println("Ilk Test");
    }

    @Test
    public void test02() {
        System.out.println("Ikinci Test");
    }
}
