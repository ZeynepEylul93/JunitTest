package techproed.ODEVLER;

import org.junit.Test;

public class C07  {

    //implicitlyWait() sayfadaki tüm webelementlerin yuklenmesi icin driver'in max bekleme süresidir.Selenium tabanlidir.
    // Islem once biterse beklemez devam eder bizim isimizi %80 halleder
   //bu method ile cogu yerde isimizi halleder.Verdigimiz sure yetmezse nosuchelementexception  verir

   //explicitlywait() %20 oraninda kullaniriz. Sadece belirli bir webelement icin kullanilir.Belirli bir
   //kosul gerceklesene kadar max süre boyunca bekletir. Max süreyi biz belirleriz.
    // Default olarak kontrol etme süresi 500 ms'dir ~ yaklasik 0,5 saniye.
    //explicitlywait kullanabilmek icin==> WebdriverWait wait=new  WebdriverWait(driver,Duration.ofSeconds(20));
    //olusturdugumuz wait objesi sayesinde wait(bekle).until(oluncaya kadar) -->ExpectedConditions==beklenensart


    //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
    //- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
    //- Çizimden sonra clear butonuna basınız
    //- Sayfayi kapatiniz

}
