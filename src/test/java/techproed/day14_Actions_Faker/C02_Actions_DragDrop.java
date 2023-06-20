package techproed.day14_Actions_Faker;

import com.beust.ah.A;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions_DragDrop extends TestBase {
    //Given user is on https://jqueryui.com/droppable/
//And user moves the target element(Drag me to my target) in to  destination(Drop here


    @Test
    public void test01() {
        //Given user is on -->  https://jqueryui.com/droppable/ adresine gidelim
        driver.get(" https://jqueryui.com/droppable/");

        // Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        /*
        drag ve drop elementleri iframe icinde oldugu icin iframe gecis yapmaliyiz
         */
        driver.switchTo().frame(0);

        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, drop).perform();

           /*
           drag-->suruklemek
           drop-->birakmak
        Eğer bir hareketli webelementi tutup başka bir webelementin üzerene bırakmak istersek
         sürüklemek istediğimiz we'tin locatini alıp üzerine bırakacağımız we'tin locate'ini de alarak
         dragAndDrop(kaynak,hedef) methodu ile işlemi gerçekleştirebiliriz

            */
    }

    @Test
    public void test02() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
    /*
    drag ve drop webelementleri iframe içinde olduğu için iframe geçiş yapmalıyız
     */
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).//-->bu metod ile webelemente mouse ile basili tuttuk
                moveToElement(drop).//-->bu metod ile basili tuttugumuz webelementi diger webelementin uzerine goturduk
                release().//-->Bu method ile basılı tuttuğumuz we'ti serbest bıraktık
                perform();//--> işlemi sonlandırdık
    }

    @Test
    public void test03() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
    /*
    drag ve drop webelementleri iframe içinde olduğu için iframe geçiş yapmalıyız
     */
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).
                moveByOffset(105,28).//-->Belirtmiş olduğumuz kordinatlara we'ti taşır
                release().perform();


    }
}
