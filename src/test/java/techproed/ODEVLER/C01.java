package techproed.ODEVLER;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C01 extends TestBase {
//     -Amazon sayfasına gidelim
//    -Arama Kutusundaki Dropdown menuyu yazdıralım
//      -Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
//            başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
//            Not: Select Class'ı kullanalım

/*
@Test
public void test01() throws InterruptedException {
    //Amazon sayfasına gidelim
    driver.get("https://amazon.com");

    //Dropdown menuyu yazdıralım
    Select select = new Select(driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
    for (WebElement w:select.getOptions()) {
        System.out.println(w.getText());
    }
    System.out.println("***********************************************");

    //Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip başlık altındakileri aratalım.
    //Her aramada sayfa başlığını yazdıralım
    int sayac=1;
    for (WebElement w:select.getOptions()) {
        Select option = new Select(driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
        option.selectByIndex(sayac);
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        sayac++;
        if (sayac>=6){
            break;
 */


    @Test
    public void test01() throws InterruptedException {
        //     -Amazon sayfasına gidelim
        driver.get("https://amazon.com");

//    -Arama Kutusundaki Dropdown menuyu yazdıralım
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        List<WebElement> opsionList = select.getOptions();
        opsionList.stream().forEach(t -> System.out.println(t.getText()));
        System.out.println("***************************************");
//      -Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        for (int i = 1; i < 6; i++) {
            System.out.println(opsionList.get(i).getText());
        }
        System.out.println("***************************************");

//            başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
//            Not: Select Class'ı kullanalım


        //Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip başlık altındakileri aratalım.
        //Her aramada sayfa başlığını yazdıralım
        int sayac = 1;
        for (WebElement w : select.getOptions()) {
            Select option = new Select(driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
            option.selectByIndex(sayac);
            driver.findElement(By.xpath("//*[@type='submit']")).click();
            System.out.println(driver.getTitle());
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            sayac++;
            if (sayac >= 6) {
                break;


            }
        }
    }
}
