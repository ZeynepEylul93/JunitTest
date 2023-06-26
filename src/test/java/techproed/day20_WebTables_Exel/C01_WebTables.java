package techproed.day20_WebTables_Exel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {
                                                       //tablonun iciyle ilgili
    //tablonun basligiyla ilgili          **           //tbody-->Tablonun ici (body)
    // thead-->Web tablosunun basligi     **           //tr-->satir
    // tr-->Satir                         **
    // td-->sutun                         **
    // th-->sutun                         **
/*
    <table> tagı ile başlar
    <thead> başlıklar için bu tag ile devam eder
    <tr> başlıkların satırı
    <th> table head sütun
    <td> başlıktaki veriler
    <tbody> başlıklar altındaki verileri temsil eder
    <tr> table row(satır)
    <td> table data (tablodaki veri)

 */
    @Test
    public void test01() {
    //https://the-internet.herokuapp.com/tables sayfasina gidin
        driver.get("https://the-internet.herokuapp.com/tables");

     //Table1'i yazdirin.
     WebElement table1=driver.findElement(By.xpath("//table[1]"));
        System.out.println("Table1:"+table1.getText());

        System.out.printf("%-10s %-10s %-25s %-10s %-30s %s%n", "Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        System.out.printf("---------- ---------- ------------------------- ---------- ------------------------------ -------%n");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Smith", "John", "jsmith@gmail.com", 50.0, "http://www.jsmith.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Bach", "Frank", "fbach@yahoo.com", 51.0, "http://www.frank.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Doe", "Jason", "jdoe@hotmail.com", 100.0, "http://www.jdoe.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Conway", "Tim", "tconway@earthlink.net", 50.0, "http://www.timconway.com", "edit delete");
    }

    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/tables sayfasina gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        //3. satir verilerini yazdirin
     List<WebElement> list=driver.findElements(By.xpath("//table[1]//tbody//tr[3]//td"));
     list.stream().forEach(t-> System.out.print(t.getText()+"-"));
    }

    @Test
    public void test03() {
        //https://the-internet.herokuapp.com/tables sayfasina gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        //Son satirin verilerini yazdirin
        List<WebElement> sonSatirVerileri=driver.findElements(By.xpath("//table[1]//tbody//tr[4]//td"));
        sonSatirVerileri.stream().forEach(t-> System.out.print(t.getText()+"--"));

      //  List<WebElement> sonSatirVerilerii = driver.findElements(By.xpath("//table[1]//tbody//tr[last()]//td"));
    //"//table[1]//tbody//tr[last()]//td")-->son satiri almak icin last yazdik

    }

    @Test
    public void test04() {
        //https://the-internet.herokuapp.com/tables sayfasina gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        //5.sutunun basligini yazdirin
        WebElement besincisutunBasligi= driver.findElement(By.xpath("//table[1]//thead//tr[1]//th[5]"));
        System.out.println(besincisutunBasligi.getText());

        //5.sutun verilerini yazdirin
      List<WebElement> besinciSutunVerileri=  driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
      besinciSutunVerileri.stream().forEach(t-> System.out.println(t.getText()+"-"));
    }

    @Test
    public void test05() {
        //https://the-internet.herokuapp.com/tables sayfasina gidin
        driver.get("https://the-internet.herokuapp.com/tables");


    // iki parametreli bir java methodu olusturalım
    // Parametre 1 => satır numarasını
   // Parametre 2 => sutun numarası

    // prinData(2,3) ==> 2. satır, 3. sutundaki veriyi yazdırın
        printData(2,3);

    }

    //print Data metodu
    public void printData(int satir,int sutun){
       WebElement satirSutun= driver.findElement(By.xpath("//table[1]//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(satirSutun.getText());
    }


}
