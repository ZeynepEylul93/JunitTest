package techproed.day16_SeleniumWait_ErolHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.day10_ErolHoca_Alert.utilities.TestBase;

public class C02_ExplicitWait extends TestBase {

    //https://the-internet.herokuapp.com/dynamic_loading/1
    //Start buttonuna tıkla
    //Hello World! Yazının sitede oldugunu test et

    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");


        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        //Hello World! Yazının sitede oldugunu test et

        WebElement helloWorldText= driver.findElement(By.xpath("(//h4)[2]"));
        visibleWait(helloWorldText,20);

        Assert.assertEquals("Hello World!",helloWorldText.getText());

    }

    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        visibleWait(By.xpath("(//h4)[2]"),20);
        Assert.assertEquals("Hello World!",driver.findElement(By.xpath("(//h4)[2]")).getText());
    }
}
