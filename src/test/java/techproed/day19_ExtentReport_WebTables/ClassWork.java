package techproed.day19_ExtentReport_WebTables;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClassWork extends TestBase {
    ExtentReports extentReports;
    ExtentHtmlReporter extentHtmlReporter;
    ExtentTest extentTest;

    @Test
    public void name() {
        extentReports=new ExtentReports();
        String tarih=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());

        String dosyaYolu="target/raporlar/Rapor"+tarih+".html";
        extentHtmlReporter=new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);

        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Zeynep");
        extentHtmlReporter.config().setDocumentTitle("extent Report");

        //amazon sayfasina gidelim
        driver.get("https://amazon.com");



        //basligin  Amazon icerdigini test edelim

        //Arama kutusunda iphone aratalim

        //sonuc yazisini konsola yazdiralim


    }


}
