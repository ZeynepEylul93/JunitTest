package techproed.day21_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {

    @Test
    public void readExcelTest1() throws IOException {
        //3.satir 1. sutun degerini yazdirin ve France oldugunutest edin

        //Excel dosyasindan veri okuyabilmemiz icin;

        //1->Dosya younu aliriz
        String dosyaYolu ="src/test/java/resources/Capitals.xlsx";


        //2->Capitals dosyasini bizim sistemimize getirmeliyiz(input ettik)
        //Doosyayi okuyabilmek icin  akisa almaliyiz
        FileInputStream fis=new FileInputStream(dosyaYolu);



        //Dosyayi workbook a atamaliyiz.
        //Java ortaminda bir Excel dosyasi olusturmaliyiz
        Workbook workbook= WorkbookFactory.create(fis);

     String satir3Sutun1= workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();//Excelde index 0 dan baslar.3.satir1.sutunu getir dedik
        System.out.println(satir3Sutun1);

        Assert.assertEquals("France",satir3Sutun1);


        //Son satir sayisini bulunuz
       int sonSatirSayisi=workbook.getSheet("Sheet1").getLastRowNum();
        System.out.println("Son satir sayisi:"+sonSatirSayisi);
        //excel tablosundaki son satir sayisini getLastRowNum() metodu ile alabiliriz
        //(index olarak verir)Tam satir sayisini bulmak icin +1 yazabilriz


        //Kullanilan satir sayisini bulunuz
        // bunu getPhysicalNumberOfRows() metodu ile buluruz.bu metod indexi 1 den baslatir
       int kullanilanSatirSayisi= workbook.getSheet("Sheet1").getPhysicalNumberOfRows();
        System.out.println("(Kullanilan Satir Sayisi:"+kullanilanSatirSayisi);

        //Excel tablosundaki Kullanılan satır sayısını bulmamız için getPhysicalNumberOfRows() methodunu kullanmalıyız
       //index olarak vermez

    }

    @Test
    public void readExcelTest2() throws IOException {

        //Capitals dosyasindaki tum verileri yazdiriniz

        Map<String,String> capitalsMap=new HashMap<>();
        //Capitals dosyasindaki tum verileri koyabilecegimiz en uygun java objesi map'tir.Key-value iliskisinden dolayi

        String dosyaYolu="src/test/java/resources/Capitals.xlsx";
        FileInputStream fis= new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

       int sonSatirSayisi= workbook.getSheet("Sheet1").getLastRowNum();

        for (int i = 0; i <sonSatirSayisi ; i++) {

         String key=workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();

        String value= workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();

        capitalsMap.put(key,value);
      //  System.out.println(key+"/"+value);
        }
        System.out.println(capitalsMap);




    }
}
