package techproed.day21_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_ExcelWrite {
    @Test
    public void excelWriteTest1() throws IOException {

        //Bir "Nufus" sutunu olusturun
        //Baskent nufuslarini excel dosyasina yaziniz
        //(D.C:1100 , paris:1500, London:1200,Ankara:1300)


        String dosyaYolu="src/test/java/resources/Capitals.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //Capitals dosyasini bizim sistemimize getirdik

        Workbook workbook= WorkbookFactory.create(fis);
        //Dosyayi workbook a atadik.

        workbook.getSheet("Sheet1").getRow(0).createCell(2).setCellValue("NUFUS");
        workbook.getSheet("Sheet1").getRow(1).createCell(2).setCellValue("1100");
        workbook.getSheet("Sheet1").getRow(2).createCell(2).setCellValue("1500");
        workbook.getSheet("Sheet1").getRow(3).createCell(2).setCellValue(1200);
        workbook.getSheet("Sheet1").getRow(4).createCell(2).setCellValue(1300);

        //Excel de bir hucre olusturmak icin createCell() methodu kullanilir.
        //Hucre icine yazdiracagimiz deger icin setCellValue() methodu kullanilir

        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        //Datalari bizim class'imizsan Capitals dosyasina gonderecegiz

        workbook.write(fos);
        //workbook'taki datalari fos'a yazdik

    }
}
